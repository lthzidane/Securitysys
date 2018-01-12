package session;

import entities.Reclamo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "reclamoController")
@ViewScoped
public class ReclamoController extends AbstractController<Reclamo> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private DepartamentoController idDepartamentoController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private TipoReclamoController idTipoReclamoController;
    @Inject
    private UsuarioController idUsuarioController;

    public ReclamoController() {
        // Inform the Abstract parent controller of the concrete Reclamo Entity
        super(Reclamo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        idDepartamentoController.setSelected(null);
        idEstadoController.setSelected(null);
        idSucursalController.setSelected(null);
        idTipoReclamoController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of OrdenTrabajo entities
     * that are retrieved from Reclamo?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDepartamento(ActionEvent event) {
        if (this.getSelected() != null && idDepartamentoController.getSelected() == null) {
            idDepartamentoController.setSelected(this.getSelected().getIdDepartamento());
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
     * Sets the "selected" attribute of the TipoReclamo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoReclamo(ActionEvent event) {
        if (this.getSelected() != null && idTipoReclamoController.getSelected() == null) {
            idTipoReclamoController.setSelected(this.getSelected().getIdTipoReclamo());
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
     * Sets the "items" attribute with a collection of Diagnostico entities that
     * are retrieved from Reclamo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Diagnostico page
     */
    public String navigateDiagnosticoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Diagnostico_items", this.getSelected().getDiagnosticoList());
        }
        return "/diagnostico/index";
    }

}
