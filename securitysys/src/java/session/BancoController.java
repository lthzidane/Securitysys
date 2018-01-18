package session;

import entities.Banco;
import entities.CobroCheque;
import java.util.List;
import bean.BancoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "bancoController")
@ViewScoped
public class BancoController extends AbstractController<Banco> {

    public BancoController() {
        // Inform the Abstract parent controller of the concrete Banco Entity
        super(Banco.class);
    }

}
