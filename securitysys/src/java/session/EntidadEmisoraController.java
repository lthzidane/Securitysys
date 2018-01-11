package session;

import entities.EntidadEmisora;
import bean.EntidadEmisoraFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "entidadEmisoraController")
@ViewScoped
public class EntidadEmisoraController extends AbstractController<EntidadEmisora> {

    @EJB
    private EntidadEmisoraFacade ejbFacade;

    /**
     * Initialize the concrete EntidadEmisora controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public EntidadEmisoraController() {
        // Inform the Abstract parent controller of the concrete EntidadEmisora Entity
        super(EntidadEmisora.class);
    }

}
