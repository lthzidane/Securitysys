package session;

import entities.Presupuesto;
import entities.PresupuestoDet;
import entities.OrdenTrabajo;
import entities.Venta;
import java.util.List;
import bean.PresupuestoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "presupuestoController")
@ViewScoped
public class PresupuestoController extends AbstractController<Presupuesto> {

    public PresupuestoController() {
        // Inform the Abstract parent controller of the concrete Presupuesto Entity
        super(Presupuesto.class);
    }

}
