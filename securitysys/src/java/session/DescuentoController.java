package session;

import entities.Descuento;
import entities.SolicitudDet;
import entities.DescuentoDet;
import entities.PresupuestoDet;
import entities.Servicio;
import entities.VentaDet;
import java.util.List;
import bean.DescuentoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "descuentoController")
@ViewScoped
public class DescuentoController extends AbstractController<Descuento> {

    public DescuentoController() {
        // Inform the Abstract parent controller of the concrete Descuento Entity
        super(Descuento.class);
    }

}
