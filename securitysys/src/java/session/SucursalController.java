package session;

import bean.SucursalFacade;
import entities.Sucursal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "sucursalController")
@ViewScoped
public class SucursalController extends AbstractController<Sucursal> {

    @EJB
    private SucursalFacade ejbFacade;

    /**
     * Initialize the concrete Sucursal controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public SucursalController() {
        // Inform the Abstract parent controller of the concrete Sucursal Entity
        super(Sucursal.class);
    }

}
