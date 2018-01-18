package session;

import entities.Servicio;
import entities.SolicitudDet;
import entities.PromocionDet;
import entities.Contrato;
import entities.SegmentoContrato;
import java.util.List;
import bean.ServicioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "servicioController")
@ViewScoped
public class ServicioController extends AbstractController<Servicio> {

    public ServicioController() {
        // Inform the Abstract parent controller of the concrete Servicio Entity
        super(Servicio.class);
    }

}
