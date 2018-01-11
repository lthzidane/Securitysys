package session;

import bean.TipoMovilFacade;
import entities.TipoMovil;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tipoMovilController")
@ViewScoped
public class TipoMovilController extends AbstractController<TipoMovil> {

    @EJB
    private TipoMovilFacade ejbFacade;

    /**
     * Initialize the concrete TipoMovil controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TipoMovilController() {
        // Inform the Abstract parent controller of the concrete TipoMovil Entity
        super(TipoMovil.class);
    }

}
