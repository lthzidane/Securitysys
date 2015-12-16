/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cliente;
import entities.EstadoTrab;
import entities.InstalacionCab;
import entities.InstalacionDet;
import entities.OrdenTrabajoCab;
import entities.OrdenTrabajoDet;
import entities.Tecnicos;
import entities.TipoServicios;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.data.FilterEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import session.ClienteController;
import session.TecnicosController;
import session.util.JsfUtil;
import session.util.JsfUtil.PersistAction;
import util.Sale;

/**
 *
 * @author sebas
 */
@ManagedBean(name = "ReportesOTBean")
@ViewScoped
@Data
public class ReportesOTBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<OrdenTrabajoCab> listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
    private List<OrdenTrabajoDet> listaOrdenesTrabajoDet = new ArrayList<OrdenTrabajoDet>();
    private ArrayList<OrdenTrabajoCab> filteredListOTs = new ArrayList<OrdenTrabajoCab>();

    private ArrayList<InstalacionCab> listaInstalaciones = new ArrayList<InstalacionCab>();
    private ArrayList<InstalacionCab> filteredListInstal = new ArrayList<InstalacionCab>();

    private LineChartModel animatedModel1;

    @EJB
    private bean.TecnicosFacade tecnicoFacade = new TecnicosFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.TipoServiciosFacade tipoServiciosFacade = new TipoServiciosFacade();
    @EJB
    private bean.EstadoTrabFacade estadoTrabFacade = new EstadoTrabFacade();
    @EJB
    private bean.OrdenTrabajoCabFacade ordenTrabajoCabFacade;
    @EJB
    private bean.OrdenTrabajoDetFacade ordenTrabajoDetFacade;
    @EJB
    private bean.InstalacionCabFacade instalacionCabFacade;
    @EJB
    private bean.InstalacionDetFacade insalacionDetFacade;

    private OrdenTrabajoCab ordenTrabajoCab;
    private OrdenTrabajoDet ordenTrabajoDet;

    private InstalacionCab instalacionCab;
    private InstalacionDet instalacionDet;

    private Connection con = null;

    @PostConstruct
    void initialiseSession() {
        con = DataConnect.getConnection();
        cargarVista();
        createAnimatedModels();
    }

    public void cargarVista() {
        try {
            listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
            for (OrdenTrabajoCab ot : ordenTrabajoCabFacade.findAll()) {
                listaOrdenesTrabajo.add(ot);
            }

            listaInstalaciones = new ArrayList<InstalacionCab>();
            for (InstalacionCab ic : instalacionCabFacade.findAll()) {
                listaInstalaciones.add(ic);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Ordenes de Trabajo por mes");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        animatedModel1.setShowPointLabels(true);
        animatedModel1.getAxes().put(AxisType.X, new CategoryAxis("Dias del Mes"));
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Ordenes de Trabajo");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Noviembre");
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Diciembre");
        
        
        int dia = 1;
        for (dia = 1; dia <= 31; dia++) {
            series1.set(dia, 0); //inicialmente todos los dias son cero
            series2.set(dia, 0); //inicialmente todos los dias son cero
        }
        
        int mes = 10; //iniciamos en Noviembre que es 10, porque Enero es 0
        int cant = 0;
        dia = 1;
        for(OrdenTrabajoCab ot :listaOrdenesTrabajo){
            //System.out.println("fecha: "+ot.getFechaOrden());
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(ot.getFechaOrden());
            
            //System.out.println("mes,dia -> "+fecha.get(Calendar.MONTH)+","+fecha.get(Calendar.DAY_OF_MONTH));
            //System.out.println("es el día " + dia);
            if( fecha.get(Calendar.MONTH) == mes ){
                if (fecha.get(Calendar.DAY_OF_MONTH) == dia) {
                    cant = cant+1;
                    series1.set(dia, cant);
                    //System.out.println("cantidad es " + cant);
                }else if( fecha.get(Calendar.DAY_OF_MONTH) > dia  ){
                    //ya me pase, aumento el dia y cero el contador
                    while(fecha.get(Calendar.DAY_OF_MONTH) > dia ){
                        dia++;
                    }
                    cant = 0;
                    series1.set(dia, cant = cant+1);
                    //System.out.println("cantidad es " + cant);
                }
            }else if( fecha.get(Calendar.MONTH) > mes ){
                mes = mes+1;
                dia = 1;
                cant = 0;
                if (fecha.get(Calendar.DAY_OF_MONTH) == dia) {
                    cant = cant+1;
                    series2.set(dia, cant);
                    //System.out.println("cantidad es " + cant);
                }else if( fecha.get(Calendar.DAY_OF_MONTH) > dia  ){
                    //ya me pase, aumento el dia y cero el contador
                    while(fecha.get(Calendar.DAY_OF_MONTH) > dia ){
                        dia++;
                    }
                    cant = 0;
                    series2.set(dia, cant = cant+1);
                    //System.out.println("cantidad es " + cant);
                }
            } 
        }
        
//        series1.set(1, 2);
//        series1.set(2, 1);
//        series1.set(3, 3);
//        series1.set(4, 6);
//        series1.set(5, 8);
//
//        LineChartSeries series2 = new LineChartSeries();
//        series2.setLabel("Series 2");
//
//        series2.set(1, 6);
//        series2.set(2, 3);
//        series2.set(3, 2);
//        series2.set(4, 7);
//        series2.set(5, 9);

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

}
