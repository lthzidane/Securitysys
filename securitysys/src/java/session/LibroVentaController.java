package session;

import entities.LibroVenta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "libroVentaController")
@ViewScoped
public class LibroVentaController extends AbstractController<LibroVenta> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private VentaController ventaController;

    public LibroVentaController() {
        // Inform the Abstract parent controller of the concrete LibroVenta Entity
        super(LibroVenta.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getLibroVentaPK().setIdVenta(this.getSelected().getVenta().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setLibroVentaPK(new entities.LibroVentaPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        ventaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        if (this.getSelected() != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(this.getSelected().getIdCliente());
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
