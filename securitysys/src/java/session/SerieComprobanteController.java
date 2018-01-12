package session;

import entities.SerieComprobante;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "serieComprobanteController")
@ViewScoped
public class SerieComprobanteController extends AbstractController<SerieComprobante> {

    @Inject
    private SucursalController idSucursalController;

    public SerieComprobanteController() {
        // Inform the Abstract parent controller of the concrete SerieComprobante Entity
        super(SerieComprobante.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idSucursalController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Venta entities that are
     * retrieved from SerieComprobante?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Venta page
     */
    public String navigateVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Venta_items", this.getSelected().getVentaList());
        }
        return "/venta/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotaCrediDebiVenta
     * entities that are retrieved from SerieComprobante?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for NotaCrediDebiVenta page
     */
    public String navigateNotaCrediDebiVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaCrediDebiVenta_items", this.getSelected().getNotaCrediDebiVentaList());
        }
        return "/notaCrediDebiVenta/index";
    }

    /**
     * Sets the "selected" attribute of the Sucursal controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSucursal(ActionEvent event) {
        if (this.getSelected() != null && idSucursalController.getSelected() == null) {
            idSucursalController.setSelected(this.getSelected().getIdSucursal());
        }
    }
}
