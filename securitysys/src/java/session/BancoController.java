package session;

import entities.Banco;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "bancoController")
@ViewScoped
public class BancoController extends AbstractController<Banco> {

    public BancoController() {
        // Inform the Abstract parent controller of the concrete Banco Entity
        super(Banco.class);
    }

    /**
     * Sets the "items" attribute with a collection of CobroCheque entities that
     * are retrieved from Banco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CobroCheque page
     */
    public String navigateCobroChequeList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CobroCheque_items", this.getSelected().getCobroChequeList());
        }
        return "/cobroCheque/index";
    }

}
