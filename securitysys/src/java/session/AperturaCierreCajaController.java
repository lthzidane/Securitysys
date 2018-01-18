package session;

import entities.AperturaCierreCaja;
import entities.Cobro;
import entities.Venta;
import entities.Arqueo;
import java.util.List;
import bean.AperturaCierreCajaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "aperturaCierreCajaController")
@ViewScoped
public class AperturaCierreCajaController extends AbstractController<AperturaCierreCaja> {

    public AperturaCierreCajaController() {
        // Inform the Abstract parent controller of the concrete AperturaCierreCaja Entity
        super(AperturaCierreCaja.class);
    }

}
