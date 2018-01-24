package bean;

import entities.Estado;

import entities.Presupuesto;

import entities.PresupuestoDet;
import entities.PresupuestoDetPK;
import entities.Servicio;

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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author sebas
 */
@ManagedBean(name = "ElaborarPresupuestoBean")
@ViewScoped
@Data
public class ElaborarPresupuestoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nroDeOrden;
    private String proveedor; //CNDDI = Codigo No Dependiente Del Idioma
    private String language; //{ESN,ENU,FRA}
    private String orderBy; //Pedido
    private BigDecimal pedido;
    private boolean active;
    private boolean translate;
    private boolean multilingual;
    private String estado;
    private String description;
    private boolean editando = false;
    private String fechaPedido;
    private Date fechaPedidoDate;
    private ArrayList<PresupuestoDet> listaDetalle = new ArrayList<>();
    private ArrayList<PresupuestoDet> listaDetallesEliminados = new ArrayList<>();
    private List<Servicio> listaServicios = new ArrayList<>();

    private List<Estado> listaEstados = new ArrayList<>();
    private String sumaTotal;
    private String iva;
    private String presupuestoTotal;
    private String cliente;
    private int idCliente;
    private String nroDocumento;
    private String razonsocial;
    private String ciudad;
    private String direccion;
    private String telefono;

    private Estado idEstado;

    private Presupuesto Presupuesto;
    private PresupuestoDet presupuestoDet;

    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy"); //defino el formato de fecha

    @EJB
    private bean.PresupuestoFacade PresupuestoFacade = new PresupuestoFacade();

    @EJB
    private bean.PresupuestoDetFacade presupuestoDetFacade = new PresupuestoDetFacade();

    @EJB
    private bean.EstadoFacade estadoFacade = new EstadoFacade();

    @EJB
    private bean.ServicioFacade servicioFacade = new ServicioFacade();

    @PostConstruct
    void initialiseSession() {
        this.cargarVista();
    }

    public void cargarVista() {

        try {

            nroDeOrden = "0001";

            Date date = Calendar.getInstance().getTime();
            String today = FORMATTER.format(date);
            fechaPedido = today;
            fechaPedidoDate = date;

            //Crea un Presupuesto inicial
            this.Presupuesto = new Presupuesto();

            this.Presupuesto.setFecha(date);

            this.listaEstados = estadoFacade.findAll();

            this.listaServicios = servicioFacade.findAll();

            proveedor = ""; //CNDDI = Codigo No Dependiente Del Idioma
            language = "ESN"; //{ESN,ENU,FRA} por defecto Español
            orderBy = ""; //Pedido
            pedido = null;
            active = false;
            translate = false;
            multilingual = false;
            estado = "Pendiente";
            description = "";

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String guardarPresupuesto() {

        String sumaTotalSinPunto = this.sumaTotal.replace(".", "");
        this.Presupuesto.setIdEstado(this.idEstado);
//        persistPresupuesto(JsfUtil.PersistAction.CREATE, null);
//        System.out.println("se guardó la Presupuesto con exito > " + JsfUtil.isValidationFailed());

//        persistPresupuestoDet(JsfUtil.PersistAction.CREATE, listaDetalle, "PresupuestoDet guardado correctamente");
//        System.out.println("se guardó la PresupuestoDet con exito");
        //limpiar campos
        cargarVista();

        return null;
    }

//    private void persistPresupuesto(JsfUtil.PersistAction persistAction, String successMessage) {
//        if (Presupuesto != null) {
//
//            try {
//                if (null != persistAction) {
//                    switch (persistAction) {
//                        case CREATE:
//                            PresupuestoFacade.create(Presupuesto);
//                            break;
//                        case UPDATE:
//                            PresupuestoFacade.edit(Presupuesto);
//                            break;
//                        default:
//                            PresupuestoFacade.remove(Presupuesto);
//                            break;
//                    }
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
//    private void persistPresupuestoDet(JsfUtil.PersistAction persistAction,
//            ArrayList<PresupuestoDet> listaDetalle,
//            String successMessage) {
//
//        if (!listaDetallesEliminados.isEmpty()) { //si eliminé alguno de los detalles
//            for (PresupuestoDet presDet : listaDetallesEliminados) {
//                try {
//                    presupuestoDetFacade.remove(presDet);
//                } catch (EJBException ex) {
//                    String msg = "";
//                    Throwable cause = ex.getCause();
//                    if (cause != null) {
//                        msg = cause.getLocalizedMessage();
//                    }
//                    if (msg.length() > 0) {
//                        JsfUtil.addErrorMessage(msg);
//                    } else {
//                        JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                    }
//                } catch (Exception ex) {
//                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                }
//            }
//        }
//
//        if (listaDetalle != null && !listaDetalle.isEmpty()) {
//            int nroSerie = listaDetalle.isEmpty() ? 0 : 1;
//            for (PresupuestoDet preDet : listaDetalle) {
//
//                if (preDet.getPresupuesto() != null) {
//                    presupuestoDet = preDet; //si mantiene el nro de orden, es que solo edite la descripción
//                } else {
//                    PresupuestoDetPK presupuestoDetPK
//                            = new PresupuestoDetPK(this.Presupuesto.getPresupuestoPK().getTipoPresupuesto(),
//                                    this.Presupuesto.getPresupuestoPK().getSerPresupuesto(),
//                                    this.Presupuesto.getPresupuestoPK().getNroPresupuesto(),
//                                    BigInteger.valueOf(nroSerie));
//                    presupuestoDet = new PresupuestoDet(presupuestoDetPK);
//                    presupuestoDet.setPresupuesto(Presupuesto);
//                    presupuestoDet.setCantidad(preDet.getCantidad());
//                    presupuestoDet.setPrecio(preDet.getPrecio());
//                    presupuestoDet.setTotalDescuento(preDet.getTotalDescuento());
//                    presupuestoDet.setTotalDetalle(preDet.getTotalDetalle());
//                    presupuestoDet.setCodProducto(preDet.getCodProducto());
//
//                    nroSerie++;
//                }
//
//                try {
//                    if (null != persistAction) {
//                        switch (persistAction) {
//                            case CREATE:
//                                presupuestoDetFacade.create(presupuestoDet);
//                                break;
//                            case UPDATE:
//                                presupuestoDetFacade.edit(presupuestoDet);
//                                break;
//                            default:
//                                presupuestoDetFacade.remove(presupuestoDet);
//                                break;
//                        }
//                    }
//
//                } catch (EJBException ex) {
//                    String msg = "";
//                    Throwable cause = ex.getCause();
//                    if (cause != null) {
//                        msg = cause.getLocalizedMessage();
//                    }
//                    if (msg.length() > 0) {
//                        JsfUtil.addErrorMessage(msg);
//                    } else {
//                        JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                    }
//                } catch (Exception ex) {
//                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                }
//            }
//
//            if (successMessage != null) {
//                JsfUtil.addSuccessMessage(successMessage);
//            }
//        }
//    }
    public void refrescarFooter() {
        System.out.println("Suma: " + getSumaTotal());
        System.out.println("IVA: " + getIva());
        System.out.println("Total: " + getPresupuestoTotal());
    }
//
    public String getSumaTotal() {
        int total = 0;
        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
            if(det.getTotalDetalle() != null)
                total += Integer.parseInt(det.getTotalDetalle());
        }
        this.sumaTotal = new DecimalFormat("###,###").format(total);
        return this.sumaTotal;
    }

    public String getIva() {
        int ivaCalculado = 0;
        int total = 0;
        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
            if(det.getTotalDetalle() != null)
                total += Integer.parseInt(det.getTotalDetalle());
        }

        ivaCalculado = total * 10 / 100;

        this.iva = new DecimalFormat("###,###").format(ivaCalculado);
        return this.iva;
    }
//
//    public String getPresupuestoTotal() {
//        int ivaCalculado = 0;
//        int total = 0;
//        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
//            total += det.getTotalDetalle().intValue();
//        }
//
//        ivaCalculado = total * 10 / 100;
//
//        int presupuestoCalculado = total + ivaCalculado;
//
//        this.presupuestoTotal = new DecimalFormat("###,###").format(presupuestoCalculado);
//        return this.presupuestoTotal;
//    }
    public void obtenerDatosCliente() {
        String nroDocumentoCliente = this.cliente;
        System.out.println("nroDocumentoCliente: " + nroDocumentoCliente);
        if (nroDocumentoCliente != null && !"".equalsIgnoreCase(nroDocumentoCliente)) {
            Connection con = null;
            PreparedStatement ps = null;

            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("SELECT  cl.id_cliente, "
                        + "ci.ciudad, td.id_tipo_documento, "
                        + "cl.nombre, cl.apellido, cl.direccion, "
                        + "cl.telefono, cl.numero_documento "
                        + "FROM cliente cl, ciudad ci, "
                        + "tipo_documento td "
                        + "where numero_documento = ? "
                        + "and ci.id_ciudad = cl.id_ciudad "
                        + "and td.id_tipo_documento = cl.id_tipo_documento");
                ps.setString(1, nroDocumentoCliente);
                //ps.setInt(1, Integer.parseInt(nroDocumentoCliente));

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    this.idCliente = rs.getInt("id_cliente");
                    this.nroDocumento = rs.getString("numero_documento");
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

    public void onRowEditDetalle(RowEditEvent event) {
        PresupuestoDet det = (PresupuestoDet) event.getObject();
        int precio = det.getPrecio();
        int cantidad = det.getCantidad();
        String descuento = det.getTotalDescuento();
        int total = (precio * cantidad) - Integer.parseInt(descuento);
        det.setTotalDetalle(total + "");
        //this.sumaTotal = refreshOrdenCompraTotal();
        if(det.getCodProducto() != null)
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
        detPK.setIdSecuencia(i);
        PresupuestoDet predet = new PresupuestoDet(detPK);
        //predet.setCodProducto(new Productos());
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

    public String getNroDeOrden() {
        return nroDeOrden;
    }

    public void setNroDeOrden(String nroDeOrden) {
        this.nroDeOrden = nroDeOrden;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public BigDecimal getPedido() {
        return pedido;
    }

    public void setPedido(BigDecimal pedido) {
        this.pedido = pedido;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTranslate() {
        return translate;
    }

    public void setTranslate(boolean translate) {
        this.translate = translate;
    }

    public boolean isMultilingual() {
        return multilingual;
    }

    public void setMultilingual(boolean multilingual) {
        this.multilingual = multilingual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaPedidoDate() {
        return fechaPedidoDate;
    }

    public void setFechaPedidoDate(Date fechaPedidoDate) {
        this.fechaPedidoDate = fechaPedidoDate;
    }

    public ArrayList<PresupuestoDet> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(ArrayList<PresupuestoDet> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public ArrayList<PresupuestoDet> getListaDetallesEliminados() {
        return listaDetallesEliminados;
    }

    public void setListaDetallesEliminados(ArrayList<PresupuestoDet> listaDetallesEliminados) {
        this.listaDetallesEliminados = listaDetallesEliminados;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }



    public void setSumaTotal(String sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

  

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getPresupuestoTotal() {
        return presupuestoTotal;
    }

    public void setPresupuestoTotal(String presupuestoTotal) {
        this.presupuestoTotal = presupuestoTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Presupuesto getPresupuesto() {
        return Presupuesto;
    }

    public void setPresupuesto(Presupuesto Presupuesto) {
        this.Presupuesto = Presupuesto;
    }

    public PresupuestoDet getPresupuestoDet() {
        return presupuestoDet;
    }

    public void setPresupuestoDet(PresupuestoDet presupuestoDet) {
        this.presupuestoDet = presupuestoDet;
    }

    public PresupuestoFacade getPresupuestoFacade() {
        return PresupuestoFacade;
    }

    public void setPresupuestoFacade(PresupuestoFacade PresupuestoFacade) {
        this.PresupuestoFacade = PresupuestoFacade;
    }

    public PresupuestoDetFacade getPresupuestoDetFacade() {
        return presupuestoDetFacade;
    }

    public void setPresupuestoDetFacade(PresupuestoDetFacade presupuestoDetFacade) {
        this.presupuestoDetFacade = presupuestoDetFacade;
    }

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

}
