package session;

import entities.TipoDocumento;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "tipoDocumentoController")
@ViewScoped
public class TipoDocumentoController extends AbstractController<TipoDocumento> {

    public TipoDocumentoController() {
        // Inform the Abstract parent controller of the concrete TipoDocumento Entity
        super(TipoDocumento.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from TipoDocumento?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", this.getSelected().getClienteList());
        }
        return "/cliente/index";
    }

}
