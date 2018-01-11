/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Estado;
import entities.OrdenTrabajoCab;
import entities.OrdenTrabajoDet;
import entities.Tecnicos;
import entities.TipoServicios;
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
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import session.util.JsfUtil;
import session.util.JsfUtil.PersistAction;

/**
 *
 * @author sebas
 */
@ManagedBean(name = "OrdenTrabajoBean")
@ViewScoped
@Data
public class OrdenTrabajoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nroDeOrden;
    private String equipo;
    private BigDecimal pedido;
    private String estado;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRecepcion;
    private Date fechaOrden;
    private String observacion;
    private Integer idTecnico;
    private Integer idCliente;
    private Integer idEstado;
    private Integer idServicio;
    private String cliente;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private int telefono;
    private String ciudad;
    private ArrayList<TipoServicios> listaServicios = new ArrayList<TipoServicios>();
    private ArrayList<Tecnicos> listaTecnicos = new ArrayList<Tecnicos>();
    private List<Estado> listaEstados = new ArrayList<Estado>();
    private ArrayList<OrdenTrabajoDet> listaDetalle = new ArrayList<OrdenTrabajoDet>();
    private ArrayList<OrdenTrabajoDet> listaDetallesEliminados = new ArrayList<OrdenTrabajoDet>();

    @EJB
    private bean.TecnicosFacade tecnicoFacade = new TecnicosFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.TipoServiciosFacade tipoServiciosFacade = new TipoServiciosFacade();
    @EJB
    private bean.EstadoFacade estadoTrabFacade = new EstadoFacade();
    @EJB
    private bean.OrdenTrabajoCabFacade ordenTrabajoCabFacade;
    @EJB
    private bean.OrdenTrabajoDetFacade ordenTrabajoDetFacade;

    private OrdenTrabajoCab ordenTrabajoCab;
    private OrdenTrabajoDet ordenTrabajoDet;

    private Connection con = null;
    private boolean editando;

    @PostConstruct
    void initialiseSession() {
        con = DataConnect.getConnection();
        this.cargarVista();
    }

    public void cargarVista() {
        listaDetallesEliminados.clear(); //limpio la lista de tareas eliminadas

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //defino el formato de fecha
        try {
            String editar = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("Editar");

            this.editando = "true".equalsIgnoreCase(editar) ? true : false;

            //si no estoy editando, estoy creando
            if (!editando) {
                nroDeOrden = "000" + String.valueOf(obtenerNroOrden() + 1);

                Date date = Calendar.getInstance().getTime();
                fechaOrden = date;

                String today = formatter.format(date);
                fechaRecepcion = today;

                this.listaServicios = obtenerTiposDeServicio();
                this.listaTecnicos = obtenerTecnicos();
                this.listaEstados = estadoTrabFacade.findAll();
                this.idEstado = 1; //poner a Pendiente = 1 por defecto

                listaDetalle = new ArrayList<OrdenTrabajoDet>();

                this.idCliente = null;
                this.idTecnico = null;
                this.fechaInicio = null;
                this.fechaFin = null;
                this.idServicio = null;
                this.cliente = "";
                this.nroDocumento = "";
                this.ciudad = "";
                this.telefono = 0;
                this.direccion = "";
                this.razonsocial = "";

            } else {

                String otNro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("OTNro");

                OrdenTrabajoCab otCab = ordenTrabajoCabFacade.findByNroOrden(Integer.parseInt(otNro));

                if (otCab != null) {
                    if (otCab.getOrdenTrabajoDetList().isEmpty()) {
                        List<OrdenTrabajoDet> listaOrdenesTrabajoDet = ordenTrabajoDetFacade.findByNroOrden(otCab.getNroOrden().intValue());
                        if (listaOrdenesTrabajoDet.size() > 0) {
                            otCab.setOrdenTrabajoDetList(listaOrdenesTrabajoDet);
                            System.out.println("seteo la cantitad real: " + listaOrdenesTrabajoDet.size());
                        }
                    }
   
                    nroDeOrden = "000" + otNro;

                    fechaOrden = otCab.getFechaOrden();
                    fechaRecepcion = formatter.format(otCab.getFechaOrden());

                    this.listaServicios = obtenerTiposDeServicio();
                    this.idServicio = otCab.getIdServicio().getIdServicio().intValue();

                    this.listaTecnicos = obtenerTecnicos();
                    this.idTecnico = otCab.getIdTecnico().getIdTecnico();

                    this.listaEstados = estadoTrabFacade.findAll();
                    this.idEstado = otCab.getIdEstado().getIdEstado().intValue();

                    listaDetalle = new ArrayList<OrdenTrabajoDet>();
                    System.out.println("trae OtDet: " + otCab.getOrdenTrabajoDetList().size());
                    for (OrdenTrabajoDet otDet : otCab.getOrdenTrabajoDetList()) {
                        listaDetalle.add(otDet);
                    }

                    this.idCliente = otCab.getIdCliente().getIdCliente().intValue();

                    this.fechaInicio = null;
                    this.fechaFin = null;

                    this.nroDocumento = otCab.getIdCliente().getNroDocumento();
                    this.ciudad = otCab.getIdCliente().getIdCiudad().getCiudad();
                    this.telefono = otCab.getIdCliente().getTelefono();
                    this.direccion = otCab.getIdCliente().getDireccion();
                    this.razonsocial = otCab.getIdCliente().getNombre() + " " + otCab.getIdCliente().getApellido();

                }

            }

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
                BigDecimal uv = rs.getBigDecimal("last_value");

                ultimoValor = uv.toBigInteger().intValue();
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Tipos de Servicio -->" + ex.getMessage());
        }

        return ultimoValor;
    }

    public String guardarOrdenTrabajo() {

        ordenTrabajoCab = new OrdenTrabajoCab();
        ordenTrabajoCab.setIdTecnico(tecnicoFacade.findByIdTecnico(idTecnico));
        ordenTrabajoCab.setIdCliente(clienteFacade.findByIdCliente(idCliente));
        ordenTrabajoCab.setIdReclamo(null);
        ordenTrabajoCab.setFechaOrden(fechaOrden);
        ordenTrabajoCab.setIdEstado(null);
        ordenTrabajoCab.setIdServicio(tipoServiciosFacade.findByIdServicio(idServicio));
        //ordenTrabajoCab.setIdEstado(estadoTrabFacade.findByIdEstado(idEstado));

        //estoy creando
        if (!editando) {

            persistOTCab(PersistAction.CREATE, null);
            System.out.println("se guardó la OTCab con exito > " + JsfUtil.isValidationFailed());
            persistOTDet(PersistAction.CREATE, listaDetalle, "Orden de Trabajo guardada correctamente");
            System.out.println("se guardó la OTDet con exito");

            //limpiar campos
            cargarVista();

        } else {
            //estoy editando!
            ordenTrabajoCab.setNroOrden(BigDecimal.valueOf(Integer.parseInt(this.nroDeOrden)));
            persistOTCab(PersistAction.UPDATE, null);
            System.out.println("se editó la OTCab con exito > " + JsfUtil.isValidationFailed());

            persistOTDet(PersistAction.UPDATE, listaDetalle, "Orden de Trabajo modificada correctamente");
            System.out.println("se editó la OTDet con exito");

            return "BuscarModificarOT";
        }

        return null;
    }

    public String volver() {
        return "/home";
    }

    public void addTarea() {
        int i = this.listaDetalle.size() + 1;
        OrdenTrabajoDet otd = new OrdenTrabajoDet(BigDecimal.valueOf(i), "");
        this.listaDetalle.add(otd);
    }

    public void removeTarea(OrdenTrabajoDet item) {
        listaDetallesEliminados.add(item);
        this.listaDetalle.remove(item);
    }

    private ArrayList<TipoServicios> obtenerTiposDeServicio() {
        TipoServicios tipoServ = null;
        ArrayList<TipoServicios> list = new ArrayList<TipoServicios>();

        try {

            PreparedStatement ps = con.prepareStatement("select id_servicio, descripcion from tipo_servicios");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

            while (rs.next()) {
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
                    this.telefono = rs.getInt("telefono");
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

    private void persistOTDet(JsfUtil.PersistAction persistAction,
            ArrayList<OrdenTrabajoDet> listaDetalle,
            String successMessage) {

        if (!listaDetallesEliminados.isEmpty()) { //si eliminé alguno de los detalles
            for (OrdenTrabajoDet otdet : listaDetallesEliminados) {
                try {
                    ordenTrabajoDetFacade.remove(otdet);
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

        if (listaDetalle != null && !listaDetalle.isEmpty()) {
            for (OrdenTrabajoDet otdet : listaDetalle) {

                if (otdet.getNroOrden() != null) {
                    ordenTrabajoDet = otdet; //si mantiene el nro de orden, es que solo edite la descripción
                } else {
                    ordenTrabajoDet = new OrdenTrabajoDet();
                    ordenTrabajoDet.setNroOrden(ordenTrabajoCab);
                    ordenTrabajoDet.setDetalle(otdet.getDetalle());
                }

                try {
                    if (persistAction == JsfUtil.PersistAction.CREATE) {
                        ordenTrabajoDetFacade.create(ordenTrabajoDet);
                    } else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                        ordenTrabajoDetFacade.edit(ordenTrabajoDet);
                    } else {
                        ordenTrabajoDetFacade.remove(ordenTrabajoDet);
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
        if (event.getObject() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaInicio = format.format(event.getObject());
        }
    }

    public void onRowEditTarea(RowEditEvent event) {
        System.out.println("Editando Tarea");
    }

    public void onRowCancelTarea(RowEditEvent event) {
        OrdenTrabajoDet det = (OrdenTrabajoDet) event.getObject();

        String descripcion = det.getDetalle(); //obtengo la descripción de la tarea

        //si es vacio, es porque es nuevo
        if ("".equalsIgnoreCase(descripcion)) {
            //al cancelar borro la ultima fila insertada
            listaDetalle.remove(det);
        }

    }

}
