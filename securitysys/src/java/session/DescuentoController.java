package session;

import entities.Descuento;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "descuentoController")
@ViewScoped
public class DescuentoController extends AbstractController<Descuento> {

    public DescuentoController() {
        // Inform the Abstract parent controller of the concrete Descuento Entity
        super(Descuento.class);
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from Descuento?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Servicio page
     */
    public String navigateServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicio_items", this.getSelected().getServicioList());
        }
        return "/servicio/index";
    }

}
