/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.Cliente;
import entities.Departamento;
import entities.Estado;

import entities.InstalacionDet;
import entities.Moviles;

import entities.OrdenTrabajoDet;

import entities.Reclamo;
import entities.Tecnico;
import entities.TipoReclamo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import session.util.JsfUtil;


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
    private String idEstado;
    private String idTipoReclamo;
    private String idSubTipoReclamo;
    private String idNivel;
    private Integer idFuncionario;
    private String usuario;
    private String idDepartamento;
    private String tipoServicio;
    private String nroOrden;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private int telefono;
    private String ciudad;
    private String descripcion;
    private String solucion = "";
    private List<Departamento> listaDepartamentos = new ArrayList<>();
    private ArrayList<Tecnico> listaTecnico = new ArrayList<>();
    private List<Estado> listaEstados = new ArrayList<>();
    private List<TipoReclamo> listaTipoReclamo = new ArrayList<TipoReclamo>();
    
    
    private List<OrdenTrabajoDet> listaDetalle = new ArrayList<OrdenTrabajoDet>();
    
    
    private ArrayList<InstalacionDet> instalacionesDetList = new ArrayList<InstalacionDet>();
    private ArrayList<Tecnico> selectedTecnico = new ArrayList<Tecnico>();
    private List<Moviles> listaMoviles = new ArrayList<Moviles>();
    
    @EJB
    private bean.TecnicoFacade tecnicoFacade =  new TecnicoFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.EstadoFacade estadoTrabFacade = new EstadoFacade();
    @EJB
    private bean.DepartamentoFacade departamentoFacade = new DepartamentoFacade();
    @EJB
    private bean.TipoReclamoFacade tiporeclamoFacade = new TipoReclamoFacade();

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
        //reclamo.setIdEstado(estadoTrabFacade.findByEstado("Cerrado"));
        reclamo.setSolucion(this.solucion);
        reclamo.setFechaAlta(this.fechaFin);
        //persistReclamo(PersistAction.UPDATE, "Reclamo Editado correctamente");
        this.editando = false;
        limpiarCampos();
        return null;
    }
    
    public void limpiarCampos(){
        this.nroDeReclamo = "";
        this.idReclamo = null;
        this.reclamo = null;
        this.idEstado = "";
        this.fechaRecepcion = "";
        this.fechaInicio = null;
        this.idDepartamento = "";
        this.idTipoReclamo = "";
        this.idSubTipoReclamo = "";
        this.idNivel = "";
        this.usuario = "";
        this.descripcion = "";
        this.nroDocumento = "";
        this.razonsocial = "";
        this.ciudad = "";
        this.direccion = "";
        this.telefono = 0;
        this.solucion = "";
    }
    
    public String volver(){
        return "/home";
    }
    
//    private void persistReclamo(JsfUtil.PersistAction persistAction, String successMessage) {
//        if (reclamo != null) {
//
//            try {
//                if (persistAction == JsfUtil.PersistAction.CREATE) {
//                    getReclamoFacade().create(reclamo);
//                }
//                else if (persistAction == JsfUtil.PersistAction.UPDATE) {
//                    getReclamoFacade().edit(reclamo);
//                } else {
//                    getReclamoFacade().remove(reclamo);
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

    public void obtenerDatosReclamo(){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //defino el formato de fecha
        if(this.nroDeReclamo != null){
            System.out.println("Cargando datos del Reclamo: "+nroDeReclamo);
            this.idReclamo = Integer.parseInt(this.nroDeReclamo);
            this.reclamo = reclamoFacade.findByIdReclamo(idReclamo);
            //this.idEstado = this.reclamo.getIdEstado().getEstado();
            this.fechaRecepcion = formatter.format(this.reclamo.getFechaAlta());
            this.fechaInicio = this.reclamo.getFechaAlta();
            this.idDepartamento = this.reclamo.getIdDepartamento().getDescripcion();
            this.idTipoReclamo = this.reclamo.getIdTipoReclamo().getDescripcion();
            
            this.usuario = this.reclamo.getIdUsuario().getNombre();
            this.descripcion = this.reclamo.getDescripcion();
            Cliente clienteAsociado = this.reclamo.getIdCliente();
            this.nroDocumento = clienteAsociado.getNumeroDocumento();
            this.razonsocial = clienteAsociado.getNombre()+" "+clienteAsociado.getApellido();
            this.ciudad = clienteAsociado.getIdCiudad().getCiudad();
            this.direccion = clienteAsociado.getDireccion();
            this.telefono = clienteAsociado.getTelefono();        
        }
        
    } 
}
