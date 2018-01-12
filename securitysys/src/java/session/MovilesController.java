package session;

import entities.Moviles;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "movilesController")
@ViewScoped
public class MovilesController extends AbstractController<Moviles> {

    @Inject
    private MarcaController idMarcaController;
    @Inject
    private TipoMovilController idTipoMovilController;

    public MovilesController() {
        // Inform the Abstract parent controller of the concrete Moviles Entity
        super(Moviles.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMarcaController.setSelected(null);
        idTipoMovilController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Marca controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMarca(ActionEvent event) {
        if (this.getSelected() != null && idMarcaController.getSelected() == null) {
            idMarcaController.setSelected(this.getSelected().getIdMarca());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoMovil controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoMovil(ActionEvent event) {
        if (this.getSelected() != null && idTipoMovilController.getSelected() == null) {
            idTipoMovilController.setSelected(this.getSelected().getIdTipoMovil());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Cuadrilla entities that
     * are retrieved from Moviles?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cuadrilla page
     */
    public String navigateCuadrillaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cuadrilla_items", this.getSelected().getCuadrillaList());
        }
        return "/cuadrilla/index";
    }

    /**
     * Sets the "items" attribute with a collection of Itinerario entities that
     * are retrieved from Moviles?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Itinerario page
     */
    public String navigateItinerarioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Itinerario_items", this.getSelected().getItinerarioList());
        }
        return "/itinerario/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotaRemisionVenta
     * entities that are retrieved from Moviles?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaRemisionVenta page
     */
    public String navigateNotaRemisionVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaRemisionVenta_items", this.getSelected().getNotaRemisionVentaList());
        }
        return "/notaRemisionVenta/index";
    }

}
