/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.Cliente;
import entities.EstadoTrab;
import entities.InstalacionCab;
import entities.InstalacionDet;
import entities.InstalacionDetPK;
import entities.Moviles;
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
import java.text.ParseException;
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
    private Date fechaInicio;
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
    private List<Moviles> listaMoviles = new ArrayList<Moviles>();
    
    @EJB
    private bean.TecnicosFacade tecnicoFacade =  new TecnicosFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.TipoServiciosFacade tipoServiciosFacade = new TipoServiciosFacade();
    @EJB
    private bean.EstadoTrabFacade estadoTrabFacade = new EstadoTrabFacade();
    @EJB
    private bean.OrdenTrabajoCabFacade ejbOTCabFacade;
    @EJB
    private bean.OrdenTrabajoDetFacade ejbOTDetFacade;
    @EJB
    private bean.InstalacionCabFacade ejbInstalCabFacade;
    @EJB
    private bean.InstalacionDetFacade ejbInstalDetFacade;
    @EJB
    private bean.ProductosKitFacade productoKitFacade = new ProductosKitFacade();
    @EJB
    private bean.MovilesFacade movilesFacade = new MovilesFacade();
    
    private OrdenTrabajoCab ordenTrabajoCab;
    private OrdenTrabajoDet ordenTrabajoDet;
    private Moviles movil;
    
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

            int ultValSeq = obtenerNuevoIdInstalacion();
            
            nroDeInstalacion = "000"+String.valueOf(ultValSeq+1) ;

            Date date = Calendar.getInstance().getTime();
            fechaOrden = date;
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            fechaRecepcion = today;

            this.listaServicios = obtenerTiposDeServicio();
            this.listaTecnicos = obtenerTecnicos();
            this.listaEstados = estadoTrabFacade.findAll();
            this.idEstadoTrab = 1; //poner a Pendiente = 1 por defecto
 
            this.listaMoviles = movilesFacade.findAll();
            this.listaKits = productoKitFacade.findAll();
            
            this.tipoInstalacion = null;
            this.movil = null;
            description = "";
            
            this.selectedKits = new ArrayList<ProductosKit>();
            this.selectedTecnicos = new ArrayList<Tecnicos>();

            this.tipoServicio = "";
            this.tecnicoResponsable = "";
            
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
    
    public int obtenerNuevoIdInstalacion() {
        int ultimoValor = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT last_value FROM id_instalacion_seq");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               BigDecimal uv =  rs.getBigDecimal("last_value");
               
               ultimoValor = uv.toBigInteger().intValue();
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Secuencia de InstalacionCab -->" + ex.getMessage());
        }

        return ultimoValor;
    }

    public BigInteger getNextValInstalacionDet() {
        BigInteger nextVal = new BigInteger("0");
        try {
            PreparedStatement ps = con.prepareStatement("SELECT nextval('id_instalacion_seq')");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               BigDecimal uv =  rs.getBigDecimal("nextval");
               
               nextVal = uv.toBigInteger();
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Secuencia de InstalacionDet -->" + ex.getMessage());
        }

        return nextVal;
    }
    
   
    public String guardarOrdenInstalacion(){
    
        instalacionCab = new InstalacionCab();
        
        try {
            instalacionCab.setDescripcion(this.observacion);
            instalacionCab.setNroOrden(this.ordenTrabajoCab);
            instalacionCab.setIdTecnico(this.ordenTrabajoCab.getIdTecnico());
            instalacionCab.setTipoInstalacion(this.tipoInstalacion);
            System.out.println("fechaInicio: "+fechaInicio);
            instalacionCab.setFechainstalacion( this.fechaInicio );
            instalacionCab.setIdServicio(this.ordenTrabajoCab.getIdServicio());
            instalacionCab.setIdMovil(this.movil);
            instalacionCab.setIdCliente(this.ordenTrabajoCab.getIdCliente());
            instalacionCab.setIdEstadoTrab(estadoTrabFacade.findByIdEstadoTrab(idEstadoTrab));
            
            persistInstalCab(PersistAction.CREATE, null);
            System.out.println("se guardó la InstalacionCab con exito > "+JsfUtil.isValidationFailed());

            System.out.println("PK insertada: "+instalacionCab.getIdInstalacion());
        
            persistInstalDet(PersistAction.CREATE, selectedKits, instalacionCab.getIdInstalacion(), "Instalacion guardada correctamente");
        
        } catch (Exception ex) {
            Logger.getLogger(OrdenInstalacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
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
        
        this.listaDetalle = new ArrayList<OrdenTrabajoDet>();
        
        if (nroOrdenTrabajo != null && !"".equalsIgnoreCase(nroOrdenTrabajo)) {
            
            OrdenTrabajoCab otCab = ejbOTCabFacade.findByNroOrden( Integer.valueOf(nroOrdenTrabajo) );
            
            if (otCab == null) {
                //no encontré nada
                //limpiar filtros
                this.tipoServicio = "";
                this.tecnicoResponsable = "";
                this.nroDocumento = "";
                this.razonsocial = "";
                this.ciudad = "";
                this.direccion = "";
                this.telefono = "";
                this.ordenTrabajoCab = null;
            }else{
                this.ordenTrabajoCab = otCab;
                this.tipoServicio = otCab.getIdServicio().getDescripcion();
                this.tecnicoResponsable = otCab.getIdTecnico().getNombre();
                this.nroDocumento = otCab.getIdCliente().getNroDocumento();
                this.razonsocial = otCab.getIdCliente().getNombre() + " " + otCab.getIdCliente().getApellido();
                this.ciudad = otCab.getIdCliente().getIdCiudad().getCiudad();
                this.direccion = otCab.getIdCliente().getDireccion();
                this.telefono = otCab.getIdCliente().getTelefono();

                for (OrdenTrabajoDet otDet : otCab.getOrdenTrabajoDetList()) {
                    this.listaDetalle.add(otDet);
                }

            }

        }else{
            //limpiar filtros
            this.tipoServicio =  "";
            this.tecnicoResponsable = "";
            this.nroDocumento = "";
            this.razonsocial = "";
            this.ciudad = "";
            this.direccion = "";
            this.telefono = "";
            this.ordenTrabajoCab = null;
        }

    }

 
    private void persistInstalCab(JsfUtil.PersistAction persistAction, String successMessage) {
        if (instalacionCab != null) {

            try {
                if (persistAction == JsfUtil.PersistAction.CREATE) {
                    getEjbInstalCabFacade().create(instalacionCab);
                }
                else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    getEjbInstalCabFacade().edit(instalacionCab);
                } else {
                    getEjbInstalCabFacade().remove(instalacionCab);
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

    private void persistInstalDet(  JsfUtil.PersistAction persistAction, 
                                ArrayList<ProductosKit> selectedProdKits,
                                BigDecimal idInstalCab,
                                String successMessage) {
        
        if (selectedProdKits != null && !selectedProdKits.isEmpty()) {
            for(ProductosKit prodKit : selectedKits ) {
                instalacionDet = new InstalacionDet();
                instalacionDet.setCodProducto(prodKit.getCodProducto().getCodProducto().toBigInteger());
                instalacionDet.setIdProductosKit(prodKit.getIdProductosKit().toBigInteger());
                
                InstalacionDetPK pk =  new InstalacionDetPK();
                pk.setIdInstalacion(idInstalCab.toBigInteger());
                pk.setNroLinea(getNextValInstalacionDet());
                instalacionDet.setInstalacionDetPK(pk);
                
                try {
                    if (persistAction == JsfUtil.PersistAction.CREATE) {
                        getEjbInstalDetFacade().create(instalacionDet);
                    }
                    else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                        getEjbInstalDetFacade().edit(instalacionDet);
                    } 
                    else {
                        getEjbInstalDetFacade().remove(instalacionDet);
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
