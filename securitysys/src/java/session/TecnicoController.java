package session;

import entities.Tecnico;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tecnicoController")
@ViewScoped
public class TecnicoController extends AbstractController<Tecnico> {

    public TecnicoController() {
        // Inform the Abstract parent controller of the concrete Tecnico Entity
        super(Tecnico.class);
    }

}
