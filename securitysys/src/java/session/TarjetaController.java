package session;

import entities.Tarjeta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tarjetaController")
@ViewScoped
public class TarjetaController extends AbstractController<Tarjeta> {

    @Inject
    private EntidadEmisoraController idEntidadEmisoraController;
    @Inject
    private MarcaTarjetaController idMarcaTarjetaController;
    @Inject
    private TipoTarjetaController idTipoTarjetaController;

    public TarjetaController() {
        // Inform the Abstract parent controller of the concrete Tarjeta Entity
        super(Tarjeta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEntidadEmisoraController.setSelected(null);
        idMarcaTarjetaController.setSelected(null);
        idTipoTarjetaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the EntidadEmisora controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEntidadEmisora(ActionEvent event) {
        if (this.getSelected() != null && idEntidadEmisoraController.getSelected() == null) {
            idEntidadEmisoraController.setSelected(this.getSelected().getIdEntidadEmisora());
        }
    }

    /**
     * Sets the "selected" attribute of the MarcaTarjeta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMarcaTarjeta(ActionEvent event) {
        if (this.getSelected() != null && idMarcaTarjetaController.getSelected() == null) {
            idMarcaTarjetaController.setSelected(this.getSelected().getIdMarcaTarjeta());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoTarjeta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoTarjeta(ActionEvent event) {
        if (this.getSelected() != null && idTipoTarjetaController.getSelected() == null) {
            idTipoTarjetaController.setSelected(this.getSelected().getIdTipoTarjeta());
        }
    }

    /**
     * Sets the "items" attribute with a collection of CobroTarjeta entities
     * that are retrieved from Tarjeta?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CobroTarjeta page
     */
    public String navigateCobroTarjetaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CobroTarjeta_items", this.getSelected().getCobroTarjetaList());
        }
        return "/cobroTarjeta/index";
    }

}
