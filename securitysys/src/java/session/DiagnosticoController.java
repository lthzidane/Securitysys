package session;

import entities.Diagnostico;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "diagnosticoController")
@ViewScoped
public class DiagnosticoController extends AbstractController<Diagnostico> {

    public DiagnosticoController() {
        // Inform the Abstract parent controller of the concrete Diagnostico Entity
        super(Diagnostico.class);
    }

}
