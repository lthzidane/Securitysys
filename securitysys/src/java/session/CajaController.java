package session;

import entities.Caja;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "cajaController")
@ViewScoped
public class CajaController extends AbstractController<Caja> {

    public CajaController() {
        // Inform the Abstract parent controller of the concrete Caja Entity
        super(Caja.class);
    }

    /**
     * Sets the "items" attribute with a collection of AperturaCierreCaja
     * entities that are retrieved from Caja?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AperturaCierreCaja page
     */
    public String navigateAperturaCierreCajaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AperturaCierreCaja_items", this.getSelected().getAperturaCierreCajaList());
        }
        return "/aperturaCierreCaja/index";
    }

}
