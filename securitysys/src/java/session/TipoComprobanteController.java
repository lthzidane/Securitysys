package session;

import bean.TipoComprobanteFacade;
import entities.TipoComprobante;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tipoComprobanteController")
@ViewScoped
public class TipoComprobanteController extends AbstractController<TipoComprobante> {

    @EJB
    private TipoComprobanteFacade ejbFacade;

    /**
     * Initialize the concrete TipoComprobante controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TipoComprobanteController() {
        // Inform the Abstract parent controller of the concrete TipoComprobante Entity
        super(TipoComprobante.class);
    }

}
