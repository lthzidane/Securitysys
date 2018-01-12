package session;

import entities.Itinerario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "itinerarioController")
@ViewScoped
public class ItinerarioController extends AbstractController<Itinerario> {

    @Inject
    private MovilesController idMovilController;
    @Inject
    private RutaController idRutaController;

    public ItinerarioController() {
        // Inform the Abstract parent controller of the concrete Itinerario Entity
        super(Itinerario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMovilController.setSelected(null);
        idRutaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of OrdenTrabajo entities
     * that are retrieved from Itinerario?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenTrabajo page
     */
    public String navigateOrdenTrabajoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenTrabajo_items", this.getSelected().getOrdenTrabajoList());
        }
        return "/ordenTrabajo/index";
    }

    /**
     * Sets the "selected" attribute of the Moviles controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMovil(ActionEvent event) {
        if (this.getSelected() != null && idMovilController.getSelected() == null) {
            idMovilController.setSelected(this.getSelected().getIdMovil());
        }
    }

    /**
     * Sets the "selected" attribute of the Ruta controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRuta(ActionEvent event) {
        if (this.getSelected() != null && idRutaController.getSelected() == null) {
            idRutaController.setSelected(this.getSelected().getIdRuta());
        }
    }
}
