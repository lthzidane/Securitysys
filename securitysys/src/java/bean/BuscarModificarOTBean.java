/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.InstalacionCab;
import entities.InstalacionDet;
import entities.OrdenTrabajo;
import entities.OrdenTrabajoDet;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.data.FilterEvent;
import session.util.JsfUtil;

/**
 *
 * @author sebas
 */
@ManagedBean(name="BuscarModificarOTBean")
@ViewScoped
@Data
public class BuscarModificarOTBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList<OrdenTrabajo> listaOrdenesTrabajo = new ArrayList<OrdenTrabajo>();
    private List<OrdenTrabajoDet> listaOrdenesTrabajoDet = new ArrayList<OrdenTrabajoDet>();
    private ArrayList<OrdenTrabajo> filteredListOTs = new ArrayList<OrdenTrabajo>();
    
    private ArrayList<InstalacionCab> listaInstalaciones = new ArrayList<InstalacionCab>();
    private ArrayList<InstalacionCab> filteredListInstal = new ArrayList<InstalacionCab>();
    
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
    @EJB
    private bean.InstalacionCabFacade instalacionCabFacade;
    @EJB
    private bean.InstalacionDetFacade insalacionDetFacade;
    
    
    private OrdenTrabajo ordenTrabajoCab;
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

            listaOrdenesTrabajo = new ArrayList<OrdenTrabajo>();
            for (OrdenTrabajo ot : ordenTrabajoCabFacade.findAll()) {
                System.out.println("ot.NroOrden:"+ot.getIdOt()+" cantDet:"+ot.getOrdenTrabajoDetList().size());
                
                if(ot.getOrdenTrabajoDetList().isEmpty()){
                    listaOrdenesTrabajoDet = ordenTrabajoDetFacade.findByNroOrden(ot.getIdOt().intValue());
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
            for (OrdenTrabajo ot : ordenTrabajoCabFacade.findAll()) {
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
    
//    public void eliminarOT(){
//        System.out.println("Eliminar Orden de Trabajo");
//        //ordenTrabajoCab se setea con el item de la fila, via el serPropertyActionListener
//        persistOTCab(DELETE, "Orden de Trabajo eliminada correctamente");
//        cargarVista();
//    }
//    
//    public void eliminarInstalacion(){
//        System.out.println("Eliminar Instalacion");
//        //instalacionCab se setea con el item de la fila, via el serPropertyActionListener
//        persistInstalCab(DELETE, "Instalacion eliminada correctamente");
//        cargarVista();
//        
//    }
//    
//    private void persistInstalCab(JsfUtil.PersistAction persistAction, String successMessage) {
//        if (instalacionCab != null) {
//
//            try {
//                if (persistAction == JsfUtil.PersistAction.CREATE) {
//                    instalacionCabFacade.create(instalacionCab);
//                }
//                else if (persistAction == JsfUtil.PersistAction.UPDATE) {
//                    instalacionCabFacade.edit(instalacionCab);
//                } else {
//                    instalacionCabFacade.remove(instalacionCab);
//                }
//                
//                if(successMessage != null){
//                    JsfUtil.addSuccessMessage(successMessage);
//                }
//                
//            } catch (EJBException ex) {
//                String msg = "";
//                Throwable cause = ex.getCause();
//                if (cause != null) {
//                    msg = cause.getLocalizedMessage();
//                }
//                if (msg.length() > 0) {
//                    JsfUtil.addErrorMessage(msg);
//                } else {
//                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//            }
//        }
//    }
//    
//    
//    private void persistOTCab(JsfUtil.PersistAction persistAction, String successMessage) {
//        if (ordenTrabajoCab != null) {
//
//            try {
//                if (persistAction == JsfUtil.PersistAction.CREATE) {
//                    ordenTrabajoCabFacade.create(ordenTrabajoCab);
//                } else if (persistAction == JsfUtil.PersistAction.UPDATE) {
//                    ordenTrabajoCabFacade.edit(ordenTrabajoCab);
//                } else {
//                    ordenTrabajoCabFacade.remove(ordenTrabajoCab);
//                }
//
//                if (successMessage != null) {
//                    JsfUtil.addSuccessMessage(successMessage);
//                }
//
//            } catch (EJBException ex) {
//                String msg = "";
//                Throwable cause = ex.getCause(); 
//                if (cause != null) {
//                    msg = cause.getLocalizedMessage();
//                }
//                if (msg.length() > 0) {
//                    Exception cbe = ex.getCausedByException();
//                    if(cbe != null){
//                        if(cbe.getCause() != null){
//                            if (cbe.getCause().getLocalizedMessage().contains("viola la llave foránea")){
//                                msg = "La Orden de Trabajo no puede ser borrada debido a que esta asociada a una Instalación";
//                            }
//                        }
//                    }
//                    
//                    JsfUtil.addErrorMessage(msg);
//                } else {
//                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//            }
//        }
//    }
    
}
