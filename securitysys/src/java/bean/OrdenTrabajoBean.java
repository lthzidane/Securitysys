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
import session.ClienteController;
import session.TecnicosController;
import session.util.JsfUtil;
import session.util.JsfUtil.PersistAction;
import util.Sale;

/**
 *
 * @author sebas
 */
@ManagedBean(name="OrdenTrabajoBean")
@ViewScoped
@Data
public class OrdenTrabajoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nroDeOrden;
    private String equipo; 
    private BigDecimal pedido;
    private String estado;
    private String description;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRecepcion;
    private Date fechaOrden;
    private String observacion;
    private Integer idTecnico;
    private Integer idCliente;
    private Integer idEstadoTrab;
    private Integer idServicio;
    private String cliente;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private String telefono;
    private String ciudad;
    private ArrayList<TipoServicios> listaServicios = new ArrayList<TipoServicios>();
    private ArrayList<Tecnicos> listaTecnicos = new ArrayList<Tecnicos>();
    private List<EstadoTrab> listaEstados = new ArrayList<EstadoTrab>();
    
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
    
    private OrdenTrabajoCab ordenTrabajoCab;
    private OrdenTrabajoDet ordenTrabajoDet;
    
    @PostConstruct
    void initialiseSession() {
        this.cargarVista();
    }   
    
    
    public void cargarVista() {

        try {

            nroDeOrden = "000"+String.valueOf(getEjbCabFacade().count()+1) ;

            Date date = Calendar.getInstance().getTime();
            fechaOrden = date;
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            fechaRecepcion = today;

            this.listaServicios = obtenerTiposDeServicio();
            this.listaTecnicos = obtenerTecnicos();
            this.listaEstados = estadoTrabFacade.findAll();
            
            description = "";

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   
    public String guardarOrdenTrabajo(){
        
        ordenTrabajoCab = new OrdenTrabajoCab();
        ordenTrabajoCab.setIdTecnico( tecnicoFacade.findByIdTecnico(idTecnico) );
        ordenTrabajoCab.setIdCliente( clienteFacade.findByIdCliente(idCliente) );
        ordenTrabajoCab.setIdReclamo( null );
        ordenTrabajoCab.setFechaOrden( fechaOrden );
        ordenTrabajoCab.setIdEstado( null );
        ordenTrabajoCab.setIdServicio( tipoServiciosFacade.findByIdServicio(idServicio) );
        ordenTrabajoCab.setIdEstadoTrab( estadoTrabFacade.findByIdEstadoTrab(idTecnico) );
        
        //persistOTCab(PersistAction.CREATE, "Orden de Trabajo Cab guardada correctamente.");
        System.out.println("se guardó la OTCab con exito > "+JsfUtil.isValidationFailed());
        
        ordenTrabajoDet = new OrdenTrabajoDet();
        ordenTrabajoDet.setNroOrden(ordenTrabajoCab);
        //para probar cargar orden trabajo detalle
        //BigDecimal sec = new BigDecimal("1");
        //ordenTrabajoDet.setNroSecuencia(sec);
        
        ordenTrabajoDet.setDetalle(description);
        persistOTDet(PersistAction.CREATE, "Orden de Trabajo guardada correctamente");
        System.out.println("se guardó la OTDet con exito");
        
        //limpiar campos
//        this.idCliente = null;
//        this.idEstadoTrab = null;
//        this.idTecnico = null;
//        this.fechaInicio = "";
//        this.fechaFin = "";
//        this.idServicio = null;
//        this.description = "";
//        this.observacion = "";
//        this.ciudad = "";
//        this.telefono = "";
//        this.direccion = "";
//        this.razonsocial = "";
//        this.nroDocumento = "";
        
        //return "/home";
        return null;
    }
    
    
    private ArrayList<TipoServicios> obtenerTiposDeServicio() {
        Connection con = null;
        PreparedStatement ps = null;
        TipoServicios tipoServ = null;
        ArrayList<TipoServicios> list = new ArrayList<TipoServicios>();

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("select id_servicio, descripcion from tipo_servicios");

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
            DataConnect.close(con);
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

    public void obtenerDatosCliente() {
        String nroDocumentoCliente = this.cliente;
        System.out.println("nroDocumentoCliente: " + nroDocumentoCliente);
        if (nroDocumentoCliente != null && !"".equalsIgnoreCase(nroDocumentoCliente)) {
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
                ps.setString(1, nroDocumentoCliente);
                //ps.setInt(1, Integer.parseInt(nroDocumentoCliente));

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
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getEjbCabFacade().edit(ordenTrabajoCab);
                } else {
                    getEjbCabFacade().remove(ordenTrabajoCab);
                }
                JsfUtil.addSuccessMessage(successMessage);
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

    private void persistOTDet(JsfUtil.PersistAction persistAction, String successMessage) {
        if (ordenTrabajoDet != null) {

            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getEjbDetFacade().edit(ordenTrabajoDet);
                } else {
                    getEjbDetFacade().remove(ordenTrabajoDet);
                }
                JsfUtil.addSuccessMessage(successMessage);
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

}
