package session;

import entities.InstalacionCab;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "instalacionCabController")
@ViewScoped
public class InstalacionCabController extends AbstractController<InstalacionCab> {

    @Inject
    private OrdenTrabajoController idOtController;

    public InstalacionCabController() {
        // Inform the Abstract parent controller of the concrete InstalacionCab Entity
        super(InstalacionCab.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idOtController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the OrdenTrabajo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdOt(ActionEvent event) {
        if (this.getSelected() != null && idOtController.getSelected() == null) {
            idOtController.setSelected(this.getSelected().getIdOt());
        }
    }

    /**
     * Sets the "items" attribute with a collection of InstalacionDet entities
     * that are retrieved from InstalacionCab?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for InstalacionDet page
     */
    public String navigateInstalacionDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InstalacionDet_items", this.getSelected().getInstalacionDetList());
        }
        return "/instalacionDet/index";
    }

}
