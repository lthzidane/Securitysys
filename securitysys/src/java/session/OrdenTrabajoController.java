package session;

import entities.OrdenTrabajo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ordenTrabajoController")
@ViewScoped
public class OrdenTrabajoController extends AbstractController<OrdenTrabajo> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private CuadrillaController idCuadrillaController;
    @Inject
    private ItinerarioController idItinerarioController;
    @Inject
    private PresupuestoController idPresupuestoController;
    @Inject
    private ReclamoController idReclamoController;
    @Inject
    private SolicitudController idSolicitudController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private UsuarioController idUsuarioController;

    public OrdenTrabajoController() {
        // Inform the Abstract parent controller of the concrete OrdenTrabajo Entity
        super(OrdenTrabajo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        idCuadrillaController.setSelected(null);
        idItinerarioController.setSelected(null);
        idPresupuestoController.setSelected(null);
        idReclamoController.setSelected(null);
        idSolicitudController.setSelected(null);
        idSucursalController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of InstalacionCab entities
     * that are retrieved from OrdenTrabajo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for InstalacionCab page
     */
    public String navigateInstalacionCabList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InstalacionCab_items", this.getSelected().getInstalacionCabList());
        }
        return "/instalacionCab/index";
    }

    /**
     * Sets the "items" attribute with a collection of OrdenTrabajoDet entities
     * that are retrieved from OrdenTrabajo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenTrabajoDet page
     */
    public String navigateOrdenTrabajoDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenTrabajoDet_items", this.getSelected().getOrdenTrabajoDetList());
        }
        return "/ordenTrabajoDet/index";
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
     * Sets the "selected" attribute of the Cuadrilla controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCuadrilla(ActionEvent event) {
        if (this.getSelected() != null && idCuadrillaController.getSelected() == null) {
            idCuadrillaController.setSelected(this.getSelected().getIdCuadrilla());
        }
    }

    /**
     * Sets the "selected" attribute of the Itinerario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdItinerario(ActionEvent event) {
        if (this.getSelected() != null && idItinerarioController.getSelected() == null) {
            idItinerarioController.setSelected(this.getSelected().getIdItinerario());
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
     * Sets the "selected" attribute of the Reclamo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdReclamo(ActionEvent event) {
        if (this.getSelected() != null && idReclamoController.getSelected() == null) {
            idReclamoController.setSelected(this.getSelected().getIdReclamo());
        }
    }

    /**
     * Sets the "selected" attribute of the Solicitud controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSolicitud(ActionEvent event) {
        if (this.getSelected() != null && idSolicitudController.getSelected() == null) {
            idSolicitudController.setSelected(this.getSelected().getIdSolicitud());
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
}
