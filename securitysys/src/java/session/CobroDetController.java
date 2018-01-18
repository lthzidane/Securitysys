package session;

import entities.CobroDet;
import entities.CobroCheque;
import entities.CobroTarjeta;
import java.util.List;
import bean.CobroDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cobroDetController")
@ViewScoped
public class CobroDetController extends AbstractController<CobroDet> {

    public CobroDetController() {
        // Inform the Abstract parent controller of the concrete CobroDet Entity
        super(CobroDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCobroDetPK().setIdCobro(this.getSelected().getCobro().getIdCobro());
        this.getSelected().getCobroDetPK().setIdCtaACobrar(this.getSelected().getCtaACobrar().getCtaACobrarPK().getIdCtaACobrar());
        this.getSelected().getCobroDetPK().setIdVenta(this.getSelected().getCtaACobrar().getCtaACobrarPK().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCobroDetPK(new entities.CobroDetPK());
    }

}
