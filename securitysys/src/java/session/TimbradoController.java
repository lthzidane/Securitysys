package session;

import bean.TimbradoFacade;
import entities.Timbrado;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "timbradoController")
@ViewScoped
public class TimbradoController extends AbstractController<Timbrado> {

    @EJB
    private TimbradoFacade ejbFacade;

    /**
     * Initialize the concrete Timbrado controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TimbradoController() {
        // Inform the Abstract parent controller of the concrete Timbrado Entity
        super(Timbrado.class);
    }

}
