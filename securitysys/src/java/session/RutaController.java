package session;

import entities.Ruta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rutaController")
@ViewScoped
public class RutaController extends AbstractController<Ruta> {

    @Inject
    private ZonaController idZonaController;

    public RutaController() {
        // Inform the Abstract parent controller of the concrete Ruta Entity
        super(Ruta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idZonaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Zona controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdZona(ActionEvent event) {
        if (this.getSelected() != null && idZonaController.getSelected() == null) {
            idZonaController.setSelected(this.getSelected().getIdZona());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Itinerario entities that
     * are retrieved from Ruta?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Itinerario page
     */
    public String navigateItinerarioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Itinerario_items", this.getSelected().getItinerarioList());
        }
        return "/itinerario/index";
    }

}
