package session;

import entities.NotaRemisionVenta;
import entities.NotaRemisionVentaDet;
import java.util.List;
import bean.NotaRemisionVentaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "notaRemisionVentaController")
@ViewScoped
public class NotaRemisionVentaController extends AbstractController<NotaRemisionVenta> {

    public NotaRemisionVentaController() {
        // Inform the Abstract parent controller of the concrete NotaRemisionVenta Entity
        super(NotaRemisionVenta.class);
    }

}
