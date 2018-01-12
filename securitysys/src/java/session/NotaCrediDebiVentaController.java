package session;

import entities.NotaCrediDebiVenta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "notaCrediDebiVentaController")
@ViewScoped
public class NotaCrediDebiVentaController extends AbstractController<NotaCrediDebiVenta> {

    @Inject
    private MotivoNotaDebiController idMotivoNotaController;
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
    @Inject
    private VentaController idVentaController;

    public NotaCrediDebiVentaController() {
        // Inform the Abstract parent controller of the concrete NotaCrediDebiVenta Entity
        super(NotaCrediDebiVenta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMotivoNotaController.setSelected(null);
        idSerieComprobanteController.setSelected(null);
        idSucursalController.setSelected(null);
        idTimbradoController.setSelected(null);
        idTipoComprobanteController.setSelected(null);
        idUsuarioController.setSelected(null);
        idVentaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of NotaCrediDebiVentaDet
     * entities that are retrieved from NotaCrediDebiVenta?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for NotaCrediDebiVentaDet page
     */
    public String navigateNotaCrediDebiVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaCrediDebiVentaDet_items", this.getSelected().getNotaCrediDebiVentaDetList());
        }
        return "/notaCrediDebiVentaDet/index";
    }

    /**
     * Sets the "selected" attribute of the MotivoNotaDebi controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMotivoNota(ActionEvent event) {
        if (this.getSelected() != null && idMotivoNotaController.getSelected() == null) {
            idMotivoNotaController.setSelected(this.getSelected().getIdMotivoNota());
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
     * Sets the "selected" attribute of the Venta controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdVenta(ActionEvent event) {
        if (this.getSelected() != null && idVentaController.getSelected() == null) {
            idVentaController.setSelected(this.getSelected().getIdVenta());
        }
    }
}
