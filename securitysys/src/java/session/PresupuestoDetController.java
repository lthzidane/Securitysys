package session;

import entities.PresupuestoDet;
import bean.PresupuestoDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "presupuestoDetController")
@ViewScoped
public class PresupuestoDetController extends AbstractController<PresupuestoDet> {

    public PresupuestoDetController() {
        // Inform the Abstract parent controller of the concrete PresupuestoDet Entity
        super(PresupuestoDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPresupuestoDetPK().setIdPresupuesto(this.getSelected().getPresupuesto().getIdPresupuesto());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPresupuestoDetPK(new entities.PresupuestoDetPK());
    }

}
