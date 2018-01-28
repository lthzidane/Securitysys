/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Solicitud;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author sebas
 */
@ManagedBean(name = "ReportesSolicitudBean")
@ViewScoped
@Data
public class ReportesSolicitudBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(ReportesSolicitudBean.class.getName());

    private ArrayList<Solicitud> listaSolicitud = new ArrayList<>();
    private List<Solicitud> filteredSolicidudes;

    private Date fromFecSolic;
    private Date toFecSolic;

    @EJB
    private bean.SolicitudFacade solicitudFacade;

    private Solicitud solicitud;

    @PostConstruct
    void initialiseSession() {
        cargarTabRepoSolicitud();
    }

    public void cargarTabRepoSolicitud() {
        try {
            listaSolicitud = new ArrayList<>();
            for (Solicitud sol : solicitudFacade.findAll()) {
                listaSolicitud.add(sol);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Date getFromFecSolic() {
        return fromFecSolic;
    }

    public void setFromFecSolic(Date fromFecSolic) {
        this.fromFecSolic = fromFecSolic;
    }

    public Date getToFecSolic() {
        return toFecSolic;
    }

    public void setToFecSolic(Date toFecSolic) {
        this.toFecSolic = toFecSolic;
    }

    public ArrayList<Solicitud> getListaSolicitud() {
        return listaSolicitud;
    }

    public void setListaSolicitud(ArrayList<Solicitud> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }

    public List<Solicitud> getFilteredSolicidudes() {
        return filteredSolicidudes;
    }

    public void setFilteredSolicidudes(List<Solicitud> filteredSolicidudes) {
        this.filteredSolicidudes = filteredSolicidudes;
    }

    public SolicitudFacade getSolicitudFacade() {
        return solicitudFacade;
    }

    public void setSolicitudFacade(SolicitudFacade solicitudFacade) {
        this.solicitudFacade = solicitudFacade;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public void mostrarReporte(BigDecimal vNroSolicitud) {
        System.out.println("mostrando Reporte");

        //Obtener Current FacesContext
        String pdf = "Solicitud_" + vNroSolicitud;
        try {

            Class.forName("org.postgresql.Driver");
            Connection cnPostgres = DriverManager.getConnection("jdbc:postgresql://localhost:5432/security", "postgres", "1234");

            JasperReport facturaReport = null;
            Map<String, Object> map = new HashMap<String, Object>();

            System.out.println("vNroSolicitud:" + vNroSolicitud);
            if (vNroSolicitud != null) {
                int sucursalFactura = vNroSolicitud.intValue();
                map.put("NRO", sucursalFactura);
                String pathReporte = "C:\\develop\\Securitysys\\securitysys\\src\\java\\reportes\\reporte_solicitudes.jasper";
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
                    FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Solicitud enviada a la impresora", ""));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay Solicitud que mostrar para los valores ingresados", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un error al generar la Solicitud", ""));
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
}
