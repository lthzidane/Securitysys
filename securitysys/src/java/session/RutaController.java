package session;

import entities.Ruta;
import entities.Itinerario;
import java.util.List;
import bean.RutaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "rutaController")
@ViewScoped
public class RutaController extends AbstractController<Ruta> {

    public RutaController() {
        // Inform the Abstract parent controller of the concrete Ruta Entity
        super(Ruta.class);
    }

}
