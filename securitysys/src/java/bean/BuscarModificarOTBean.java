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
import session.ClienteController;
import session.TecnicosController;
import session.util.JsfUtil;
import session.util.JsfUtil.PersistAction;
import util.Sale;

/**
 *
 * @author sebas
 */
@ManagedBean(name="BuscarModificarOTBean")
@ViewScoped
@Data
public class BuscarModificarOTBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<OrdenTrabajoCab> listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
    private ArrayList<OrdenTrabajoCab> filteredListOTs = new ArrayList<OrdenTrabajoCab>();
    
    private ArrayList<InstalacionCab> listaInstalaciones = new ArrayList<InstalacionCab>();
    private ArrayList<InstalacionCab> filteredListInstal = new ArrayList<InstalacionCab>();
    
    @EJB
    private bean.TecnicosFacade tecnicoFacade =  new TecnicosFacade();
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
        this.cargarVista();
    }   
    
    
    public void cargarVista() {

        try {

            listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
            for (OrdenTrabajoCab ot : ordenTrabajoCabFacade.findAll()) {
                listaOrdenesTrabajo.add(ot);
            }
            
            listaInstalaciones = new ArrayList<InstalacionCab>();
            for(InstalacionCab ic : instalacionCabFacade.findAll()){
                listaInstalaciones.add(ic);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void onRowFilterOT(FilterEvent event){
        DataTable table = (DataTable) event.getSource();
        Map<String, Object>  filters = table.getFilters();
        System.out.println("filters.Size: "+filters.size());
        System.out.println("filters: "+filters);
        
        if (filters.isEmpty()) {
            System.out.println("Filtro por primera vez todos");
            listaOrdenesTrabajo.clear();
            for (OrdenTrabajoCab ot : ordenTrabajoCabFacade.findAll()) {
                listaOrdenesTrabajo.add(ot);
            }
        }
    }
    
    public void onRowFilterIns(FilterEvent event){
        DataTable table = (DataTable) event.getSource();
        Map<String, Object>  filters = table.getFilters();
        System.out.println("filters.Size: "+filters.size());
        System.out.println("filters: "+filters);
        
        if (filters.isEmpty()) {
            System.out.println("Filtro por primera vez todos");
            listaInstalaciones.clear();
            for (InstalacionCab ot : instalacionCabFacade.findAll()) {
                listaInstalaciones.add(ot);
            }
        }
    }
    
    public void modificarOT(){
        System.out.println("Modificar Orden de Trabajo");
    }
    
    public void EliminarOT(){
        System.out.println("Eliminar Orden de Trabajo");
    }
    
    public void modificarInstal(){
        System.out.println("Modificar Instalacion");
    }
    
    public void EliminarInstal(){
        System.out.println("Eliminar Instalacion");
    }
    
}
