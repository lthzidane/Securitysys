package session;

import entities.CtaACobrar;
import entities.CobroDet;
import java.util.List;
import bean.CtaACobrarFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ctaACobrarController")
@ViewScoped
public class CtaACobrarController extends AbstractController<CtaACobrar> {

    public CtaACobrarController() {
        // Inform the Abstract parent controller of the concrete CtaACobrar Entity
        super(CtaACobrar.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCtaACobrarPK().setIdVenta(this.getSelected().getVenta().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCtaACobrarPK(new entities.CtaACobrarPK());
    }

}
