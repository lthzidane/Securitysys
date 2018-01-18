package session;

import entities.OrdenTrabajoDet;
import bean.OrdenTrabajoDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ordenTrabajoDetController")
@ViewScoped
public class OrdenTrabajoDetController extends AbstractController<OrdenTrabajoDet> {

    public OrdenTrabajoDetController() {
        // Inform the Abstract parent controller of the concrete OrdenTrabajoDet Entity
        super(OrdenTrabajoDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getOrdenTrabajoDetPK().setIdOrdenTrabajo(this.getSelected().getOrdenTrabajo().getIdOt());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setOrdenTrabajoDetPK(new entities.OrdenTrabajoDetPK());
    }

}
