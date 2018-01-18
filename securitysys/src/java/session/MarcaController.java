package session;

import entities.Marca;
import entities.Moviles;
import java.util.List;
import bean.MarcaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "marcaController")
@ViewScoped
public class MarcaController extends AbstractController<Marca> {

    public MarcaController() {
        // Inform the Abstract parent controller of the concrete Marca Entity
        super(Marca.class);
    }

}
