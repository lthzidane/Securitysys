package session;

import entities.TipoComprobante;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoComprobanteController")
@ViewScoped
public class TipoComprobanteController extends AbstractController<TipoComprobante> {

    public TipoComprobanteController() {
        // Inform the Abstract parent controller of the concrete TipoComprobante Entity
        super(TipoComprobante.class);
    }

    /**
     * Sets the "items" attribute with a collection of Timbrado entities that
     * are retrieved from TipoComprobante?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Timbrado page
     */
    public String navigateTimbradoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Timbrado_items", this.getSelected().getTimbradoList());
        }
        return "/timbrado/index";
    }

    /**
     * Sets the "items" attribute with a collection of Venta entities that are
     * retrieved from TipoComprobante?cap_first and returns the navigation
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
     * entities that are retrieved from TipoComprobante?cap_first and returns
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
     * Sets the "items" attribute with a collection of NotaRemisionVenta
     * entities that are retrieved from TipoComprobante?cap_first and returns
     * the navigation outcome.
     *
     * @return navigation outcome for NotaRemisionVenta page
     */
    public String navigateNotaRemisionVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaRemisionVenta_items", this.getSelected().getNotaRemisionVentaList());
        }
        return "/notaRemisionVenta/index";
    }

}
