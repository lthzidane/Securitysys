package session;

import entities.Timbrado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "timbradoController")
@ViewScoped
public class TimbradoController extends AbstractController<Timbrado> {

    @Inject
    private TipoComprobanteController idTipoComprobanteController;

    public TimbradoController() {
        // Inform the Abstract parent controller of the concrete Timbrado Entity
        super(Timbrado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoComprobanteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoComprobante controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoComprobante(ActionEvent event) {
        if (this.getSelected() != null && idTipoComprobanteController.getSelected() == null) {
            idTipoComprobanteController.setSelected(this.getSelected().getIdTipoComprobante());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Venta entities that are
     * retrieved from Timbrado?cap_first and returns the navigation outcome.
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
     * entities that are retrieved from Timbrado?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaCrediDebiVenta page
     */
    public String navigateNotaCrediDebiVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaCrediDebiVenta_items", this.getSelected().getNotaCrediDebiVentaList());
        }
        return "/notaCrediDebiVenta/index";
    }

}
