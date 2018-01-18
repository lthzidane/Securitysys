package session;

import entities.Cobro;
import entities.CobroDet;
import java.util.List;
import bean.CobroFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cobroController")
@ViewScoped
public class CobroController extends AbstractController<Cobro> {

    public CobroController() {
        // Inform the Abstract parent controller of the concrete Cobro Entity
        super(Cobro.class);
    }

}
