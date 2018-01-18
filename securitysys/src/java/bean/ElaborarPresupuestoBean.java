package bean;

import entities.Cliente;
import entities.Estado;

import entities.Presupuesto;

import entities.PresupuestoDet;
import entities.PresupuestoDetPK;

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
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import org.primefaces.event.RowEditEvent;
import session.util.JsfUtil;

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

//    public void refrescarFooter() {
//        System.out.println("Suma: " + getSumaTotal());
//        System.out.println("IVA: " + getIva());
//        System.out.println("Total: " + getPresupuestoTotal());
//    }
//
//    public String getSumaTotal() {
//        int total = 0;
//        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
//            total += det.getTotalDetalle().intValue();
//        }
//        this.sumaTotal = new DecimalFormat("###,###").format(total);
//        return this.sumaTotal;
//    }
//
//    public String getIva() {
//        int ivaCalculado = 0;
//        int total = 0;
//        for (PresupuestoDet det : listaDetalle) { // this is the list used in the value attribute of datatable
//            total += det.getTotalDetalle().intValue();
//        }
//
//        ivaCalculado = total * 10 / 100;
//
//        this.iva = new DecimalFormat("###,###").format(ivaCalculado);
//        return this.iva;
//    }
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

//    public void onRowEditDetalle(RowEditEvent event) {
//        PresupuestoDet det = (PresupuestoDet) event.getObject();
//        BigInteger precio = det.getPrecio();
//        BigInteger cantidad = det.getCantidad();
//        BigInteger descuento = det.getTotalDescuento();
//        int total = (precio.intValue() * cantidad.intValue()) - descuento.intValue();
//        det.setTotalDetalle(new BigInteger(total + ""));
//        //this.sumaTotal = refreshOrdenCompraTotal();
//        System.out.println("Editando Producto: " + det.getCodProducto().getObservacion() + ", total a pagar: " + det.getTotalDetalle());
//    }
//
//    public void onRowCancelDetalle(RowEditEvent event) {
//        PresupuestoDet det = (PresupuestoDet) event.getObject();
//
//        String descripcion = det.getCodProducto().getObservacion(); //obtengo la descripción de la tarea
//
//        //si es vacio, es porque es nuevo
//        if ("".equalsIgnoreCase(descripcion)) {
//            //al cancelar borro la ultima fila insertada
//            listaDetalle.remove(det);
//        }
//    }
//
//    public void addTarea() {
//        int i = this.listaDetalle.size() + 1;
//        PresupuestoDetPK detPK = new PresupuestoDetPK();
//        detPK.setNroSecuencia(BigInteger.valueOf(i));
//        PresupuestoDet predet = new PresupuestoDet(detPK);
//        predet.setCodProducto(new Productos());
//        predet.setTotalDescuento(BigInteger.ZERO);
//        predet.setTotalDetalle(BigInteger.ZERO);
//        this.listaDetalle.add(predet);
//    }

    public void removeTarea(PresupuestoDet item) {
        listaDetallesEliminados.add(item);
        this.listaDetalle.remove(item);
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
