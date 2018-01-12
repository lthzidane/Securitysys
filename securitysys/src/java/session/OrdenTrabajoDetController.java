package session;

import entities.OrdenTrabajoDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ordenTrabajoDetController")
@ViewScoped
public class OrdenTrabajoDetController extends AbstractController<OrdenTrabajoDet> {

    @Inject
    private OrdenTrabajoController ordenTrabajoController;

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

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ordenTrabajoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the OrdenTrabajo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOrdenTrabajo(ActionEvent event) {
        if (this.getSelected() != null && ordenTrabajoController.getSelected() == null) {
            ordenTrabajoController.setSelected(this.getSelected().getOrdenTrabajo());
        }
    }
}
