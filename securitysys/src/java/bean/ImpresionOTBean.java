/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.Cliente;
import entities.EstadoTrab;
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
@ManagedBean(name="ImpresionOTBean")
@ViewScoped
@Data
public class ImpresionOTBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<OrdenTrabajoCab> listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
    private ArrayList<OrdenTrabajoCab> filteredListOTs = new ArrayList<OrdenTrabajoCab>();
    
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
    
    private OrdenTrabajoCab ordenTrabajoCab;
    private OrdenTrabajoDet ordenTrabajoDet;
    
    private Connection con = null;
    
    @PostConstruct
    void initialiseSession() {
        con = DataConnect.getConnection();
        this.cargarVista();
    }   
    
    
    public void cargarVista() {

        try {

            listaOrdenesTrabajo = new ArrayList<OrdenTrabajoCab>();
            obtenerOrdenesTrabajo();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void obtenerOrdenesTrabajo() {
        for(OrdenTrabajoCab ot : ordenTrabajoCabFacade.findAll() ) {
            listaOrdenesTrabajo.add(ot);
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
            obtenerOrdenesTrabajo();
        }
    }
    
    public void mostrarReporte(BigDecimal vNroOrden){
        System.out.println("mostrando Reporte");
    
        //Obtener Current FacesContext
        String pdf = "Orden_Trabajo_"+vNroOrden;
        try{
            
            Class.forName("org.postgresql.Driver");
            Connection cnPostgres = DriverManager.getConnection("jdbc:postgresql://localhost:5432/securitysys", "postgres", "1234");
          
            JasperReport facturaReport = null;
            Map<String, Object> map = new HashMap<String, Object>();

            System.out.println("vNroOrden:"+vNroOrden);
            if( vNroOrden != null ){    
                int sucursalFactura = vNroOrden.intValue();
                map.put("NRO", sucursalFactura);
                String pathReporte = "C:\\test\\Securitysys\\securitysys\\src\\java\\reportes\\reporte_test.jasper";
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
            }else{
                FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay Facturas que mostrar para los valores ingresados", ""));
            }

        }catch(Exception e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("generalMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrió un error al generar la factura", ""));
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
    
}
