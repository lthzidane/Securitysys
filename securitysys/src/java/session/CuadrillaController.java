package session;

import entities.Cuadrilla;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cuadrillaController")
@ViewScoped
public class CuadrillaController extends AbstractController<Cuadrilla> {

    @Inject
    private MovilesController idMovilController;
    @Inject
    private TecnicoController idTecnicoController;
    @Inject
    private TipoCuadrillaController idTipoCuadrillaController;
    @Inject
    private ZonaController idZonaController;

    public CuadrillaController() {
        // Inform the Abstract parent controller of the concrete Cuadrilla Entity
        super(Cuadrilla.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMovilController.setSelected(null);
        idTecnicoController.setSelected(null);
        idTipoCuadrillaController.setSelected(null);
        idZonaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of OrdenTrabajo entities
     * that are retrieved from Cuadrilla?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Tecnico controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTecnico(ActionEvent event) {
        if (this.getSelected() != null && idTecnicoController.getSelected() == null) {
            idTecnicoController.setSelected(this.getSelected().getIdTecnico());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoCuadrilla controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoCuadrilla(ActionEvent event) {
        if (this.getSelected() != null && idTipoCuadrillaController.getSelected() == null) {
            idTipoCuadrillaController.setSelected(this.getSelected().getIdTipoCuadrilla());
        }
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

}
