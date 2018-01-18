package session;

import entities.Nacionalidad;
import entities.Cliente;
import java.util.List;
import bean.NacionalidadFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "nacionalidadController")
@ViewScoped
public class NacionalidadController extends AbstractController<Nacionalidad> {

    public NacionalidadController() {
        // Inform the Abstract parent controller of the concrete Nacionalidad Entity
        super(Nacionalidad.class);
    }

}
