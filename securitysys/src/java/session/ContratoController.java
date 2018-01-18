package session;

import entities.Contrato;
import entities.CuentaCliente;
import java.util.List;
import bean.ContratoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "contratoController")
@ViewScoped
public class ContratoController extends AbstractController<Contrato> {

    public ContratoController() {
        // Inform the Abstract parent controller of the concrete Contrato Entity
        super(Contrato.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getContratoPK().setIdCliente(this.getSelected().getCliente().getIdCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setContratoPK(new entities.ContratoPK());
    }

}
