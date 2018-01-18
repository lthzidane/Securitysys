package session;

import entities.Moneda;
import entities.Servicio;
import java.util.List;
import bean.MonedaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "monedaController")
@ViewScoped
public class MonedaController extends AbstractController<Moneda> {

    public MonedaController() {
        // Inform the Abstract parent controller of the concrete Moneda Entity
        super(Moneda.class);
    }

}
