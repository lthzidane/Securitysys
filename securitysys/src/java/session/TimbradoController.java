package session;

import entities.Timbrado;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import java.util.List;
import bean.TimbradoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "timbradoController")
@ViewScoped
public class TimbradoController extends AbstractController<Timbrado> {

    public TimbradoController() {
        // Inform the Abstract parent controller of the concrete Timbrado Entity
        super(Timbrado.class);
    }

}
