package session;

import entities.Cuadrilla;
import entities.OrdenTrabajo;
import java.util.List;
import bean.CuadrillaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cuadrillaController")
@ViewScoped
public class CuadrillaController extends AbstractController<Cuadrilla> {

    public CuadrillaController() {
        // Inform the Abstract parent controller of the concrete Cuadrilla Entity
        super(Cuadrilla.class);
    }

}
