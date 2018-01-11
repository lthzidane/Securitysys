package session;

import bean.MarcaFacade;
import entities.Marca;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "marcaController")
@ViewScoped
public class MarcaController extends AbstractController<Marca> {

    @EJB
    private MarcaFacade ejbFacade;

    /**
     * Initialize the concrete Marca controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public MarcaController() {
        // Inform the Abstract parent controller of the concrete Marca Entity
        super(Marca.class);
    }

}
