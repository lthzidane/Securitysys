/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entities.Cliente;
import entities.Departamento;
import entities.EstadoTrab;
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
@ManagedBean(name="GestionarReclamoBean")
@ViewScoped
@Data
public class GestionarReclamoBean implements Serializable{
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
    private Integer idEstadoTrab;
    private Integer idTiporeclamo;
    private Integer idSubTiporeclamo;
    private Integer idNivel;
    private String usuario;
    private Integer idDepartamento;
    private String tipoServicio;
    private String nroOrden;
    private String nroDocumento;
    private String razonsocial;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String observacion;
    private ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();
    private ArrayList<Tecnicos> listaTecnicos = new ArrayList<Tecnicos>();
    private List<EstadoTrab> listaEstados = new ArrayList<EstadoTrab>();
    private List<Tiporeclamo> listaTipoReclamo = new ArrayList<Tiporeclamo>();
    private List<Subtipo> listaSubTipoReclamo = new ArrayList<Subtipo>();
    private List<Nivel> listaNivel = new ArrayList<Nivel>();
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
    private bean.TiporeclamoFacade tiporeclamoFacade = new TiporeclamoFacade();
    @EJB
    private bean.SubtipoFacade subtiporeclamoFacade = new SubtipoFacade();
    @EJB
    private bean.NivelFacade nivelFacade = new NivelFacade();
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
                String today = formatter.format(date);
                fechaRecepcion = today;
                
                this.listaEstados = estadoTrabFacade.findAll();
                this.idEstadoTrab = 1; //poner a Pendiente = 1 por defecto
                
                this.listaDepartamentos = obtenerDepartamentos();
                this.idDepartamento = 4; //poner a Reclamos = 4 por defecto
                
                this.listaTipoReclamo = tiporeclamoFacade.findAll();
                this.listaSubTipoReclamo = subtiporeclamoFacade.findAll();
                this.listaNivel = nivelFacade.findAll();
                this.usuario = (String)SessionBean.getSession().getAttribute("username");
                
                
                this.listaTecnicos = obtenerTecnicos();
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
                this.fechaInicio = null;
                this.fechaFin = null;
                this.nroOrden = "";
                this.nroDocumento = "";
                this.ciudad = "";
                this.telefono = "";
                this.direccion = "";
                this.razonsocial = "";
                this.observacion = "";

            }else{
                //estoy editando
                String idInstal = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idInstal");
                InstalacionCab instalCab = ejbInstalCabFacade.findByIdInstalacion(Integer.parseInt(idInstal));
                
                if (instalCab != null) {
                    
                    if (instalCab.getNroOrden().getOrdenTrabajoDetList().isEmpty()) {
                        List<OrdenTrabajoDet> listaOrdenesTrabajoDet = ejbOTDetFacade.findByNroOrden(instalCab.getNroOrden().getNroOrden().intValue());
                        if (listaOrdenesTrabajoDet.size() > 0) {
                            instalCab.getNroOrden().setOrdenTrabajoDetList(listaOrdenesTrabajoDet);
                            System.out.println("seteo la cantitad real: " + listaOrdenesTrabajoDet.size());
                        }
                    }                    
                    
                    nroDeReclamo = "000" + idInstal;

                    this.fechaInicio = instalCab.getFechainstalacion();
                    
                    this.listaDepartamentos = obtenerDepartamentos();
                    this.idDepartamento = instalCab.getIdServicio().getIdServicio().intValue();
                    
                    this.listaTecnicos = obtenerTecnicos();
                    
                    this.listaEstados = estadoTrabFacade.findAll();
                    this.idEstadoTrab = instalCab.getIdEstadoTrab().getIdEstadoTrab().intValue();

                    this.listaMoviles = movilesFacade.findAll();
                    this.movil = instalCab.getIdMovil();
                    
                    this.listaKits = productoKitFacade.findAll();
                    //traemos los detalles
                    obtenerDetallesInstalacion(instalCab.getIdInstalacion());
                    
                    this.tipoInstalacion = instalCab.getTipoInstalacion();
                    this.movil = instalCab.getIdMovil();
                    this.tipoServicio = instalCab.getNroOrden().getIdServicio().getDescripcion();
                    this.tecnicoResponsable = instalCab.getNroOrden().getIdTecnico().getNombre();
                    listaDetalle = instalCab.getNroOrden().getOrdenTrabajoDetList();
                    this.ordenTrabajoCab = instalCab.getNroOrden();
                    this.idCliente = instalCab.getNroOrden().getIdCliente().getIdCliente().intValue();
                    this.fechaFin = instalCab.getFechaFinInstalacion();
                    
                    this.nroOrden = instalCab.getNroOrden().getNroOrden().toString();
                    this.nroDocumento = instalCab.getNroOrden().getIdCliente().getNroDocumento();
                    this.ciudad = instalCab.getNroOrden().getIdCliente().getIdCiudad().getCiudad();
                    this.telefono = instalCab.getNroOrden().getIdCliente().getTelefono();
                    this.direccion = instalCab.getNroOrden().getIdCliente().getDireccion();
                    this.razonsocial = instalCab.getNroOrden().getIdCliente().getNombre()+" "+instalCab.getNroOrden().getIdCliente().getApellido();
                    this.observacion = instalCab.getDescripcion();
                }
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
    
    public String guardarReclamo(){
        return "";
    }
    
    
    public String guardarOrdenInstalacion(){
    
        instalacionCab = new InstalacionCab();
        instalacionCab.setDescripcion(this.observacion);
        instalacionCab.setNroOrden(this.ordenTrabajoCab);
        instalacionCab.setIdTecnico(this.ordenTrabajoCab.getIdTecnico());
        instalacionCab.setTipoInstalacion(this.tipoInstalacion);
        instalacionCab.setFechainstalacion(this.fechaInicio);
        instalacionCab.setIdServicio(this.ordenTrabajoCab.getIdServicio());
        instalacionCab.setIdMovil(this.movil);
        instalacionCab.setIdCliente(this.ordenTrabajoCab.getIdCliente());
        instalacionCab.setIdEstadoTrab(estadoTrabFacade.findByIdEstadoTrab(idEstadoTrab));

        if(!editando){
            persistInstalCab(PersistAction.CREATE, null);
            persistInstalDet(PersistAction.CREATE, selectedKits, instalacionCab.getIdInstalacion(), "Instalacion guardada correctamente");
            
            cargarVista();    
        }else{
            //estoy editando
            instalacionCab.setIdInstalacion(BigDecimal.valueOf(Integer.parseInt(this.nroDeReclamo)));
            persistInstalCab(PersistAction.UPDATE, null);
            persistInstalDet(PersistAction.UPDATE, selectedKits, instalacionCab.getIdInstalacion(), "Instalacion guardada correctamente");
         
            this.editando = false;
            
            return "BuscarModificarOT";
        }
        
        
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
    
    private ArrayList<Departamento> obtenerDepartamentos() {
        Departamento departamento = null;
        ArrayList<Departamento> list = new ArrayList<Departamento>();

        try {
            
            PreparedStatement ps = con.prepareStatement("SELECT id_dpto, nombre_dpto FROM departamento");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                departamento = new Departamento();
                String id_dpto = rs.getString("id_dpto");
                String descripcion = rs.getString("nombre_dpto");
                
                departamento.setIdDpto(new BigDecimal(id_dpto));
                departamento.setNombreDpto(descripcion);
                list.add(departamento);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Departamento -->" + ex.getMessage());
            
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

                if (ordenTrabajoCab.getOrdenTrabajoDetList().isEmpty()) {
                    List<OrdenTrabajoDet> listaOrdenesTrabajoDet = ejbOTDetFacade.findByNroOrden(ordenTrabajoCab.getNroOrden().intValue());
                    if (listaOrdenesTrabajoDet.size() > 0) {
                        ordenTrabajoCab.setOrdenTrabajoDetList(listaOrdenesTrabajoDet);
                        System.out.println("seteo la cantitad real: " + listaOrdenesTrabajoDet.size());
                    }
                }

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
        
        if(!instalacionesDetList.isEmpty()){
            //borramos los que ya no están
            for(InstalacionDet instalacionDet : instalacionesDetList){
                ProductosKit instaDetPrkit = new ProductosKit( new BigDecimal(instalacionDet.getIdProductosKit()) );
                if( !selectedKits.contains(instaDetPrkit) ){
                    System.out.println("No esta el detalle en selectedKits, se debe eliminar");
                    getEjbInstalDetFacade().remove(instalacionDet);
                }else{
                    //si es que está todavía, sacarlo de la lista de seleccionados, para que no inserte dos veces
                    selectedKits.remove(instaDetPrkit);
                }
            }
        }
        
        if (selectedProdKits != null && !selectedProdKits.isEmpty()) {
            for(ProductosKit prodKit : selectedKits ) {
                //solo inserto si es nuevo
                InstalacionDet instalacionDet = new InstalacionDet();
                instalacionDet.setCodProducto(prodKit.getCodProducto().getCodProducto().toBigInteger());
                instalacionDet.setIdProductosKit(prodKit.getIdProductosKit().toBigInteger());

                InstalacionDetPK pk = new InstalacionDetPK();
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
    
    public void obtenerDetallesInstalacion(BigDecimal idInstalacionCab) {
        System.out.println("nroDocumentoCliente: " + idInstalacionCab);
        if (idInstalacionCab != null ) {
            Connection con = null;
            PreparedStatement ps = null;

            try {
                con = DataConnect.getConnection();
                ps = con.prepareStatement("SELECT id.id_instalacion, id.nro_linea, pk.id_productos_kit, pk.cantidad, pr.cod_producto, pr.descripcion, m.id_medida, m.desc_medida FROM productos_kit pk, productos pr, medidas m, instalacion_det id where pk.cod_producto = pr.cod_producto and pr.id_medida = m.id_medida and pk.id_productos_kit = id.id_productos_kit and id.id_instalacion = ?");
                ps.setInt(1, idInstalacionCab.intValue() );
                //ps.setInt(1, Integer.parseInt(idInstalacionCab));

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    ProductosKit prodKit = new ProductosKit(rs.getBigDecimal("id_productos_kit"));
                    prodKit.setCantidad(BigInteger.valueOf(rs.getInt("cantidad")) );
                    
                    Productos prod = new Productos();
                    prod.setCodProducto(rs.getBigDecimal("cod_producto"));
                    prod.setDescripcion(rs.getString("descripcion"));
                    
                    Medidas med = new Medidas(rs.getBigDecimal("id_medida"), rs.getString("desc_medida"));
                    
                    prod.setIdMedida(med);
                    prodKit.setCodProducto(prod);
                    
                    selectedKits.add(prodKit);
                    
                    InstalacionDetPK instaldetPK = new InstalacionDetPK( 
                            BigInteger.valueOf(rs.getInt("id_instalacion")),
                            BigInteger.valueOf(rs.getInt("nro_linea")));
                    InstalacionDet instaldet = new InstalacionDet(instaldetPK);
                    instaldet.setCodProducto(prodKit.getCodProducto().getCodProducto().toBigInteger());
                    instaldet.setIdProductosKit(prodKit.getIdProductosKit().toBigInteger());
                    instalacionesDetList.add(instaldet);
                }
            } catch (SQLException ex) {
                System.out.println("Error al obtener Productos Kit -->" + ex.getMessage());

            } finally {
                DataConnect.close(con);
            }
        }
    }
    
    public void onDateSelect(SelectEvent event) {
        if (event.getObject() != null) {
            this.fechaInicio = (Date)event.getObject();
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
    
}
