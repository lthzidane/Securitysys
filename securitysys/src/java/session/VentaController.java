package session;

import entities.Venta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ventaController")
@ViewScoped
public class VentaController extends AbstractController<Venta> {

    @Inject
    private AperturaCierreCajaController idAperturaCierreController;
    @Inject
    private ClienteController idClienteController;
    @Inject
    private PresupuestoController idPresupuestoController;
    @Inject
    private SerieComprobanteController idSerieComprobanteController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private TimbradoController idTimbradoController;
    @Inject
    private TipoComprobanteController idTipoComprobanteController;
    @Inject
    private UsuarioController idUsuarioController;

    public VentaController() {
        // Inform the Abstract parent controller of the concrete Venta Entity
        super(Venta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAperturaCierreController.setSelected(null);
        idClienteController.setSelected(null);
        idPresupuestoController.setSelected(null);
        idSerieComprobanteController.setSelected(null);
        idSucursalController.setSelected(null);
        idTimbradoController.setSelected(null);
        idTipoComprobanteController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CtaACobrar entities that
     * are retrieved from Venta?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CtaACobrar page
     */
    public String navigateCtaACobrarList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CtaACobrar_items", this.getSelected().getCtaACobrarList());
        }
        return "/ctaACobrar/index";
    }

    /**
     * Sets the "selected" attribute of the AperturaCierreCaja controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAperturaCierre(ActionEvent event) {
        if (this.getSelected() != null && idAperturaCierreController.getSelected() == null) {
            idAperturaCierreController.setSelected(this.getSelected().getIdAperturaCierre());
        }
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        if (this.getSelected() != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(this.getSelected().getIdCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Presupuesto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPresupuesto(ActionEvent event) {
        if (this.getSelected() != null && idPresupuestoController.getSelected() == null) {
            idPresupuestoController.setSelected(this.getSelected().getIdPresupuesto());
        }
    }

    /**
     * Sets the "selected" attribute of the SerieComprobante controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSerieComprobante(ActionEvent event) {
        if (this.getSelected() != null && idSerieComprobanteController.getSelected() == null) {
            idSerieComprobanteController.setSelected(this.getSelected().getIdSerieComprobante());
        }
    }

    /**
     * Sets the "selected" attribute of the Sucursal controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSucursal(ActionEvent event) {
        if (this.getSelected() != null && idSucursalController.getSelected() == null) {
            idSucursalController.setSelected(this.getSelected().getIdSucursal());
        }
    }

    /**
     * Sets the "selected" attribute of the Timbrado controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTimbrado(ActionEvent event) {
        if (this.getSelected() != null && idTimbradoController.getSelected() == null) {
            idTimbradoController.setSelected(this.getSelected().getIdTimbrado());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoComprobante controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoComprobante(ActionEvent event) {
        if (this.getSelected() != null && idTipoComprobanteController.getSelected() == null) {
            idTipoComprobanteController.setSelected(this.getSelected().getIdTipoComprobante());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        if (this.getSelected() != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(this.getSelected().getIdUsuario());
        }
    }

    /**
     * Sets the "items" attribute with a collection of NotaCrediDebiVenta
     * entities that are retrieved from Venta?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaCrediDebiVenta page
     */
    public String navigateNotaCrediDebiVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaCrediDebiVenta_items", this.getSelected().getNotaCrediDebiVentaList());
        }
        return "/notaCrediDebiVenta/index";
    }

    /**
     * Sets the "items" attribute with a collection of VentaDet entities that
     * are retrieved from Venta?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for VentaDet page
     */
    public String navigateVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("VentaDet_items", this.getSelected().getVentaDetList());
        }
        return "/ventaDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotaRemisionVenta
     * entities that are retrieved from Venta?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaRemisionVenta page
     */
    public String navigateNotaRemisionVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaRemisionVenta_items", this.getSelected().getNotaRemisionVentaList());
        }
        return "/notaRemisionVenta/index";
    }

    /**
     * Sets the "items" attribute with a collection of LibroVenta entities that
     * are retrieved from Venta?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for LibroVenta page
     */
    public String navigateLibroVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LibroVenta_items", this.getSelected().getLibroVentaList());
        }
        return "/libroVenta/index";
    }

}
