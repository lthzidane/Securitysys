package session;

import entities.Cobro;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cobroController")
@ViewScoped
public class CobroController extends AbstractController<Cobro> {

    @Inject
    private AperturaCierreCajaController idAperturaCierreController;
    @Inject
    private FormaCobroController idFormaCobroController;

    public CobroController() {
        // Inform the Abstract parent controller of the concrete Cobro Entity
        super(Cobro.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAperturaCierreController.setSelected(null);
        idFormaCobroController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CobroDet entities that
     * are retrieved from Cobro?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CobroDet page
     */
    public String navigateCobroDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CobroDet_items", this.getSelected().getCobroDetList());
        }
        return "/cobroDet/index";
    }

    /**
     * Sets the "selected" attribute of the AperturaCierreCaja controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAperturaCierre(ActionEvent event) {
        if (this.getSelected() != null && idAperturaCierreController.getSelected() == null) {
            idAperturaCierreController.setSelected(this.getSelected().getIdAperturaCierre());
        }
    }

    /**
     * Sets the "selected" attribute of the FormaCobro controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFormaCobro(ActionEvent event) {
        if (this.getSelected() != null && idFormaCobroController.getSelected() == null) {
            idFormaCobroController.setSelected(this.getSelected().getIdFormaCobro());
        }
    }

}
