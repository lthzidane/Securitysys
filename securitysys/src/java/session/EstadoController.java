package session;

import entities.Estado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "estadoController")
@ViewScoped
public class EstadoController extends AbstractController<Estado> {

    public EstadoController() {
        // Inform the Abstract parent controller of the concrete Estado Entity
        super(Estado.class);
    }

    /**
     * Sets the "items" attribute with a collection of CuentaCliente entities
     * that are retrieved from Estado?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CuentaCliente page
     */
    public String navigateCuentaClienteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CuentaCliente_items", this.getSelected().getCuentaClienteList());
        }
        return "/cuentaCliente/index";
    }

    /**
     * Sets the "items" attribute with a collection of Contrato entities that
     * are retrieved from Estado?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Contrato page
     */
    public String navigateContratoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Contrato_items", this.getSelected().getContratoList());
        }
        return "/contrato/index";
    }

    /**
     * Sets the "items" attribute with a collection of Presupuesto entities that
     * are retrieved from Estado?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Presupuesto page
     */
    public String navigatePresupuestoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Presupuesto_items", this.getSelected().getPresupuestoList());
        }
        return "/presupuesto/index";
    }

    /**
     * Sets the "items" attribute with a collection of Reclamo entities that are
     * retrieved from Estado?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Reclamo page
     */
    public String navigateReclamoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Reclamo_items", this.getSelected().getReclamoList());
        }
        return "/reclamo/index";
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from Estado?cap_first and returns the navigation outcome.
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
