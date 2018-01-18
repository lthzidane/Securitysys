package session;

import entities.CobroTarjeta;
import bean.CobroTarjetaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "cobroTarjetaController")
@ViewScoped
public class CobroTarjetaController extends AbstractController<CobroTarjeta> {

    public CobroTarjetaController() {
        // Inform the Abstract parent controller of the concrete CobroTarjeta Entity
        super(CobroTarjeta.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCobroTarjetaPK().setIdCobro(this.getSelected().getCobroDet().getCobroDetPK().getIdCobro());
        this.getSelected().getCobroTarjetaPK().setIdCtaACobrar(this.getSelected().getCobroDet().getCobroDetPK().getIdCtaACobrar());
        this.getSelected().getCobroTarjetaPK().setIdVenta(this.getSelected().getCobroDet().getCobroDetPK().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCobroTarjetaPK(new entities.CobroTarjetaPK());
    }

}
