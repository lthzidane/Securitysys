package session;

import entities.Moneda;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "monedaController")
@ViewScoped
public class MonedaController extends AbstractController<Moneda> {

    public MonedaController() {
        // Inform the Abstract parent controller of the concrete Moneda Entity
        super(Moneda.class);
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from Moneda?cap_first and returns the navigation outcome.
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
