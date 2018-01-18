package session;

import entities.DiagnosticoDet;
import bean.DiagnosticoDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "diagnosticoDetController")
@ViewScoped
public class DiagnosticoDetController extends AbstractController<DiagnosticoDet> {

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

}
