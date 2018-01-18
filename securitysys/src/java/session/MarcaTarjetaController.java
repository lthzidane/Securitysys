package session;

import entities.MarcaTarjeta;
import entities.Tarjeta;
import java.util.List;
import bean.MarcaTarjetaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "marcaTarjetaController")
@ViewScoped
public class MarcaTarjetaController extends AbstractController<MarcaTarjeta> {

    public MarcaTarjetaController() {
        // Inform the Abstract parent controller of the concrete MarcaTarjeta Entity
        super(MarcaTarjeta.class);
    }

}
