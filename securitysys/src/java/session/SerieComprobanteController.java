package session;

import bean.SerieComprobanteFacade;
import entities.SerieComprobante;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "serieComprobanteController")
@ViewScoped
public class SerieComprobanteController extends AbstractController<SerieComprobante> {

    @EJB
    private SerieComprobanteFacade ejbFacade;

    /**
     * Initialize the concrete SerieComprobante controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public SerieComprobanteController() {
        // Inform the Abstract parent controller of the concrete SerieComprobante Entity
        super(SerieComprobante.class);
    }

}
