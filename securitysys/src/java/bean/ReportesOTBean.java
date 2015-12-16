/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import entities.InstalacionCab;
import entities.OrdenTrabajoCab;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.apache.commons.codec.binary.Base64;

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
    
    private ArrayList<InstalacionCab> listaInstalaciones = new ArrayList<InstalacionCab>();
    
    private LineChartModel animatedModelOT;
    private LineChartModel animatedModelIns;

    /** String Base64 that represents the image bytes */
    private String chartImageSrcBase64; 
    
    @EJB
    private bean.OrdenTrabajoCabFacade ordenTrabajoCabFacade;
    @EJB
    private bean.InstalacionCabFacade instalacionCabFacade;
    
    private OrdenTrabajoCab ordenTrabajoCab;
    
    private InstalacionCab instalacionCab;
    
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

    public void createAnimatedModels() {
        if(animatedModelOT == null){
            animatedModelOT = initLinearModelOT();
            animatedModelOT.setTitle("Ordenes de Trabajo por mes");
            animatedModelOT.setAnimate(true);
            animatedModelOT.setLegendPosition("se");
            animatedModelOT.setShowPointLabels(true);
            animatedModelOT.getAxes().put(AxisType.X, new CategoryAxis("Dias del Mes"));
            animatedModelOT.getAxis(AxisType.Y).setLabel("Ordenes de Trabajo");
            animatedModelOT.getAxis(AxisType.Y).setMin(0);
            animatedModelOT.getAxis(AxisType.Y).setMax(10);
        }
        
        if (animatedModelIns == null) {
            animatedModelIns = initLinearModelIns();
            animatedModelIns.setTitle("Instalaciones por mes");
            animatedModelIns.setAnimate(true);
            animatedModelIns.setLegendPosition("se");
            animatedModelIns.setShowPointLabels(true);
            animatedModelIns.getAxes().put(AxisType.X, new CategoryAxis("Dias del Mes"));
            animatedModelIns.getAxis(AxisType.Y).setLabel("Instalaciones");
            animatedModelIns.getAxis(AxisType.Y).setMin(0);
            animatedModelIns.getAxis(AxisType.Y).setMax(10);
        }

    }

    private LineChartModel initLinearModelOT() {
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

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

    private LineChartModel initLinearModelIns() {
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
        for(InstalacionCab ins :listaInstalaciones){
            //System.out.println("fecha: "+ot.getFechaOrden());
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(ins.getFechainstalacion());
            
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

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }
   
    public void exportOT2Pdf(){
        System.out.println("exportando a pdf");
        
        if(chartImageSrcBase64 != null){
            System.out.println("Se cargó la imagen");
            System.out.println("La imagen es: "+ chartImageSrcBase64.substring(chartImageSrcBase64.lastIndexOf(",")+1));
        }else{
            System.out.println("no se guardó la imagen");
            return;
        }
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.addResponseCookie("cookie.pdf.exporting", "true", Collections.<String, Object>emptyMap());
        
        HttpServletResponse res = (HttpServletResponse) externalContext.getResponse();
        res.setContentType("application/pdf");
        res.setHeader("Content-disposition", "attachment; filename=Reporte_Ordenes_de_Trabajo.pdf");

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, res.getOutputStream() );
            document.open();
            byte[] decoded = Base64.decodeBase64(chartImageSrcBase64.substring(chartImageSrcBase64.lastIndexOf(",")+1 ).getBytes()) ;
            Image image = Image.getInstance(decoded);
            int indentation = 0;
            float scaler = ( (document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image.getWidth() )*100;
            image.scalePercent(scaler);
            document.add(image);
            document.close();
//            
//            ServletOutputStream out = res.getOutputStream();
//            out.write( document. );
//            out.flush();
//            out.close();
            
            System.out.println("Exportacion terminada");
        } catch (Exception e){
            e.printStackTrace();
        }
        
        FacesContext.getCurrentInstance().responseComplete();
    }


    public void exportIns2Pdf(){
        System.out.println("exportando a pdf");
        
        if(chartImageSrcBase64 != null){
            System.out.println("Se cargó la imagen");
        }else{
            System.out.println("no se guardó la imagen");
            return;
        }
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.addResponseCookie("cookie.pdf.exporting", "true", Collections.<String, Object>emptyMap());
        
        HttpServletResponse res = (HttpServletResponse) externalContext.getResponse();
        res.setContentType("application/pdf");
        res.setHeader("Content-disposition", "attachment; filename=Reporte_Instalaciones.pdf");

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, res.getOutputStream() );
            document.open();
            byte[] decoded = Base64.decodeBase64(chartImageSrcBase64.substring(chartImageSrcBase64.lastIndexOf(",")+1 ).getBytes()) ;
            Image image = Image.getInstance(decoded);
            int indentation = 0;
            float scaler = ( (document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image.getWidth() )*100;
            image.scalePercent(scaler);
            document.add(image);
            document.close();
            System.out.println("Exportacion terminada");
        } catch (Exception e){
            e.printStackTrace();
        }
        
        FacesContext.getCurrentInstance().responseComplete();
    }
}
