package session;

import entities.FormaCobro;
import entities.Cobro;
import entities.Recaudacion;
import java.util.List;
import bean.FormaCobroFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "formaCobroController")
@ViewScoped
public class FormaCobroController extends AbstractController<FormaCobro> {

    public FormaCobroController() {
        // Inform the Abstract parent controller of the concrete FormaCobro Entity
        super(FormaCobro.class);
    }

}
