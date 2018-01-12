package session;

import entities.FormaCobro;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "formaCobroController")
@ViewScoped
public class FormaCobroController extends AbstractController<FormaCobro> {

    public FormaCobroController() {
        // Inform the Abstract parent controller of the concrete FormaCobro Entity
        super(FormaCobro.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cobro entities that are
     * retrieved from FormaCobro?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cobro page
     */
    public String navigateCobroList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cobro_items", this.getSelected().getCobroList());
        }
        return "/cobro/index";
    }

    /**
     * Sets the "items" attribute with a collection of Recaudacion entities that
     * are retrieved from FormaCobro?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Recaudacion page
     */
    public String navigateRecaudacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Recaudacion_items", this.getSelected().getRecaudacionList());
        }
        return "/recaudacion/index";
    }



}
