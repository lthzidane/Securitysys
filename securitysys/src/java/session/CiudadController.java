package session;

import session.util.MobilePageController;
import entities.Ciudad;
import bean.CiudadFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
@ManagedBean(name = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    @EJB
    private CiudadFacade ejbFacade;

    /**
     * Initialize the concrete Ciudad controller bean.
     * The AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad Entity
        super(Ciudad.class);
    }



}
