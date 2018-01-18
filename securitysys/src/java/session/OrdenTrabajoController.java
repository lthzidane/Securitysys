package session;

import entities.OrdenTrabajo;
import entities.InstalacionCab;
import entities.OrdenTrabajoDet;
import java.util.List;
import bean.OrdenTrabajoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ordenTrabajoController")
@ViewScoped
public class OrdenTrabajoController extends AbstractController<OrdenTrabajo> {

    public OrdenTrabajoController() {
        // Inform the Abstract parent controller of the concrete OrdenTrabajo Entity
        super(OrdenTrabajo.class);
    }

}
