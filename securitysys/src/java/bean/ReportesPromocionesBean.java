/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Promocion;
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
@ManagedBean(name = "ReportesPromocionesBean")
@ViewScoped
@Data
public class ReportesPromocionesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(ReportesPromocionesBean.class.getName());

    private ArrayList<Promocion> listaPromocion = new ArrayList<>();
    private List<Promocion> filteredPromociones;

    
    @EJB
    private bean.PromocionFacade promocionFacade;

    private Promocion promocion;

    @PostConstruct
    void initialiseSession() {
        cargarTabRepoSolicitud();
    }

    public void cargarTabRepoSolicitud() {
        try {
            listaPromocion = new ArrayList<>();
            for (Promocion pro : promocionFacade.findAll()) {
                listaPromocion.add(pro);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mostrarReporte(BigDecimal vNroPromocion) {
        System.out.println("mostrando Reporte");

        //Obtener Current FacesContext
        String pdf = "Promocion_" + vNroPromocion;
        try {

            Class.forName("org.postgresql.Driver");
            Connection cnPostgres = DriverManager.getConnection("jdbc:postgresql://localhost:5432/security", "postgres", "1234");

            JasperReport facturaReport = null;
            Map<String, Object> map = new HashMap<String, Object>();

            System.out.println("vNroPromocion:" + vNroPromocion);
            if (vNroPromocion != null) {
                int sucursalFactura = vNroPromocion.intValue();
                map.put("NRO", sucursalFactura);
                String pathReporte = "C:\\develop\\Securitysys\\securitysys\\src\\java\\reportes\\reporte_promociones.jasper";
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
                    FacesContext.getCurrentInstance().addMessage("generalMessage", 
                            new FacesMessage(FacesMessage.SEVERITY_INFO, "Promocion enviada a la impresora", ""));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("generalMessage", 
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay Promocion que mostrar para los valores ingresados", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("generalMessage", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un error al generar reporte de la Promocion", ""));
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

    public ArrayList<Promocion> getListaPromocion() {
        return listaPromocion;
    }

    public void setListaPromocion(ArrayList<Promocion> listaPromocion) {
        this.listaPromocion = listaPromocion;
    }

    public List<Promocion> getFilteredPromociones() {
        return filteredPromociones;
    }

    public void setFilteredPromociones(List<Promocion> filteredPromociones) {
        this.filteredPromociones = filteredPromociones;
    }

    public PromocionFacade getPromocionFacade() {
        return promocionFacade;
    }

    public void setPromocionFacade(PromocionFacade promocionFacade) {
        this.promocionFacade = promocionFacade;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
    
    
}
