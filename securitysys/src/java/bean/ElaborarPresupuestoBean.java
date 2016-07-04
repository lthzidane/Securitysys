package bean;

import entities.Departamento;
import entities.PresupuestoDet;
import entities.PresupuestoDetPK;
import entities.Productos;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
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
    private String fechaRecepcion;
    private ArrayList<PresupuestoDet> listaDetalle = new ArrayList<PresupuestoDet>();
    private ArrayList<PresupuestoDet> listaDetallesEliminados = new ArrayList<PresupuestoDet>();
    private List<Productos> listaProductos = new ArrayList<Productos>();
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

    @EJB
    private bean.ProductosFacade productoFacade = new ProductosFacade();
    private String selectedItem;

    @PostConstruct
    void initialiseSession() {
        this.cargarVista();
    }

    public void cargarVista() {

        try {

//            setDetalleOC(new ArrayList<Sale>());
//            for (int i = 0; i < 10; i++) {
//
//                int cant = getRandomAmount();
//                int pUni = getRandomPercentage();
//                getDetalleOC().add(new Sale(getNombreProducto()[i],
//                        i + 1,
//                        cant,
//                        pUni,
//                        cant * pUni));
//            }
            nroDeOrden = "0001";

            Date date = Calendar.getInstance().getTime();

            this.listaProductos = productoFacade.findAll();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            fechaPedido = today;

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
        }
    }

    public String guardarProducto() {
        FacesContext context = FacesContext.getCurrentInstance();
        String mensaje = "";

        context.addMessage(null, new FacesMessage("¡!", mensaje));

        if (mensaje.contains("Error")) {
            return null;
        }

        this.editando = false; //ya terminé de Editar o Guardar

        return "Volver";
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

}
