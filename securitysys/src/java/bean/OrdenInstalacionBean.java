/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.Cliente;
import entities.EstadoTrab;
import entities.OrdenTrabajoCab;
import entities.OrdenTrabajoDet;
import entities.ProductosKit;
import entities.Tecnicos;
import entities.TipoServicios;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Data;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import session.ClienteController;
import session.TecnicosController;
import session.util.JsfUtil;
import session.util.JsfUtil.PersistAction;
import util.Sale;

/**
 *
 * @author sebas
 */
@ManagedBean(name="OrdenInstalacionBean")
@ViewScoped
@Data
public class OrdenInstalacionBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nroDeInstalacion;
    private String equipo; 
    private BigDecimal pedido;
    private String estado;
    private String description;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRecepcion;
    private Date fechaOrden;
    private String tipoInstalacion;
    private Integer idTecnico;
    private String tecnicoResponsable;
    private Integer idCliente;
    private Integer idEstadoTrab;
    private Integer idServicio;
    private String tipoServicio;
    private String nroOrden;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String observacion;
    private ArrayList<TipoServicios> listaServicios = new ArrayList<TipoServicios>();
    private ArrayList<Tecnicos> listaTecnicos = new ArrayList<Tecnicos>();
    private List<EstadoTrab> listaEstados = new ArrayList<EstadoTrab>();
    private ArrayList<OrdenTrabajoDet> listaDetalle = new ArrayList<OrdenTrabajoDet>();
    private List<ProductosKit> listaKits = new ArrayList<ProductosKit>();
    private ArrayList<ProductosKit> selectedKits = new ArrayList<ProductosKit>();
    private ArrayList<Tecnicos> selectedTecnicos = new ArrayList<Tecnicos>();
    
    @EJB
    private bean.TecnicosFacade tecnicoFacade =  new TecnicosFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.TipoServiciosFacade tipoServiciosFacade = new TipoServiciosFacade();
    @EJB
    private bean.EstadoTrabFacade estadoTrabFacade = new EstadoTrabFacade();
    @EJB
    private bean.OrdenTrabajoCabFacade ejbCabFacade;
    @EJB
    private bean.OrdenTrabajoDetFacade ejbDetFacade;
    
    @EJB
    private bean.ProductosKitFacade productoKitFacade = new ProductosKitFacade();
    
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

            nroDeInstalacion = "000"+String.valueOf(obtenerNroOrden()+1) ;

            Date date = Calendar.getInstance().getTime();
            fechaOrden = date;
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            fechaRecepcion = today;

            this.listaServicios = obtenerTiposDeServicio();
            this.listaTecnicos = obtenerTecnicos();
            this.listaEstados = estadoTrabFacade.findAll();
            this.idEstadoTrab = 1; //poner a Pendiente = 1 por defecto
 
            this.listaKits = productoKitFacade.findAll();
            
            description = "";

            listaDetalle = new ArrayList<OrdenTrabajoDet>();
    
                this.idCliente = null;
                this.idTecnico = null;
                this.fechaInicio = null;
                this.fechaFin = null;
                this.idServicio = null;
                this.nroOrden = "";
                this.nroDocumento = "";
                this.ciudad = "";
                this.telefono = "";
                this.direccion = "";
                this.razonsocial = "";
            
            /*for(int i=0; i<10; i++){
                OrdenTrabajoDet otd = new OrdenTrabajoDet( BigDecimal.valueOf(i)  , "Tarea "+i);
                this.listaDetalle.add(otd);
            }*/
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public int obtenerNroOrden() {
        int ultimoValor = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT last_value FROM nro_orden_orden_trabajo_cab_seq_1");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               BigDecimal uv =  rs.getBigDecimal("last_value");
               
               ultimoValor = uv.toBigInteger().intValue();
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Tipos de Servicio -->" + ex.getMessage());
        }

        return ultimoValor;
    }

   
    public String guardarOrdenTrabajo(){
        
        ordenTrabajoCab = new OrdenTrabajoCab();
        ordenTrabajoCab.setIdTecnico( tecnicoFacade.findByIdTecnico(idTecnico) );
        ordenTrabajoCab.setIdCliente( clienteFacade.findByIdCliente(idCliente) );
        ordenTrabajoCab.setIdReclamo( null );
        ordenTrabajoCab.setFechaOrden( fechaOrden );
        ordenTrabajoCab.setIdEstado( null );
        ordenTrabajoCab.setIdServicio( tipoServiciosFacade.findByIdServicio(idServicio) );
        ordenTrabajoCab.setIdEstadoTrab( estadoTrabFacade.findByIdEstadoTrab(idEstadoTrab) );
        
        persistOTCab(PersistAction.CREATE, null);
        System.out.println("se guardó la OTCab con exito > "+JsfUtil.isValidationFailed());
        
        persistOTDet(PersistAction.CREATE, listaDetalle, "Orden de Trabajo guardada correctamente");
        
        System.out.println("se guardó la OTDet con exito");
        
        //limpiar campos
        cargarVista();
        
        //return "/home";
        return null;
    }
    
    public String volver(){
        return "/home";
    }
    
    public void addTarea(){
        int i = this.listaDetalle.size() + 1;
        OrdenTrabajoDet otd = new OrdenTrabajoDet( BigDecimal.valueOf(i)  , "");
        this.listaDetalle.add(otd);
    }
    
    private ArrayList<TipoServicios> obtenerTiposDeServicio() {
        TipoServicios tipoServ = null;
        ArrayList<TipoServicios> list = new ArrayList<TipoServicios>();

        try {
            
            PreparedStatement ps = con.prepareStatement("select id_servicio, descripcion from tipo_servicios");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                tipoServ = new TipoServicios();
                String id_servicio = rs.getString("id_servicio");
                String descripcion = rs.getString("descripcion");
                
                tipoServ.setIdServicio(new BigDecimal(id_servicio));
                tipoServ.setDescripcion(descripcion);
                list.add(tipoServ);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Tipos de Servicio -->" + ex.getMessage());
            
        } finally {
            return list;
        }
        
    }

    private ArrayList<Tecnicos> obtenerTecnicos() {
        Connection con = null;
        PreparedStatement ps = null;
        Tecnicos tecnico = null;
        ArrayList<Tecnicos> list = new ArrayList<Tecnicos>();

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("select id_tecnico,nombre from tecnicos");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                tecnico = new Tecnicos();
                String id_tecnico = rs.getString("id_tecnico");
                String nombre = rs.getString("nombre");
                
                tecnico.setIdTecnico(Integer.parseInt(id_tecnico));
                tecnico.setNombre(nombre);
                list.add(tecnico);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Tecnicos -->" + ex.getMessage());
            
        } finally {
            DataConnect.close(con);
            return list;
        }
        
    }

    public void obtenerDatosOrdenTrabajo() {
        String nroOrdenTrabajo = this.nroOrden;
        System.out.println("nroOrdenTrabajo: " + nroOrden);
        if (nroOrdenTrabajo != null && !"".equalsIgnoreCase(nroOrdenTrabajo)) {
                    
            Connection con = null;
            PreparedStatement ps = null;

            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("SELECT  cl.id_cliente, "
                        + "ci.ciudad, es.estado, td.tipo_docu, "
                        + "cl.nombre, cl.apellido, cl.direccion, "
                        + "cl.telefono, cl.nro_documento "
                        + "FROM cliente cl, ciudad ci, "
                        + "estado es, tipo_documento td "
                        + "where nro_documento = ? "
                        + "and ci.id_ciudad = cl.id_ciudad "
                        + "and es.id_estado = cl.id_estado "
                        + "and td.id_tipo_docu = cl.id_tipo_docu");
                ps.setString(1, nroOrdenTrabajo);
                //ps.setInt(1, Integer.parseInt(nroOrdenTrabajo));

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    this.idCliente = rs.getInt("id_cliente");
                    this.nroDocumento = rs.getString("nro_documento");
                    this.razonsocial = rs.getString("nombre") + " " + rs.getString("apellido");
                    this.ciudad = rs.getString("ciudad");
                    this.direccion = rs.getString("direccion");
                    this.telefono = rs.getString("telefono");
                }
            } catch (SQLException ex) {
                System.out.println("Error al obtener Cliente -->" + ex.getMessage());

            } finally {
                DataConnect.close(con);

            }

        }

    }

 
    private void persistOTCab(JsfUtil.PersistAction persistAction, String successMessage) {
        if (ordenTrabajoCab != null) {

            try {
                if (persistAction == JsfUtil.PersistAction.CREATE) {
                    getEjbCabFacade().create(ordenTrabajoCab);
                }
                else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    getEjbCabFacade().edit(ordenTrabajoCab);
                } else {
                    getEjbCabFacade().remove(ordenTrabajoCab);
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

    private void persistOTDet(  JsfUtil.PersistAction persistAction, 
                                ArrayList<OrdenTrabajoDet> listaDetalle,
                                String successMessage) {
        
        if (listaDetalle != null && !listaDetalle.isEmpty()) {
            for (OrdenTrabajoDet otdet : listaDetalle) {
                ordenTrabajoDet = new OrdenTrabajoDet();
                ordenTrabajoDet.setNroOrden(ordenTrabajoCab);
                ordenTrabajoDet.setDetalle(otdet.getDetalle());

                try {
                    if (persistAction == JsfUtil.PersistAction.CREATE) {
                        getEjbDetFacade().create(ordenTrabajoDet);
                    }
                    else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                        getEjbDetFacade().edit(ordenTrabajoDet);
                    } 
                    else {
                        getEjbDetFacade().remove(ordenTrabajoDet);
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
            
            if (successMessage != null) {
                JsfUtil.addSuccessMessage(successMessage);
            }
        }
    }

    
    public void onDateSelect(SelectEvent event) {
        if(event.getObject() != null){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaInicio = format.format(event.getObject());
        }
    }
    
    public void onRowEditTarea(RowEditEvent event){
            System.out.println("Editando Tarea");
    }
    
    public void onRowCancelTarea(RowEditEvent event) {
        OrdenTrabajoDet det = (OrdenTrabajoDet)event.getObject();
        
        String descripcion = det.getDetalle(); //obtengo la descripción de la tarea
        
        //si es vacio, es porque es nuevo
        if( "".equalsIgnoreCase(descripcion) ){
            //al cancelar borro la ultima fila insertada
            listaDetalle.remove(det);        
        }
        
    }
    
}
