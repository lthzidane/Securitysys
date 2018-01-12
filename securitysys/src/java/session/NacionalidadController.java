package session;

import entities.Nacionalidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "nacionalidadController")
@ViewScoped
public class NacionalidadController extends AbstractController<Nacionalidad> {

    public NacionalidadController() {
        // Inform the Abstract parent controller of the concrete Nacionalidad Entity
        super(Nacionalidad.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Nacionalidad?cap_first and returns the navigation outcome.
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
