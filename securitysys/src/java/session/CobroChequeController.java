package session;

import entities.CobroCheque;
import bean.CobroChequeFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cobroChequeController")
@ViewScoped
public class CobroChequeController extends AbstractController<CobroCheque> {

    public CobroChequeController() {
        // Inform the Abstract parent controller of the concrete CobroCheque Entity
        super(CobroCheque.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCobroChequePK().setIdCobro(this.getSelected().getCobroDet().getCobroDetPK().getIdCobro());
        this.getSelected().getCobroChequePK().setIdCtaACobrar(this.getSelected().getCobroDet().getCobroDetPK().getIdCtaACobrar());
        this.getSelected().getCobroChequePK().setIdVenta(this.getSelected().getCobroDet().getCobroDetPK().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCobroChequePK(new entities.CobroChequePK());
    }

}
