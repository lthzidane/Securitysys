package session;

import entities.PromocionDet;
import bean.PromocionDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "promocionDetController")
@ViewScoped
public class PromocionDetController extends AbstractController<PromocionDet> {

    public PromocionDetController() {
        // Inform the Abstract parent controller of the concrete PromocionDet Entity
        super(PromocionDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPromocionDetPK().setIdPromocionCab(this.getSelected().getPromocion().getPromocionPK().getIdPromocion());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPromocionDetPK(new entities.PromocionDetPK());
    }

}
