package session;

import entities.Valor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "valorController")
@ViewScoped
public class ValorController extends AbstractController<Valor> {

    public ValorController() {
        // Inform the Abstract parent controller of the concrete Valor Entity
        super(Valor.class);
    }

    /**
     * Sets the "items" attribute with a collection of Arqueo entities that are
     * retrieved from Valor?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Arqueo page
     */
    public String navigateArqueoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Arqueo_items", this.getSelected().getArqueoList());
        }
        return "/arqueo/index";
    }

}
