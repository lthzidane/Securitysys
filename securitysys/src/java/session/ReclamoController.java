package session;

import entities.Reclamo;
import entities.OrdenTrabajo;
import entities.Diagnostico;
import java.util.List;
import bean.ReclamoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "reclamoController")
@ViewScoped
public class ReclamoController extends AbstractController<Reclamo> {

    public ReclamoController() {
        // Inform the Abstract parent controller of the concrete Reclamo Entity
        super(Reclamo.class);
    }

}
