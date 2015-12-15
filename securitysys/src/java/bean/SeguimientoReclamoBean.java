/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.Cliente;
import entities.Departamento;
import entities.EstadoTrab;
import entities.Funcionario;
import entities.InstalacionCab;
import entities.InstalacionDet;
import entities.InstalacionDetPK;
import entities.Medidas;
import entities.Moviles;
import entities.Nivel;
import entities.OrdenTrabajoCab;
import entities.OrdenTrabajoDet;
import entities.Productos;
import entities.ProductosKit;
import entities.Reclamo;
import entities.Subtipo;
import entities.Tecnicos;
import entities.TipoServicios;
import entities.Tiporeclamo;
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
 * @author Acer
 *
 */
@ManagedBean(name="SeguimientoReclamoBean")
@ViewScoped
@Data
public class SeguimientoReclamoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nroDeReclamo;
    private Integer idReclamo;
    private String equipo; 
    private String cliente;
    private BigDecimal pedido;
    private String estado;
    private String description;
    private Date fechaFin;
    private String fechaRecepcion;
    private String fechaSolucion;
    private Date fechaInicio;
    private String tipoInstalacion;
    private String tecnicoResponsable;
    private Integer idCliente;
    private String idEstadoTrab;
    private String idTiporeclamo;
    private String idSubTiporeclamo;
    private String idNivel;
    private Integer idFuncionario;
    private String usuario;
    private String idDepartamento;
    private String tipoServicio;
    private String nroOrden;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String descripcion;
    private String solucion = "";
    private List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
    private ArrayList<Tecnicos> listaTecnicos = new ArrayList<Tecnicos>();
    private List<EstadoTrab> listaEstados = new ArrayList<EstadoTrab>();
    private List<Tiporeclamo> listaTipoReclamo = new ArrayList<Tiporeclamo>();
    private List<Subtipo> listaSubTipoReclamo = new ArrayList<Subtipo>();
    private List<Nivel> listaNivel = new ArrayList<Nivel>();
    private List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    private List<OrdenTrabajoDet> listaDetalle = new ArrayList<OrdenTrabajoDet>();
    private List<ProductosKit> listaKits = new ArrayList<ProductosKit>();
    private ArrayList<ProductosKit> selectedKits = new ArrayList<ProductosKit>();
    private ArrayList<InstalacionDet> instalacionesDetList = new ArrayList<InstalacionDet>();
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
    private bean.DepartamentoFacade departamentoFacade = new DepartamentoFacade();
    @EJB
    private bean.TiporeclamoFacade tiporeclamoFacade = new TiporeclamoFacade();
    @EJB
    private bean.SubtipoFacade subtiporeclamoFacade = new SubtipoFacade();
    @EJB
    private bean.NivelFacade nivelFacade = new NivelFacade();
    @EJB
    private bean.UsuarioFacade usuarioFacade = new UsuarioFacade();
    @EJB
    private bean.ReclamoFacade reclamoFacade = new ReclamoFacade();
    
    private Reclamo reclamo;
    
    private Connection con = null;
    private boolean editando = false;    
    
    
    @PostConstruct
    void initialiseSession() {
        con = DataConnect.getConnection();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //defino el formato de fecha
        Date date = Calendar.getInstance().getTime();
        fechaFin = date;
        String today = formatter.format(date);
        fechaSolucion = today;
    }   
       
    public int obtenerNuevoIdReclamo() {
        int ultimoValor = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT last_value FROM id_reclamo_reclamo_seq_1");

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
    
    public String guardarReclamo(){
        reclamo.setIdEstadoTrab(estadoTrabFacade.findByEstado("Cerrado"));
        reclamo.setSolucion(this.solucion);
        reclamo.setFechaSolucion(this.fechaFin);
        persistReclamo(PersistAction.UPDATE, "Reclamo Editado correctamente");
        this.editando = false;
        
        return null;
    }
    
    public String volver(){
        return "/home";
    }
    
    private void persistReclamo(JsfUtil.PersistAction persistAction, String successMessage) {
        if (reclamo != null) {

            try {
                if (persistAction == JsfUtil.PersistAction.CREATE) {
                    getReclamoFacade().create(reclamo);
                }
                else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    getReclamoFacade().edit(reclamo);
                } else {
                    getReclamoFacade().remove(reclamo);
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

    public void obtenerDatosReclamo(){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //defino el formato de fecha
        if(this.nroDeReclamo != null){
            System.out.println("Cargando datos del Reclamo: "+nroDeReclamo);
            this.idReclamo = Integer.parseInt(this.nroDeReclamo);
            this.reclamo = reclamoFacade.findByIdReclamo(idReclamo);
            this.idEstadoTrab = this.reclamo.getIdEstadoTrab().getEstado();
            this.fechaRecepcion = formatter.format(this.reclamo.getFechaIngreso());
            this.fechaInicio = this.reclamo.getFechaIngreso();
            this.idDepartamento = this.reclamo.getIdDpto().getNombreDpto();
            this.idTiporeclamo = this.reclamo.getIdTiporecla().getDescripcion();
            this.idSubTiporeclamo = this.reclamo.getIdSubtipo().getSubtipo();
            this.idNivel = nivelFacade.findByIdNivel(this.reclamo.getIdNivel().intValue()).getNivel();  
            this.usuario = this.reclamo.getIdUsuario().getNombre();
            this.descripcion = this.reclamo.getDescripcion();
            Cliente clienteAsociado = this.reclamo.getIdCliente();
            this.nroDocumento = clienteAsociado.getNroDocumento();
            this.razonsocial = clienteAsociado.getNombre()+" "+clienteAsociado.getApellido();
            this.ciudad = clienteAsociado.getIdCiudad().getCiudad();
            this.direccion = clienteAsociado.getDireccion();
            this.telefono = clienteAsociado.getTelefono();        
        }
        
    } 
}
