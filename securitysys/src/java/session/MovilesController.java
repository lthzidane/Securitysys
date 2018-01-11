package session;

import bean.MovilesFacade;
import entities.Moviles;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "movilesController")
@ViewScoped
public class MovilesController extends AbstractController<Moviles> {

    @EJB
    private MovilesFacade ejbFacade;

    /**
     * Initialize the concrete Moviles controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public MovilesController() {
        // Inform the Abstract parent controller of the concrete Moviles Entity
        super(Moviles.class);
    }

}
