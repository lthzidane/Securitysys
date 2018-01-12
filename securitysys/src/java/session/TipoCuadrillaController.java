package session;

import entities.TipoCuadrilla;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoCuadrillaController")
@ViewScoped
public class TipoCuadrillaController extends AbstractController<TipoCuadrilla> {

    public TipoCuadrillaController() {
        // Inform the Abstract parent controller of the concrete TipoCuadrilla Entity
        super(TipoCuadrilla.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cuadrilla entities that
     * are retrieved from TipoCuadrilla?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Cuadrilla page
     */
    public String navigateCuadrillaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cuadrilla_items", this.getSelected().getCuadrillaList());
        }
        return "/cuadrilla/index";
    }

}
