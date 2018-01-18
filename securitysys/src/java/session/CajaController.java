package session;

import entities.Caja;
import entities.AperturaCierreCaja;
import java.util.List;
import bean.CajaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cajaController")
@ViewScoped
public class CajaController extends AbstractController<Caja> {

    public CajaController() {
        // Inform the Abstract parent controller of the concrete Caja Entity
        super(Caja.class);
    }

}
