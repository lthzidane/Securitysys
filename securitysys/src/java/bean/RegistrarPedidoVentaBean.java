/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cliente;
import entities.Departamento;
import entities.Estado;
import entities.Funcionario;
import entities.InstalacionDet;
import entities.Moviles;
import entities.Nivel;
import entities.PresupuestoCab;
import entities.PresupuestoCabPK;
import entities.PresupuestoDet;
import entities.PresupuestoDetPK;
import entities.Productos;
import entities.ProductosKit;
import entities.Reclamo;
import entities.Sucursal;
import entities.Tecnicos;
import entities.TipoReclamo;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Data;
import org.primefaces.event.RowEditEvent;
import session.util.JsfUtil;

/**
 *
 * @author Acer
 *
 */
@ManagedBean(name = "RegistrarPedidoVentaBean")
@ViewScoped
@Data
public class RegistrarPedidoVentaBean implements Serializable {

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
    private Integer idSucursal;
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
    private List<Departamento> listaDepartamentos = new ArrayList<>();
    private ArrayList<Tecnicos> listaTecnicos = new ArrayList<>();
    private ArrayList<Sucursal> listaSucursales = new ArrayList<>();
    private List<Estado> listaEstados = new ArrayList<>();
    private List<Productos> listaProductos = new ArrayList<>();
    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    private List<TipoReclamo> listaTipoReclamo = new ArrayList<>();
    
    private List<Nivel> listaNivel = new ArrayList<>();
    private List<Funcionario> listaFuncionario = new ArrayList<>();
    private ArrayList<PresupuestoDet> listaDetalle = new ArrayList<>();
    private ArrayList<PresupuestoDet> listaDetallesEliminados = new ArrayList<>();
    private List<ProductosKit> listaKits = new ArrayList<>();
    private ArrayList<ProductosKit> selectedKits = new ArrayList<>();
    private ArrayList<InstalacionDet> instalacionesDetList = new ArrayList<>();
    private ArrayList<Tecnicos> selectedTecnicos = new ArrayList<>();
    private List<Moviles> listaMoviles = new ArrayList<Moviles>();

    private PresupuestoCab presupuestoCab;
    private PresupuestoDet presupuestoDet;
    private String sumaTotal;
    private String iva;
    private String presupuestoTotal;
    private Funcionario idFuncionario;

    @EJB
    private bean.TecnicosFacade tecnicoFacade = new TecnicosFacade();
    @EJB
    private bean.ClienteFacade clienteFacade = new ClienteFacade();
    @EJB
    private bean.TipoServiciosFacade tipoServiciosFacade = new TipoServiciosFacade();
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

    @EJB
    private bean.ProductosFacade productoFacade = new ProductosFacade();

    @EJB
    private bean.PresupuestoCabFacade presupuestoCabFacade = new PresupuestoCabFacade();

    @EJB
    private bean.PresupuestoDetFacade presupuestoDetFacade = new PresupuestoDetFacade();

    @EJB
    private bean.FuncionarioFacade funcionarioFacade = new FuncionarioFacade();

    @EJB
    private bean.EstadoFacade estadoFacade = new EstadoFacade();

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

                //Crea un presupuestoCab inicial
                this.presupuestoCab = new PresupuestoCab();

                PresupuestoCabPK presupuestoCabPK = new PresupuestoCabPK();
                int rand = generaNumeroAleatorio(0, 1000);
                presupuestoCabPK.setNroPresupuesto(BigInteger.valueOf(rand));
                presupuestoCabPK.setSerPresupuesto("A");
                presupuestoCabPK.setTipoPresupuesto("TIP");

                this.presupuestoCab.setPresupuestoCabPK(presupuestoCabPK);

                this.presupuestoCab.setFecha(date);

                this.listaProductos = productoFacade.findAll();

                this.listaFuncionarios = funcionarioFacade.findAll();

                this.listaEstados = estadoFacade.findAll();
                this.idEstado = 1; //poner a Pendiente = 1 por defecto

                this.listaDepartamentos = departamentoFacade.findAll();
                this.idDepartamento = 4; //poner a Reclamos = 4 por defecto

                this.listaTipoReclamo = tiporeclamoFacade.findAll();
                this.idTipoReclamo = null;

                this.idSubTipoReclamo = null;

                this.idNivel = null;

                this.usuario = (String) SessionBean.getSession().getAttribute("username");
                description = "";

                this.selectedKits = new ArrayList<ProductosKit>();
                this.selectedTecnicos = new ArrayList<Tecnicos>();

                this.tipoServicio = "";
                this.tecnicoResponsable = "";

                listaDetalle = new ArrayList<>();

                this.idCliente = null;
                this.fechaInicio = null;
                this.fechaFin = null;
                this.nroOrden = "0001";
                this.nroDocumento = "";
                this.ciudad = "";
                this.telefono = "";
                this.direccion = "";
                this.razonsocial = "";
                this.descripcion = "";

                this.listaTecnicos = obtenerTecnicos();
                this.listaSucursales = obtenerSucursales();

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

    public String volver() {
        return "/home";
    }

    private void persistReclamo(JsfUtil.PersistAction persistAction, String successMessage) {
        if (reclamo != null) {

            try {
                if (persistAction == JsfUtil.PersistAction.CREATE) {
                    getReclamoFacade().create(reclamo);
                } else if (persistAction == JsfUtil.PersistAction.UPDATE) {
                    getReclamoFacade().edit(reclamo);
                } else {
                    getReclamoFacade().remove(reclamo);
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

    private ArrayList<Sucursal> obtenerSucursales() {
        Connection con = null;
        PreparedStatement ps = null;
        Sucursal sucursal = null;
        ArrayList<Sucursal> list = new ArrayList<>();

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("select id_sucursal,descripcion from sucursales");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                sucursal = new Sucursal();
                String id_tecnico = rs.getString("id_sucursal");
                String nombre = rs.getString("descripcion");

                sucursal.setIdSucursal(Integer.parseInt(id_tecnico));
                sucursal.setDescripcion(nombre);
                list.add(sucursal);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Sucursal -->" + ex.getMessage());

        } finally {
            DataConnect.close(con);
            return list;
        }
    }

    public String guardarPresupuesto() {

        String sumaTotalSinPunto = this.sumaTotal.replace(".", "");
        this.presupuestoCab.setBaseImponible(new BigInteger(sumaTotalSinPunto));
        this.presupuestoCab.setIdCliente(new Cliente(BigDecimal.valueOf(this.idCliente)));
        this.presupuestoCab.setIdFuncionario(this.idFuncionario);
        //this.presupuestoCab.setIdEstado(this.idEstado);
        //persistPresupuestoCab(JsfUtil.PersistAction.CREATE, null);
        System.out.println("se guardó la PresupuestoCab con exito > " + JsfUtil.isValidationFailed());

        //persistPresupuestoDet(JsfUtil.PersistAction.CREATE, listaDetalle, "PresupuestoDet guardado correctamente");
        System.out.println("se guardó la PresupuestoDet con exito");

        //limpiar campos
        cargarVista();

        return null;
    }

    private void persistPresupuestoCab(JsfUtil.PersistAction persistAction, String successMessage) {
        if (presupuestoCab != null) {

            try {
                if (null != persistAction) {
                    switch (persistAction) {
                        case CREATE:
                            presupuestoCabFacade.create(presupuestoCab);
                            break;
                        case UPDATE:
                            presupuestoCabFacade.edit(presupuestoCab);
                            break;
                        default:
                            presupuestoCabFacade.remove(presupuestoCab);
                            break;
                    }
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

    private void persistPresupuestoDet(JsfUtil.PersistAction persistAction,
            ArrayList<PresupuestoDet> listaDetalle,
            String successMessage) {

        if (!listaDetallesEliminados.isEmpty()) { //si eliminé alguno de los detalles
            for (PresupuestoDet presDet : listaDetallesEliminados) {
                try {
                    presupuestoDetFacade.remove(presDet);
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
            int nroSerie = listaDetalle.isEmpty() ? 0 : 1;
            for (PresupuestoDet preDet : listaDetalle) {

                if (preDet.getPresupuestoCab() != null) {
                    presupuestoDet = preDet; //si mantiene el nro de orden, es que solo edite la descripción
                } else {
                    PresupuestoDetPK presupuestoDetPK
                            = new PresupuestoDetPK(this.presupuestoCab.getPresupuestoCabPK().getTipoPresupuesto(),
                                    this.presupuestoCab.getPresupuestoCabPK().getSerPresupuesto(),
                                    this.presupuestoCab.getPresupuestoCabPK().getNroPresupuesto(),
                                    BigInteger.valueOf(nroSerie));
                    presupuestoDet = new PresupuestoDet(presupuestoDetPK);
                    presupuestoDet.setPresupuestoCab(presupuestoCab);
                    presupuestoDet.setCantidad(preDet.getCantidad());
                    presupuestoDet.setPrecio(preDet.getPrecio());
                    presupuestoDet.setTotalDescuento(preDet.getTotalDescuento());
                    presupuestoDet.setTotalDetalle(preDet.getTotalDetalle());
                    presupuestoDet.setCodProducto(preDet.getCodProducto());

                    nroSerie++;
                }

                try {
                    if (null != persistAction) {
                        switch (persistAction) {
                            case CREATE:
                                presupuestoDetFacade.create(presupuestoDet);
                                break;
                            case UPDATE:
                                presupuestoDetFacade.edit(presupuestoDet);
                                break;
                            default:
                                presupuestoDetFacade.remove(presupuestoDet);
                                break;
                        }
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

    public void refrescarFooter() {
        System.out.println("Suma: " + getSumaTotal());
        System.out.println("IVA: " + getIva());
        System.out.println("Total: " + getPresupuestoTotal());
    }

    public String getSumaTotal() {
        int total = 0;
        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
            total += det.getTotalDetalle().intValue();
        }
        this.sumaTotal = new DecimalFormat("###,###").format(total);
        return this.sumaTotal;
    }

    public String getIva() {
        int ivaCalculado = 0;
        int total = 0;
        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
            total += det.getTotalDetalle().intValue();
        }

        ivaCalculado = total * 10 / 100;

        this.iva = new DecimalFormat("###,###").format(ivaCalculado);
        return this.iva;
    }

    public String getPresupuestoTotal() {
        int ivaCalculado = 0;
        int total = 0;
        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
            total += det.getTotalDetalle().intValue();
        }

        ivaCalculado = total * 10 / 100;

        int presupuestoCalculado = total + ivaCalculado;

        this.presupuestoTotal = new DecimalFormat("###,###").format(presupuestoCalculado);
        return this.presupuestoTotal;
    }

    public void onRowEditDetalle(RowEditEvent event) {
        PresupuestoDet det = (PresupuestoDet) event.getObject();
        BigInteger precio = det.getPrecio();
        BigInteger cantidad = det.getCantidad();
        BigInteger descuento = det.getTotalDescuento();
        int total = (precio.intValue() * cantidad.intValue()) - descuento.intValue();
        det.setTotalDetalle(new BigInteger(total + ""));
        //this.sumaTotal = refreshOrdenCompraTotal();
        System.out.println("Editando Producto: " + det.getCodProducto().getDescripcion() + ", total a pagar: " + det.getTotalDetalle());
    }

    public void onRowCancelDetalle(RowEditEvent event) {
        PresupuestoDet det = (PresupuestoDet) event.getObject();

        String descripcion = det.getCodProducto().getDescripcion(); //obtengo la descripción de la tarea

        //si es vacio, es porque es nuevo
        if ("".equalsIgnoreCase(descripcion)) {
            //al cancelar borro la ultima fila insertada
            listaDetalle.remove(det);
        }
    }

    public void addTarea() {
        int i = this.listaDetalle.size() + 1;
        PresupuestoDetPK detPK = new PresupuestoDetPK();
        detPK.setNroSecuencia(BigInteger.valueOf(i));
        PresupuestoDet predet = new PresupuestoDet(detPK);
        predet.setCodProducto(new Productos());
        predet.setTotalDescuento(BigInteger.ZERO);
        predet.setTotalDetalle(BigInteger.ZERO);
        this.listaDetalle.add(predet);
    }

    public void removeTarea(PresupuestoDet item) {
        listaDetallesEliminados.add(item);
        this.listaDetalle.remove(item);
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }
}
