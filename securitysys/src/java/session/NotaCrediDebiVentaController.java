package session;

import entities.NotaCrediDebiVenta;
import entities.NotaCrediDebiVentaDet;
import java.util.List;
import bean.NotaCrediDebiVentaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "notaCrediDebiVentaController")
@ViewScoped
public class NotaCrediDebiVentaController extends AbstractController<NotaCrediDebiVenta> {

    public NotaCrediDebiVentaController() {
        // Inform the Abstract parent controller of the concrete NotaCrediDebiVenta Entity
        super(NotaCrediDebiVenta.class);
    }

}
