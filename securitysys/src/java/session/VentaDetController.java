package session;

import entities.VentaDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ventaDetController")
@ViewScoped
public class VentaDetController extends AbstractController<VentaDet> {

    @Inject
    private DescuentoController idDescuentoController;
    @Inject
    private EquipoController idEquipoController;
    @Inject
    private PromocionController idPromocionController;
    @Inject
    private VentaController ventaController;

    public VentaDetController() {
        // Inform the Abstract parent controller of the concrete VentaDet Entity
        super(VentaDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getVentaDetPK().setIdVenta(this.getSelected().getVenta().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setVentaDetPK(new entities.VentaDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDescuentoController.setSelected(null);
        idEquipoController.setSelected(null);
        idPromocionController.setSelected(null);
        ventaController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Venta controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareVenta(ActionEvent event) {
        if (this.getSelected() != null && ventaController.getSelected() == null) {
            ventaController.setSelected(this.getSelected().getVenta());
        }
    }
}
