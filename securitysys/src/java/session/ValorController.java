package session;

import entities.Valor;
import entities.Arqueo;
import java.util.List;
import bean.ValorFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "valorController")
@ViewScoped
public class ValorController extends AbstractController<Valor> {

    public ValorController() {
        // Inform the Abstract parent controller of the concrete Valor Entity
        super(Valor.class);
    }

}
