package session;

import entities.PresupuestoDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "presupuestoDetController")
@ViewScoped
public class PresupuestoDetController extends AbstractController<PresupuestoDet> {

    @Inject
    private DescuentoController idDescuentoController;
    @Inject
    private PresupuestoController presupuestoController;
    @Inject
    private PromocionController idPromocionController;

    public PresupuestoDetController() {
        // Inform the Abstract parent controller of the concrete PresupuestoDet Entity
        super(PresupuestoDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPresupuestoDetPK().setIdPresupuestoCab(this.getSelected().getPresupuesto().getIdPresupuesto());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPresupuestoDetPK(new entities.PresupuestoDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDescuentoController.setSelected(null);
        presupuestoController.setSelected(null);
        idPromocionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Descuento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDescuento(ActionEvent event) {
        if (this.getSelected() != null && idDescuentoController.getSelected() == null) {
            idDescuentoController.setSelected(this.getSelected().getIdDescuento());
        }
    }

    /**
     * Sets the "selected" attribute of the Presupuesto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePresupuesto(ActionEvent event) {
        if (this.getSelected() != null && presupuestoController.getSelected() == null) {
            presupuestoController.setSelected(this.getSelected().getPresupuesto());
        }
    }

    /**
     * Sets the "selected" attribute of the Promocion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPromocion(ActionEvent event) {
        if (this.getSelected() != null && idPromocionController.getSelected() == null) {
            idPromocionController.setSelected(this.getSelected().getIdPromocion());
        }
    }
}
