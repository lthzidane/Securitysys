/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
import javax.faces.context.FacesContext;
import lombok.Data;
import session.util.JsfUtil;


/**
 *
 * @author Acer
 *
 */
@ManagedBean(name = "MonitoreoClientesBean")
@ViewScoped
@Data
public class MonitoreoClientesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nroDeReclamo;
    private String equipo;
    private String cliente;
    private BigDecimal pedido;
    private String estado;
    private String description;
    private Date fechaInicio;
    private Date fechaFin;
    private String fechaRecepcion;
    private Date fechaOrden;
    private String tipoInstalacion;
    private String tecnicoResponsable;
    private Integer idCliente;
    private Integer idEstado;
    private Integer idTipoReclamo;
    private Integer idSubTipoReclamo;
    private Integer idNivel;
    private Integer idFuncionario;
    private String usuario;
    private Integer idDepartamento;
    private String tipoServicio;
    private String nroOrden;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String descripcion;
    private List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
    private ArrayList<Tecnico> listaTecnico = new ArrayList<Tecnico>();
    private List<Estado> listaEstados = new ArrayList<Estado>();
    private List<TipoReclamo> listaTipoReclamo = new ArrayList<TipoReclamo>();
    
    
    private List<OrdenTrabajoDet> listaDetalle = new ArrayList<OrdenTrabajoDet>();
    
    
    private ArrayList<InstalacionDet> instalacionesDetList = new ArrayList<InstalacionDet>();
    private ArrayList<Tecnico> selectedTecnico = new ArrayList<Tecnico>();
    private List<Moviles> listaMoviles = new ArrayList<Moviles>();

    @EJB
    private bean.TecnicoFacade tecnicoFacade = new TecnicoFacade();
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
        this.cargarVista();
    }

    public void cargarVista() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //defino el formato de fecha
        try {
            String editar = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("Editar");

            this.editando = "true".equalsIgnoreCase(editar) ? true : false;

            //si no estoy editando, estoy creando
            if (!editando) {
                int ultValSeq = obtenerNuevoIdReclamo();
                nroDeReclamo = "000" + String.valueOf(ultValSeq);

                Date date = Calendar.getInstance().getTime();
                fechaOrden = date;
                String today = formatter.format(date);
                fechaRecepcion = today;

                this.listaEstados = estadoTrabFacade.findAll();
                this.idEstado = 1; //poner a Pendiente = 1 por defecto

                this.listaDepartamentos = departamentoFacade.findAll();
                this.idDepartamento = 4; //poner a Reclamos = 4 por defecto

                this.listaTipoReclamo = tiporeclamoFacade.findAll();
                this.idTipoReclamo = null;

                this.idSubTipoReclamo = null;

                this.idNivel = null;

                this.usuario = (String) SessionBean.getSession().getAttribute("username");
                description = "";

                
                this.selectedTecnico = new ArrayList<Tecnico>();

                this.tipoServicio = "";
                this.tecnicoResponsable = "";

                listaDetalle = new ArrayList<OrdenTrabajoDet>();

                this.idCliente = null;
                this.fechaInicio = null;
                this.fechaFin = null;
                this.nroOrden = "";
                this.nroDocumento = "";
                this.ciudad = "";
                this.telefono = "";
                this.direccion = "";
                this.razonsocial = "";
                this.descripcion = "";

                this.listaTecnico = obtenerTecnico();

            } else {
                //estoy editando
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int obtenerNuevoIdReclamo() {
        int ultimoValor = 0;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT last_value FROM id_reclamo_reclamo_seq_1");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BigDecimal uv = rs.getBigDecimal("last_value");

                ultimoValor = uv.toBigInteger().intValue();
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Secuencia de InstalacionCab -->" + ex.getMessage());
        }

        return ultimoValor;
    }

    public String guardarReclamo() {
        reclamo = new Reclamo();
        reclamo.setDescripcion(this.descripcion);
        reclamo.setFechaAlta(this.fechaOrden);
        //reclamo.setIdCliente(clienteFacade.findByIdCliente(idCliente));
        //reclamo.setIdDepartamento(departamentoFacade.findByIdDpto(idDepartamento));
        //reclamo.setIdEstado(estadoTrabFacade.findByIdEstado(idEstado));
        //reclamo.setIdUsuario(usuarioFacade.findByNombre(this.usuario));
        //reclamo.setIdTipoReclamo(tiporeclamoFacade.findByIdTiporecla(idTipoReclamo));

        if (!editando) {
            //persistReclamo(PersistAction.CREATE, "Reclamo guardado correctamente");
            cargarVista();
        } else {
            //estoy editando -> todavía no implementado

            this.editando = false;

            //return "BuscarModificarOT";
        }

        //return "/home";
        return null;
    }

    public String volver() {
        return "/home";
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

    private ArrayList<Tecnico> obtenerTecnico() {
        Connection con = null;
        PreparedStatement ps = null;
        Tecnico tecnico = null;
        ArrayList<Tecnico> list = new ArrayList<Tecnico>();

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("select id_tecnico,nombre from tecnicos");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tecnico = new Tecnico();
                String id_tecnico = rs.getString("id_tecnico");
                String nombre = rs.getString("nombre");

                tecnico.setIdTecnico(Integer.parseInt(id_tecnico));
                tecnico.setNombre(nombre);
                list.add(tecnico);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Tecnico -->" + ex.getMessage());

        } finally {
            DataConnect.close(con);
            return list;
        }

    }

}
