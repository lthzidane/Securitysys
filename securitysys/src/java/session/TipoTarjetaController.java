package session;

import entities.TipoTarjeta;
import entities.Tarjeta;
import java.util.List;
import bean.TipoTarjetaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoTarjetaController")
@ViewScoped
public class TipoTarjetaController extends AbstractController<TipoTarjeta> {

    public TipoTarjetaController() {
        // Inform the Abstract parent controller of the concrete TipoTarjeta Entity
        super(TipoTarjeta.class);
    }

}
