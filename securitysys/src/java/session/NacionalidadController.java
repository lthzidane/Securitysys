package session;

import bean.NacionalidadFacade;
import entities.Nacionalidad;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "nacionalidadController")
@ViewScoped
public class NacionalidadController extends AbstractController<Nacionalidad> {

    @EJB
    private NacionalidadFacade ejbFacade;

    /**
     * Initialize the concrete Nacionalidad controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public NacionalidadController() {
        // Inform the Abstract parent controller of the concrete Nacionalidad Entity
        super(Nacionalidad.class);
    }

}
