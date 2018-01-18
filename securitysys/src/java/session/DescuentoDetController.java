package session;

import entities.DescuentoDet;
import bean.DescuentoDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "descuentoDetController")
@ViewScoped
public class DescuentoDetController extends AbstractController<DescuentoDet> {

    public DescuentoDetController() {
        // Inform the Abstract parent controller of the concrete DescuentoDet Entity
        super(DescuentoDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDescuentoDetPK().setIdDescuentoCab(this.getSelected().getDescuento().getIdDescuento());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDescuentoDetPK(new entities.DescuentoDetPK());
    }

}
