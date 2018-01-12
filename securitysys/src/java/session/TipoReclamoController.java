package session;

import entities.TipoReclamo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoReclamoController")
@ViewScoped
public class TipoReclamoController extends AbstractController<TipoReclamo> {

    public TipoReclamoController() {
        // Inform the Abstract parent controller of the concrete TipoReclamo Entity
        super(TipoReclamo.class);
    }

    /**
     * Sets the "items" attribute with a collection of Reclamo entities that are
     * retrieved from TipoReclamo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Reclamo page
     */
    public String navigateReclamoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Reclamo_items", this.getSelected().getReclamoList());
        }
        return "/reclamo/index";
    }

}
