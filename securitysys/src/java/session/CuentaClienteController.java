package session;

import entities.CuentaCliente;
import bean.CuentaClienteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cuentaClienteController")
@ViewScoped
public class CuentaClienteController extends AbstractController<CuentaCliente> {

    public CuentaClienteController() {
        // Inform the Abstract parent controller of the concrete CuentaCliente Entity
        super(CuentaCliente.class);
    }

}
