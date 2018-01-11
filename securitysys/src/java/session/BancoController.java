package session;

import entities.Banco;
import bean.BancoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "bancoController")
@ViewScoped
public class BancoController extends AbstractController<Banco> {

    @EJB
    private BancoFacade ejbFacade;

    /**
     * Initialize the concrete Banco controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BancoController() {
        // Inform the Abstract parent controller of the concrete Banco Entity
        super(Banco.class);
    }

}
