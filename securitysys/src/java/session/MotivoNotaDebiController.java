package session;

import entities.MotivoNotaDebi;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "motivoNotaDebiController")
@ViewScoped
public class MotivoNotaDebiController extends AbstractController<MotivoNotaDebi> {

    public MotivoNotaDebiController() {
        // Inform the Abstract parent controller of the concrete MotivoNotaDebi Entity
        super(MotivoNotaDebi.class);
    }

    /**
     * Sets the "items" attribute with a collection of NotaCrediDebiVenta
     * entities that are retrieved from MotivoNotaDebi?cap_first and returns the
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

    /**
     * Sets the "items" attribute with a collection of NotaRemisionVenta
     * entities that are retrieved from MotivoNotaDebi?cap_first and returns the
     * navigation outcome.
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
