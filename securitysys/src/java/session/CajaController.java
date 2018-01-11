package session;

import bean.CajaFacade;
import entities.Caja;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cajaController")
@ViewScoped
public class CajaController extends AbstractController<Caja> {

    @EJB
    private CajaFacade ejbFacade;

    /**
     * Initialize the concrete Caja controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CajaController() {
        // Inform the Abstract parent controller of the concrete Caja Entity
        super(Caja.class);
    }

}
