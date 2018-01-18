package session;

import entities.EntidadEmisora;
import entities.Tarjeta;
import java.util.List;
import bean.EntidadEmisoraFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "entidadEmisoraController")
@ViewScoped
public class EntidadEmisoraController extends AbstractController<EntidadEmisora> {

    public EntidadEmisoraController() {
        // Inform the Abstract parent controller of the concrete EntidadEmisora Entity
        super(EntidadEmisora.class);
    }

}
