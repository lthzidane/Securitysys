package session;

import entities.Tarjeta;
import entities.CobroTarjeta;
import java.util.List;
import bean.TarjetaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tarjetaController")
@ViewScoped
public class TarjetaController extends AbstractController<Tarjeta> {

    public TarjetaController() {
        // Inform the Abstract parent controller of the concrete Tarjeta Entity
        super(Tarjeta.class);
    }

}
