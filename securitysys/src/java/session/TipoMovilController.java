package session;

import entities.TipoMovil;
import entities.Moviles;
import java.util.List;
import bean.TipoMovilFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoMovilController")
@ViewScoped
public class TipoMovilController extends AbstractController<TipoMovil> {

    public TipoMovilController() {
        // Inform the Abstract parent controller of the concrete TipoMovil Entity
        super(TipoMovil.class);
    }

}
