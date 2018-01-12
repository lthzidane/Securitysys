package session;

import entities.Diagnostico;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "diagnosticoController")
@ViewScoped
public class DiagnosticoController extends AbstractController<Diagnostico> {

    @Inject
    private ReclamoController idReclamoController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private UsuarioController idUsuarioController;

    public DiagnosticoController() {
        // Inform the Abstract parent controller of the concrete Diagnostico Entity
        super(Diagnostico.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idReclamoController.setSelected(null);
        idSucursalController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DiagnosticoDet entities
     * that are retrieved from Diagnostico?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DiagnosticoDet page
     */
    public String navigateDiagnosticoDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DiagnosticoDet_items", this.getSelected().getDiagnosticoDetList());
        }
        return "/diagnosticoDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of Presupuesto entities that
     * are retrieved from Diagnostico?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Presupuesto page
     */
    public String navigatePresupuestoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Presupuesto_items", this.getSelected().getPresupuestoList());
        }
        return "/presupuesto/index";
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
