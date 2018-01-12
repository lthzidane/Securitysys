package session;

import entities.MarcaTarjeta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcaTarjetaController")
@ViewScoped
public class MarcaTarjetaController extends AbstractController<MarcaTarjeta> {

    public MarcaTarjetaController() {
        // Inform the Abstract parent controller of the concrete MarcaTarjeta Entity
        super(MarcaTarjeta.class);
    }

    /**
     * Sets the "items" attribute with a collection of Tarjeta entities that are
     * retrieved from MarcaTarjeta?cap_first and returns the navigation outcome.
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
