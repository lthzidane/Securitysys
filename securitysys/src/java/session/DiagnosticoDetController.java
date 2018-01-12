package session;

import entities.DiagnosticoDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "diagnosticoDetController")
@ViewScoped
public class DiagnosticoDetController extends AbstractController<DiagnosticoDet> {

    @Inject
    private DiagnosticoController diagnosticoController;
    @Inject
    private EquipoController idEquipoController;

    public DiagnosticoDetController() {
        // Inform the Abstract parent controller of the concrete DiagnosticoDet Entity
        super(DiagnosticoDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDiagnosticoDetPK().setIdDiagnostico(this.getSelected().getDiagnostico().getId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDiagnosticoDetPK(new entities.DiagnosticoDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        diagnosticoController.setSelected(null);
        idEquipoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Diagnostico controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDiagnostico(ActionEvent event) {
        if (this.getSelected() != null && diagnosticoController.getSelected() == null) {
            diagnosticoController.setSelected(this.getSelected().getDiagnostico());
        }
    }

    /**
     * Sets the "selected" attribute of the Equipo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEquipo(ActionEvent event) {
        if (this.getSelected() != null && idEquipoController.getSelected() == null) {
            idEquipoController.setSelected(this.getSelected().getIdEquipo());
        }
    }
}
