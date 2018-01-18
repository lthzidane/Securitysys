package session;

import entities.Venta;
import entities.CtaACobrar;
import entities.NotaCrediDebiVenta;
import entities.VentaDet;
import entities.NotaRemisionVenta;
import entities.LibroVenta;
import java.util.List;
import bean.VentaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ventaController")
@ViewScoped
public class VentaController extends AbstractController<Venta> {

    public VentaController() {
        // Inform the Abstract parent controller of the concrete Venta Entity
        super(Venta.class);
    }

}
