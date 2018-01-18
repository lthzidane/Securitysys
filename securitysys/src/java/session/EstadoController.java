package session;

import entities.Estado;
import entities.CuentaCliente;
import entities.Contrato;
import entities.Presupuesto;
import entities.Reclamo;
import entities.Servicio;
import java.util.List;
import bean.EstadoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "estadoController")
@ViewScoped
public class EstadoController extends AbstractController<Estado> {

    public EstadoController() {
        // Inform the Abstract parent controller of the concrete Estado Entity
        super(Estado.class);
    }

}
