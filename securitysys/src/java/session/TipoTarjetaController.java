package session;

import entities.TipoTarjeta;
import bean.TipoTarjetaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean(name = "tipoTarjetaController")
@ViewScoped
public class TipoTarjetaController extends AbstractController<TipoTarjeta> {

    @EJB
    private TipoTarjetaFacade ejbFacade;

    /**
     * Initialize the concrete TipoTarjeta controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TipoTarjetaController() {
        // Inform the Abstract parent controller of the concrete TipoTarjeta Entity
        super(TipoTarjeta.class);
    }

}
