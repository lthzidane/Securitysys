package session;

import entities.Cliente;
import entities.CuentaCliente;
import entities.Contrato;
import entities.Presupuesto;
import entities.OrdenTrabajo;
import entities.Reclamo;
import entities.Venta;
import entities.SegmentoContrato;
import entities.Solicitud;
import entities.LibroVenta;
import java.util.List;
import bean.ClienteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "clienteController")
@ViewScoped
public class ClienteController extends AbstractController<Cliente> {

    public ClienteController() {
        // Inform the Abstract parent controller of the concrete Cliente Entity
        super(Cliente.class);
    }

}
