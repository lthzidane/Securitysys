package session;

import entities.Zona;
import entities.Ruta;
import entities.Cuadrilla;
import java.util.List;
import bean.ZonaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "zonaController")
@ViewScoped
public class ZonaController extends AbstractController<Zona> {

    public ZonaController() {
        // Inform the Abstract parent controller of the concrete Zona Entity
        super(Zona.class);
    }

}
