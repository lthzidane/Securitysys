package session;

import entities.Recaudacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "recaudacionController")
@ViewScoped
public class RecaudacionController extends AbstractController<Recaudacion> {

    @Inject
    private ArqueoController arqueoController;
    @Inject
    private FormaCobroController formaCobroController;

    public RecaudacionController() {
        // Inform the Abstract parent controller of the concrete Recaudacion Entity
        super(Recaudacion.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getRecaudacionPK().setIdFormaCobro(this.getSelected().getFormaCobro().getIdFormaCobro());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setRecaudacionPK(new entities.RecaudacionPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        arqueoController.setSelected(null);
        formaCobroController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Arqueo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArqueo(ActionEvent event) {
        if (this.getSelected() != null && arqueoController.getSelected() == null) {
            arqueoController.setSelected(this.getSelected().getArqueo());
        }
    }

    /**
     * Sets the "selected" attribute of the FormaCobro controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFormaCobro(ActionEvent event) {
        if (this.getSelected() != null && formaCobroController.getSelected() == null) {
            formaCobroController.setSelected(this.getSelected().getFormaCobro());
        }
    }
}
