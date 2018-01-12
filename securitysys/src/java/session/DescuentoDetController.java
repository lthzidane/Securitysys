package session;

import entities.DescuentoDet;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "descuentoDetController")
@ViewScoped
public class DescuentoDetController extends AbstractController<DescuentoDet> {

    @Inject
    private DescuentoController descuentoController;

    public DescuentoDetController() {
        // Inform the Abstract parent controller of the concrete DescuentoDet Entity
        super(DescuentoDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDescuentoDetPK().setIdDescuentoCab(this.getSelected().getDescuento().getIdDescuento());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDescuentoDetPK(new entities.DescuentoDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        descuentoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Descuento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDescuento(ActionEvent event) {
        if (this.getSelected() != null && descuentoController.getSelected() == null) {
            descuentoController.setSelected(this.getSelected().getDescuento());
        }
    }

}
