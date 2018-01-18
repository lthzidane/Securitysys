package session;

import entities.Itinerario;
import entities.OrdenTrabajo;
import java.util.List;
import bean.ItinerarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "itinerarioController")
@ViewScoped
public class ItinerarioController extends AbstractController<Itinerario> {

    public ItinerarioController() {
        // Inform the Abstract parent controller of the concrete Itinerario Entity
        super(Itinerario.class);
    }

}
