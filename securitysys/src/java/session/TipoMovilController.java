package session;

import entities.TipoMovil;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoMovilController")
@ViewScoped
public class TipoMovilController extends AbstractController<TipoMovil> {

    public TipoMovilController() {
        // Inform the Abstract parent controller of the concrete TipoMovil Entity
        super(TipoMovil.class);
    }

    /**
     * Sets the "items" attribute with a collection of Moviles entities that are
     * retrieved from TipoMovil?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Moviles page
     */
    public String navigateMovilesList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Moviles_items", this.getSelected().getMovilesList());
        }
        return "/moviles/index";
    }

}
