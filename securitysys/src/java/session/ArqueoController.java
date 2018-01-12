package session;

import entities.Arqueo;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "arqueoController")
@ViewScoped
public class ArqueoController extends AbstractController<Arqueo> {

    @Inject
    private AperturaCierreCajaController aperturaCierreCajaController;
    @Inject
    private ValorController valorController;

    public ArqueoController() {
        // Inform the Abstract parent controller of the concrete Arqueo Entity
        super(Arqueo.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getArqueoPK().setIdValor(this.getSelected().getValor().getIdValor());
        this.getSelected().getArqueoPK().setIdAperturaCierre(this.getSelected().getAperturaCierreCaja().getIdAperturaCierre());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setArqueoPK(new entities.ArqueoPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        aperturaCierreCajaController.setSelected(null);
        valorController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Recaudacion entities that
     * are retrieved from Arqueo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Recaudacion page
     */
    public String navigateRecaudacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Recaudacion_items", this.getSelected().getRecaudacionList());
        }
        return "/recaudacion/index";
    }

    /**
     * Sets the "selected" attribute of the AperturaCierreCaja controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAperturaCierreCaja(ActionEvent event) {
        if (this.getSelected() != null && aperturaCierreCajaController.getSelected() == null) {
            aperturaCierreCajaController.setSelected(this.getSelected().getAperturaCierreCaja());
        }
    }

    /**
     * Sets the "selected" attribute of the Valor controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareValor(ActionEvent event) {
        if (this.getSelected() != null && valorController.getSelected() == null) {
            valorController.setSelected(this.getSelected().getValor());
        }
    }

}
