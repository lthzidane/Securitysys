package session;

import bean.MonedaFacade;
import entities.Moneda;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "monedaController")
@ViewScoped
public class MonedaController extends AbstractController<Moneda> {

    @EJB
    private MonedaFacade ejbFacade;

    /**
     * Initialize the concrete Moneda controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public MonedaController() {
        // Inform the Abstract parent controller of the concrete Moneda Entity
        super(Moneda.class);
    }

}
