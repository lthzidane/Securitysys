/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import entities.InstalacionCab;
import entities.OrdenTrabajoCab;
import entities.OrdenTrabajoDet;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
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

    private ArrayList<OrdenTrabajoCab> listaOrdenesTrabajo = new ArrayList<>();
    private ArrayList<InstalacionCab> listaInstalaciones = new ArrayList<>();

    private ArrayList<OrdenTrabajoCab> listaRepoOrdenesTrabajo = new ArrayList<>();
    private List<OrdenTrabajoDet> listaRepoOrdenesTrabajoDet = new ArrayList<>();

    private List<OrdenTrabajoCab> filteredOrdenesTrabajo;

    private LineChartModel animatedModelOT;
    private LineChartModel animatedModelIns;

    private Date fromFecOT;
    private Date toFecOT;

    private static final Logger LOG = Logger.getLogger(ReportesOTBean.class.getName());
    /**
     * String Base64 that represents the image bytes
     */
    private String chartImageSrcBase64;

    @EJB
    private bean.OrdenTrabajoCabFacade ordenTrabajoCabFacade;
    @EJB
    private bean.InstalacionCabFacade instalacionCabFacade;

    @EJB
    private bean.OrdenTrabajoDetFacade ordenTrabajoDetFacade;

    private OrdenTrabajoCab ordenTrabajoCab;
    private InstalacionCab instalacionCab;

    @PostConstruct
    void initialiseSession() {
        createAnimatedModels();
        cargarVista();
    }

    public void cargarVista() {

        try {

            listaRepoOrdenesTrabajo = new ArrayList<>();
            for (OrdenTrabajoCab ot : ordenTrabajoCabFacade.findAll()) {
                if (ot.getOrdenTrabajoDetList().isEmpty()) {
                    listaRepoOrdenesTrabajoDet = ordenTrabajoDetFacade.findByNroOrden(ot.getNroOrden().intValue());
                    if (listaRepoOrdenesTrabajoDet.size() > 0) {
                        ot.setOrdenTrabajoDetList(listaRepoOrdenesTrabajoDet);
                    }
                }

                listaRepoOrdenesTrabajo.add(ot);
            }

//            listaInstalaciones = new ArrayList<InstalacionCab>();
//            for(InstalacionCab ic : instalacionCabFacade.findAll()){
//                listaInstalaciones.add(ic);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createAnimatedModels() {

        listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
        for (OrdenTrabajoCab ot : ordenTrabajoCabFacade.findAll()) {
            listaOrdenesTrabajo.add(ot);
        }
        animatedModelOT = initLinearModelOT();
        animatedModelOT.setTitle("Ordenes de Trabajo por mes");
        animatedModelOT.setAnimate(true);
        animatedModelOT.setLegendPosition("se");
        animatedModelOT.setShowPointLabels(true);
        animatedModelOT.getAxes().put(AxisType.X, new CategoryAxis("Dias del Mes"));
        animatedModelOT.getAxis(AxisType.Y).setLabel("Ordenes de Trabajo");
        animatedModelOT.getAxis(AxisType.Y).setMin(0);
        animatedModelOT.getAxis(AxisType.Y).setMax(10);

        listaInstalaciones = new ArrayList<InstalacionCab>();
        for (InstalacionCab ic : instalacionCabFacade.findAll()) {
            listaInstalaciones.add(ic);
        }
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

        int mes; //iniciamos en Noviembre que es 10, porque Enero es 0
        int cant = 0;
        dia = -1; //primer día
        boolean cambioMes = false;
        for (OrdenTrabajoCab ot : listaOrdenesTrabajo) {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(ot.getFechaOrden());

            mes = fecha.get(Calendar.MONTH); //obtengo el mes para saber en que lista va
            if (mes == Calendar.NOVEMBER) {
                //es serie1
                if (fecha.get(Calendar.DAY_OF_MONTH) > dia) { //si es ya otra fecha
                    dia = fecha.get(Calendar.DAY_OF_MONTH); //obtengo el día
                    cant = 0;
                }
                series1.set(dia, ++cant);
            } else {
                //es serie2, debo cerar los días y el contador
                if (!cambioMes) {
                    cambioMes = true;
                    dia = -1;
                    cant = 0;
                }
                if (fecha.get(Calendar.DAY_OF_MONTH) > dia) { //si es ya otra fecha
                    dia = fecha.get(Calendar.DAY_OF_MONTH); //obtengo el día
                    cant = 0;
                }
                series2.set(dia, ++cant);
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

        int mes; //iniciamos en Noviembre que es 10, porque Enero es 0
        int cant = 0;
        dia = -1; //primer día
        boolean cambioMes = false;
        for (InstalacionCab ins : listaInstalaciones) {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(ins.getFechainstalacion());

            mes = fecha.get(Calendar.MONTH); //obtengo el mes para saber en que lista va
            if (mes == Calendar.NOVEMBER) {
                //es serie1
                if (fecha.get(Calendar.DAY_OF_MONTH) > dia) { //si es ya otra fecha
                    dia = fecha.get(Calendar.DAY_OF_MONTH); //obtengo el día
                    cant = 0;
                }
                series1.set(dia, ++cant);
            } else {
                //es serie2, debo cerar los días y el contador
                if (!cambioMes) {
                    cambioMes = true;
                    dia = -1;
                    cant = 0;
                }
                if (fecha.get(Calendar.DAY_OF_MONTH) > dia) { //si es ya otra fecha
                    dia = fecha.get(Calendar.DAY_OF_MONTH); //obtengo el día
                    cant = 0;
                }
                series2.set(dia, ++cant);
            }
        }

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

    public void exportOT2Pdf() {
        System.out.println("exportando a pdf");

        if (chartImageSrcBase64 != null) {
            System.out.println("Se cargó la imagen");
            System.out.println("La imagen es: " + chartImageSrcBase64.substring(chartImageSrcBase64.lastIndexOf(",") + 1));
        } else {
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
            PdfWriter.getInstance(document, res.getOutputStream());
            document.open();
            byte[] decoded = Base64.decodeBase64(chartImageSrcBase64.substring(chartImageSrcBase64.lastIndexOf(",") + 1).getBytes());
            Image image = Image.getInstance(decoded);
            int indentation = 0;
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image.getWidth()) * 100;
            image.scalePercent(scaler);
            document.add(image);
            document.close();
//            
//            ServletOutputStream out = res.getOutputStream();
//            out.write( document. );
//            out.flush();
//            out.close();

            System.out.println("Exportacion terminada");
        } catch (Exception e) {
            e.printStackTrace();
        }

        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportIns2Pdf() {
        System.out.println("exportando a pdf");

        if (chartImageSrcBase64 != null) {
            System.out.println("Se cargó la imagen");
        } else {
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
            PdfWriter.getInstance(document, res.getOutputStream());
            document.open();
            byte[] decoded = Base64.decodeBase64(chartImageSrcBase64.substring(chartImageSrcBase64.lastIndexOf(",") + 1).getBytes());
            Image image = Image.getInstance(decoded);
            int indentation = 0;
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image.getWidth()) * 100;
            image.scalePercent(scaler);
            document.add(image);
            document.close();
            System.out.println("Exportacion terminada");
        } catch (Exception e) {
            e.printStackTrace();
        }

        FacesContext.getCurrentInstance().responseComplete();
    }

    public boolean filterByDate(Object value, Object filter, Locale locale) {

        String filterText = (filter == null) ? null : filter.toString().trim();

        System.out.println("filterText: " + filterText);

        if (filterText == null || filterText.isEmpty()) {
            return true;
        }
        if (value == null) {
            return false;
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date filterDate = (Date) value;

        System.out.println("filterDate: " + filterDate);

        Date dateFrom;
        Date dateTo;
        try {
            String fromPart = filterText.substring(0, filterText.indexOf("-"));
            String toPart = filterText.substring(filterText.indexOf("-") + 1);
            dateFrom = fromPart.isEmpty() ? null : df.parse(fromPart);
            dateTo = toPart.isEmpty() ? null : df.parse(toPart);
        } catch (ParseException pe) {
            LOG.log(Level.SEVERE, "unable to parse date: " + filterText, pe);
            return false;
        }

        return (dateFrom == null || filterDate.after(dateFrom) || filterDate.equals(dateFrom))
                && (dateTo == null || filterDate.before(dateTo) || filterDate.equals(dateTo));
    }

    public List<OrdenTrabajoCab> getFilteredOrdenesTrabajo() {
        return filteredOrdenesTrabajo;
    }

    public void setFilteredOrdenesTrabajo(List<OrdenTrabajoCab> filteredOrdenesTrabajo) {
        this.filteredOrdenesTrabajo = filteredOrdenesTrabajo;
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException, ParseException {
        com.lowagie.text.Document pdf = (com.lowagie.text.Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "Security.png";

        pdf.add(com.lowagie.text.Image.getInstance(logo));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        String startDateToStr = format.format(fromFecOT);
        String stopDateToStr = format.format(toFecOT);

        if (fromFecOT != null && toFecOT != null) {
            pdf.add(new Paragraph("Ordenes de Trabajo del " + startDateToStr + " hasta " + stopDateToStr));
        } else {
            pdf.add(new Paragraph("Todas las Ordenes de Trabajo existentes"));
        }

        pdf.add(new Paragraph(" "));
    }

    public void filtrarFechasOT() {

        Date startDate = fromFecOT;
        Date endDate = toFecOT;

        if (startDate == null && endDate == null) {
            cargarVista();
        } else {
            listaRepoOrdenesTrabajo = new ArrayList<>();
            for (OrdenTrabajoCab ot : ordenTrabajoCabFacade.findBetweenFechaOrden(startDate, endDate)) {
                System.out.println("ot.NroOrden:" + ot.getNroOrden() + " cantDet:" + ot.getOrdenTrabajoDetList().size());

                if (ot.getOrdenTrabajoDetList().isEmpty()) {
                    listaRepoOrdenesTrabajoDet = ordenTrabajoDetFacade.findByNroOrden(ot.getNroOrden().intValue());
                    if (listaRepoOrdenesTrabajoDet.size() > 0) {
                        ot.setOrdenTrabajoDetList(listaRepoOrdenesTrabajoDet);
                        System.out.println("seteo la cantitad real: " + listaRepoOrdenesTrabajoDet.size());
                    }
                }

                listaRepoOrdenesTrabajo.add(ot);
            }
        }

    }

}
