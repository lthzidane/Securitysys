package session;

import entities.NotaRemisionVenta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "notaRemisionVentaController")
@ViewScoped
public class NotaRemisionVentaController extends AbstractController<NotaRemisionVenta> {

    @Inject
    private MotivoNotaDebiController idMotivoNotaController;
    @Inject
    private MovilesController idMovilController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private TipoComprobanteController idTipoComprobanteController;
    @Inject
    private UsuarioController idUsuarioController;
    @Inject
    private VentaController idVentaController;

    public NotaRemisionVentaController() {
        // Inform the Abstract parent controller of the concrete NotaRemisionVenta Entity
        super(NotaRemisionVenta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMotivoNotaController.setSelected(null);
        idMovilController.setSelected(null);
        idSucursalController.setSelected(null);
        idTipoComprobanteController.setSelected(null);
        idUsuarioController.setSelected(null);
        idVentaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of NotaRemisionVentaDet
     * entities that are retrieved from NotaRemisionVenta?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for NotaRemisionVentaDet page
     */
    public String navigateNotaRemisionVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaRemisionVentaDet_items", this.getSelected().getNotaRemisionVentaDetList());
        }
        return "/notaRemisionVentaDet/index";
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
     * Sets the "selected" attribute of the Moviles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMovil(ActionEvent event) {
        if (this.getSelected() != null && idMovilController.getSelected() == null) {
            idMovilController.setSelected(this.getSelected().getIdMovil());
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
