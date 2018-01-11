package session;

import entities.Equipo;
import bean.EquipoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "equipoController")
@ViewScoped
public class EquipoController extends AbstractController<Equipo> {

    @EJB
    private EquipoFacade ejbFacade;

    /**
     * Initialize the concrete Equipo controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public EquipoController() {
        // Inform the Abstract parent controller of the concrete Equipo Entity
        super(Equipo.class);
    }

}
