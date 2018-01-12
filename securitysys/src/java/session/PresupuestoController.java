package session;

import entities.Presupuesto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "presupuestoController")
@ViewScoped
public class PresupuestoController extends AbstractController<Presupuesto> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private DiagnosticoController idController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private UsuarioController idUsuarioController;

    public PresupuestoController() {
        // Inform the Abstract parent controller of the concrete Presupuesto Entity
        super(Presupuesto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        idController.setSelected(null);
        idEstadoController.setSelected(null);
        idSucursalController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Promocion entities that
     * are retrieved from Presupuesto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Promocion page
     */
    public String navigatePromocionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Promocion_items", this.getSelected().getPromocionList());
        }
        return "/promocion/index";
    }

    /**
     * Sets the "items" attribute with a collection of PresupuestoDet entities
     * that are retrieved from Presupuesto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PresupuestoDet page
     */
    public String navigatePresupuestoDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PresupuestoDet_items", this.getSelected().getPresupuestoDetList());
        }
        return "/presupuestoDet/index";
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
     * Sets the "selected" attribute of the Diagnostico controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareId(ActionEvent event) {
        if (this.getSelected() != null && idController.getSelected() == null) {
            idController.setSelected(this.getSelected().getId());
        }
    }

    /**
     * Sets the "selected" attribute of the Estado controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstado(ActionEvent event) {
        if (this.getSelected() != null && idEstadoController.getSelected() == null) {
            idEstadoController.setSelected(this.getSelected().getIdEstado());
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
     * Sets the "items" attribute with a collection of OrdenTrabajo entities
     * that are retrieved from Presupuesto?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenTrabajo page
     */
    public String navigateOrdenTrabajoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenTrabajo_items", this.getSelected().getOrdenTrabajoList());
        }
        return "/ordenTrabajo/index";
    }

    /**
     * Sets the "items" attribute with a collection of Venta entities that are
     * retrieved from Presupuesto?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Venta page
     */
    public String navigateVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Venta_items", this.getSelected().getVentaList());
        }
        return "/venta/index";
    }

}
