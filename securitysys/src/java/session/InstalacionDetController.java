package session;

import entities.InstalacionDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "instalacionDetController")
@ViewScoped
public class InstalacionDetController extends AbstractController<InstalacionDet> {

    @Inject
    private EquipoController idEquipoController;
    @Inject
    private InstalacionCabController instalacionCabController;

    public InstalacionDetController() {
        // Inform the Abstract parent controller of the concrete InstalacionDet Entity
        super(InstalacionDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getInstalacionDetPK().setIdInstalacion(this.getSelected().getInstalacionCab().getIdInstalacion());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setInstalacionDetPK(new entities.InstalacionDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEquipoController.setSelected(null);
        instalacionCabController.setSelected(null);
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
     * Sets the "selected" attribute of the InstalacionCab controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInstalacionCab(ActionEvent event) {
        if (this.getSelected() != null && instalacionCabController.getSelected() == null) {
            instalacionCabController.setSelected(this.getSelected().getInstalacionCab());
        }
    }
}
