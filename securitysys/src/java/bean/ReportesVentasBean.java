/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import entities.Venta;
import entities.VentaDet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
import util.numbers2word.SpanishNumber;

/**
 *
 * @author moreno
 */
@ManagedBean(name = "ReportesVentasBean")
@ViewScoped
@Data
public class ReportesVentasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(ReportesVentasBean.class.getName());

    private ArrayList<Venta> listaVenta = new ArrayList<>();
    private List<Venta> filteredVentas;

    private Date fromFecVent;
    private Date toFecVent;

    @EJB
    private bean.VentaFacade ventaFacade;

    @EJB
    private bean.VentaDetFacade ventaDetFacade;

    private Venta venta;

    @PostConstruct
    void initialiseSession() {
        cargarTabRepoVenta();
    }

    public void cargarTabRepoVenta() {
        try {
            listaVenta = new ArrayList<>();
            for (Venta vent : ventaFacade.findAll()) {
                listaVenta.add(vent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException, ParseException {
        com.lowagie.text.Document pdf = (com.lowagie.text.Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.LEGAL.rotate());

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "Security.png";

        pdf.add(com.lowagie.text.Image.getInstance(logo));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

        if (fromFecVent != null && toFecVent != null) {
            String startDateToStr = format.format(fromFecVent);
            String stopDateToStr = format.format(toFecVent);
            pdf.add(new Paragraph("Ventas del " + startDateToStr + " hasta " + stopDateToStr));
        } else {
            pdf.add(new Paragraph("Todas los Ventas existentes"));
        }

        pdf.add(new Paragraph(" "));
    }

    public void filtrarFechasVent() {
        Date startDate = fromFecVent;
        Date endDate = toFecVent;

        if (startDate == null && endDate == null) {
            cargarTabRepoVenta();
        } else {
            listaVenta = new ArrayList<>();
            for (Venta rcl : ventaFacade.findBetweenfechaVenta(startDate, endDate)) {
                listaVenta.add(rcl);
            }
        }

    }

    public ArrayList<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(ArrayList<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public List<Venta> getFilteredVentas() {
        return filteredVentas;
    }

    public void setFilteredVentas(List<Venta> filteredVentas) {
        this.filteredVentas = filteredVentas;
    }

    public Date getFromFecVent() {
        return fromFecVent;
    }

    public void setFromFecVent(Date fromFecVent) {
        this.fromFecVent = fromFecVent;
    }

    public Date getToFecVent() {
        return toFecVent;
    }

    public void setToFecVent(Date toFecVent) {
        this.toFecVent = toFecVent;
    }

    public VentaFacade getVentaFacade() {
        return ventaFacade;
    }

    public void setVentaFacade(VentaFacade ventaFacade) {
        this.ventaFacade = ventaFacade;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void mostrarReporteVentas(BigDecimal vNroVenta) {
        System.out.println("mostrando Reporte");

        //Obtener Current FacesContext
        String pdf = "Factura_" + vNroVenta;
        try {

            Class.forName("org.postgresql.Driver");
            Connection cnPostgres = DriverManager.getConnection("jdbc:postgresql://localhost:5432/security", "postgres", "1234");

            JasperReport facturaReport = null;
            Map<String, Object> map = new HashMap<String, Object>();

            System.out.println("vNroVenta:" + vNroVenta);
            if (vNroVenta != null) {
                int sucursalFactura = vNroVenta.intValue();
                map.put("NumFactura", sucursalFactura);

                int sumaFactura = getSumaFactura(ventaDetFacade.findByIdVenta(sucursalFactura));

                System.out.println("Cantidad Detalle:" + sumaFactura);

                map.put("SumaTotal", sumaFactura);
                map.put("NumLiteral", new SpanishNumber(sumaFactura));

                String pathReporte = "C:\\develop\\Securitysys\\securitysys\\src\\java\\reportes\\jcReportFactura.jasper";
                facturaReport = (JasperReport) JRLoader.loadObject(new FileInputStream(pathReporte));
            }

            JasperPrint p = JasperFillManager.fillReport(facturaReport, map, cnPostgres);

            int cantPaginas = p.getPages().size();
            System.out.println("Cantidad de Páginas del reporte: " + cantPaginas);

            if (cantPaginas > 0) {
                byte[] reportByte = JasperExportManager.exportReportToPdf(p);
                // si se genero un reporte, se muestra, y registra su cantidad
                if (reportByte != null) {
                    showPDFventa(reportByte, pdf);
                    //crearArchivoDesdeByteArray(reportByte, pdf);
                    FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Factura enviada a la impresora", ""));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay Factura que mostrar para los valores ingresados", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un error al generar la Factura", ""));
        }
    }

    public void showPDFventa(byte[] bytes, String name) throws IOException {
        // set cookie to be able to ask it and close status dialog for example
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.addResponseCookie("cookie.pdf.exporting", "true", Collections.<String, Object>emptyMap());

        HttpServletResponse res = (HttpServletResponse) externalContext.getResponse();
        res.setContentType("application/pdf");
        res.setHeader("Content-disposition", "attachment; filename=" + name + ".pdf");

        try {
            ServletOutputStream out = res.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();

        } catch (IOException ex) {
            throw ex;
        }

        FacesContext.getCurrentInstance().responseComplete();
    }

    private int getSumaFactura(List<VentaDet> listaVenta) {
        int sumaFactura = 0;
        if (listaVenta != null && listaVenta.size() > 0) {

            for (VentaDet det : listaVenta) {
                int cantidad = det.getCantidad();
                int precioVenta = det.getPrecioVenta();
                int totalUnidad = cantidad*precioVenta;
                
                sumaFactura += totalUnidad; 
            }

        }

        return sumaFactura;
    }
}
