package session;

import entities.Tecnico;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "tecnicoController")
@ViewScoped
public class TecnicoController extends AbstractController<Tecnico> {

    public TecnicoController() {
        // Inform the Abstract parent controller of the concrete Tecnico Entity
        super(Tecnico.class);
    }

}
