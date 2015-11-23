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
    private List<OrdenTrabajoDet> listaOrdenesTrabajoDet = new ArrayList<OrdenTrabajoDet>();
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
                System.out.println("ot.NroOrden:"+ot.getNroOrden()+" cantDet:"+ot.getOrdenTrabajoDetList().size());
                
                if(ot.getOrdenTrabajoDetList().isEmpty()){
                    listaOrdenesTrabajoDet = ordenTrabajoDetFacade.findByNroOrden(ot.getNroOrden().intValue());
                    if(listaOrdenesTrabajoDet.size() > 0){
                        ot.setOrdenTrabajoDetList(listaOrdenesTrabajoDet);
                        System.out.println("seteo la cantitad real: "+listaOrdenesTrabajoDet.size());
                    }
                }
                
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
    
    public void eliminarOT(){
        System.out.println("Eliminar Orden de Trabajo");
        //ordenTrabajoCab se setea con el item de la fila, via el serPropertyActionListener
        persistOTCab(PersistAction.DELETE, "Orden de Trabajo eliminada correctamente");
        cargarVista();
    }
    
    public void eliminarInstalacion(){
        System.out.println("Eliminar Instalacion");
        //instalacionCab se setea con el item de la fila, via el serPropertyActionListener
        persistInstalCab(PersistAction.DELETE, "Instalacion eliminada correctamente");
        cargarVista();
        
    }
    
    private void persistInstalCab(JsfUtil.PersistAction persistAction, String successMessage) {
        if (instalacionCab != null) {

            try {
                if (persistAction == JsfUtil.PersistAction.CREATE) {
                    instalacionCabFacade.create(instalacionCab);
                }
                else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    instalacionCabFacade.edit(instalacionCab);
                } else {
                    instalacionCabFacade.remove(instalacionCab);
                }
                
                if(successMessage != null){
                    JsfUtil.addSuccessMessage(successMessage);
                }
                
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    
    
    private void persistOTCab(JsfUtil.PersistAction persistAction, String successMessage) {
        if (ordenTrabajoCab != null) {

            try {
                if (persistAction == JsfUtil.PersistAction.CREATE) {
                    ordenTrabajoCabFacade.create(ordenTrabajoCab);
                } else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    ordenTrabajoCabFacade.edit(ordenTrabajoCab);
                } else {
                    ordenTrabajoCabFacade.remove(ordenTrabajoCab);
                }

                if (successMessage != null) {
                    JsfUtil.addSuccessMessage(successMessage);
                }

            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause(); 
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    Exception cbe = ex.getCausedByException();
                    if(cbe != null){
                        if(cbe.getCause() != null){
                            if (cbe.getCause().getLocalizedMessage().contains("viola la llave foránea")){
                                msg = "La Orden de Trabajo no puede ser borrada debido a que esta asociada a una Instalación";
                            }
                        }
                    }
                    
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    
}
