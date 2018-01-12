package session;

import entities.PromocionDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "promocionDetController")
@ViewScoped
public class PromocionDetController extends AbstractController<PromocionDet> {

    @Inject
    private EquipoController idEquipoController;
    @Inject
    private PromocionController promocionController;
    @Inject
    private ServicioController idServicioController;

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

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEquipoController.setSelected(null);
        promocionController.setSelected(null);
        idServicioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Equipo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEquipo(ActionEvent event) {
        if (this.getSelected() != null && idEquipoController.getSelected() == null) {
            idEquipoController.setSelected(this.getSelected().getIdEquipo());
        }
    }

    /**
     * Sets the "selected" attribute of the Promocion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePromocion(ActionEvent event) {
        if (this.getSelected() != null && promocionController.getSelected() == null) {
            promocionController.setSelected(this.getSelected().getPromocion());
        }
    }

    /**
     * Sets the "selected" attribute of the Servicio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServicio(ActionEvent event) {
        if (this.getSelected() != null && idServicioController.getSelected() == null) {
            idServicioController.setSelected(this.getSelected().getIdServicio());
        }
    }
}
