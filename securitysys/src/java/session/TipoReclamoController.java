package session;

import entities.TipoReclamo;
import entities.Reclamo;
import java.util.List;
import bean.TipoReclamoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoReclamoController")
@ViewScoped
public class TipoReclamoController extends AbstractController<TipoReclamo> {

    public TipoReclamoController() {
        // Inform the Abstract parent controller of the concrete TipoReclamo Entity
        super(TipoReclamo.class);
    }

}
