package session;

import entities.EntidadEmisora;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "entidadEmisoraController")
@ViewScoped
public class EntidadEmisoraController extends AbstractController<EntidadEmisora> {

    public EntidadEmisoraController() {
        // Inform the Abstract parent controller of the concrete EntidadEmisora Entity
        super(EntidadEmisora.class);
    }

    /**
     * Sets the "items" attribute with a collection of Tarjeta entities that are
     * retrieved from EntidadEmisora?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Tarjeta page
     */
    public String navigateTarjetaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tarjeta_items", this.getSelected().getTarjetaList());
        }
        return "/tarjeta/index";
    }

}
