package session;

import entities.MarcaTarjeta;
import bean.MarcaTarjetaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "marcaTarjetaController")
@ViewScoped
public class MarcaTarjetaController extends AbstractController<MarcaTarjeta> {

    @EJB
    private MarcaTarjetaFacade ejbFacade;

    /**
     * Initialize the concrete MarcaTarjeta controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public MarcaTarjetaController() {
        // Inform the Abstract parent controller of the concrete MarcaTarjeta Entity
        super(MarcaTarjeta.class);
    }

}
