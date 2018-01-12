package session;

import entities.TipoTarjeta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoTarjetaController")
@ViewScoped
public class TipoTarjetaController extends AbstractController<TipoTarjeta> {

    public TipoTarjetaController() {
        // Inform the Abstract parent controller of the concrete TipoTarjeta Entity
        super(TipoTarjeta.class);
    }

    /**
     * Sets the "items" attribute with a collection of Tarjeta entities that are
     * retrieved from TipoTarjeta?cap_first and returns the navigation outcome.
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
