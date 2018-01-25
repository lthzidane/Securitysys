/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.OrdenTrabajo;
import entities.OrdenTrabajoDet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.data.FilterEvent;

/**
 *
 * @author sebas
 */
@ManagedBean(name="ImpresionOTBean")
@ViewScoped
@Data
public class ImpresionOTBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<OrdenTrabajo> listaOrdenesTrabajo = new ArrayList<OrdenTrabajo>();
    private ArrayList<OrdenTrabajo> filteredListOTs = new ArrayList<OrdenTrabajo>();
    
    @EJB
    private bean.TecnicoFacade tecnicoFacade =  new TecnicoFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.EstadoFacade estadoTrabFacade = new EstadoFacade();
    @EJB
    private bean.OrdenTrabajoFacade ordenTrabajoCabFacade;
    @EJB
    private bean.OrdenTrabajoDetFacade ordenTrabajoDetFacade;
    
    private OrdenTrabajo ordenTrabajoCab;
    private OrdenTrabajoDet ordenTrabajoDet;
    
    private Connection con = null;
    
    @PostConstruct
    void initialiseSession() {
        con = DataConnect.getConnection();
        this.cargarVista();
    }   
    
    
    public void cargarVista() {

        try {

            setListaOrdenesTrabajo(new ArrayList<OrdenTrabajo>());
            obtenerOrdenesTrabajo();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void obtenerOrdenesTrabajo() {
        for(OrdenTrabajo ot : ordenTrabajoCabFacade.findAll() ) {
            getListaOrdenesTrabajo().add(ot);
        }
        
    }
    
    public void onRowFilterOT(FilterEvent event){
        DataTable table = (DataTable) event.getSource();
        Map<String, Object>  filters = table.getFilters();
        System.out.println("filters.Size: "+filters.size());
        System.out.println("filters: "+filters);
        
        if (filters.isEmpty()) {
            System.out.println("Filtro por primera vez todos");
            getListaOrdenesTrabajo().clear();
            obtenerOrdenesTrabajo();
        }
    }
    
    public void mostrarReporte(BigDecimal vNroOrden){
        System.out.println("mostrando Reporte");
    
        //Obtener Current FacesContext
        String pdf = "Orden_Trabajo_"+vNroOrden;
        try{
            
            Class.forName("org.postgresql.Driver");
            Connection cnPostgres = DriverManager.getConnection("jdbc:postgresql://localhost:5432/security", "postgres", "1234");
          
            JasperReport facturaReport = null;
            Map<String, Object> map = new HashMap<String, Object>();

            System.out.println("vNroOrden:"+vNroOrden);
            if( vNroOrden != null ){    
                int sucursalFactura = vNroOrden.intValue();
                map.put("NRO", sucursalFactura);
                String pathReporte = "C:\\develop\\Securitysys\\securitysys\\src\\java\\reportes\\reporte_test.jasper";
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
                    FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "OT enviada a la impresora", ""));
                }
            }else{
                FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay OT que mostrar para los valores ingresados", ""));
            }

        }catch(Exception e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un error al generar la OT", ""));
        } 
    }
        
        
    public void showPDFventa( byte[] bytes, String name) throws IOException {
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
 
    
    public static void addSuccessMessage(String client, String message) {
        FacesContext.getCurrentInstance().addMessage(client, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }        

    /**
     * @return the listaOrdenesTrabajo
     */
    public ArrayList<OrdenTrabajo> getListaOrdenesTrabajo() {
        return listaOrdenesTrabajo;
    }

    /**
     * @param listaOrdenesTrabajo the listaOrdenesTrabajo to set
     */
    public void setListaOrdenesTrabajo(ArrayList<OrdenTrabajo> listaOrdenesTrabajo) {
        this.listaOrdenesTrabajo = listaOrdenesTrabajo;
    }
    
}
