package session;

import entities.Marca;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcaController")
@ViewScoped
public class MarcaController extends AbstractController<Marca> {

    public MarcaController() {
        // Inform the Abstract parent controller of the concrete Marca Entity
        super(Marca.class);
    }

    /**
     * Sets the "items" attribute with a collection of Moviles entities that are
     * retrieved from Marca?cap_first and returns the navigation outcome.
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
