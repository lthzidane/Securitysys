package session;

import entities.Solicitud;
import entities.SolicitudDet;
import entities.OrdenTrabajo;
import java.util.List;
import bean.SolicitudFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitudController")
@ViewScoped
public class SolicitudController extends AbstractController<Solicitud> {

    public SolicitudController() {
        // Inform the Abstract parent controller of the concrete Solicitud Entity
        super(Solicitud.class);
    }

}
