package session;

import entities.SegmentoContrato;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "segmentoContratoController")
@ViewScoped
public class SegmentoContratoController extends AbstractController<SegmentoContrato> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private ServicioController idServicioController;

    public SegmentoContratoController() {
        // Inform the Abstract parent controller of the concrete SegmentoContrato Entity
        super(SegmentoContrato.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        idServicioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CuentaCliente entities
     * that are retrieved from SegmentoContrato?cap_first and returns the
     * navigation outcome.
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
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        if (this.getSelected() != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(this.getSelected().getIdCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Servicio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServicio(ActionEvent event) {
        if (this.getSelected() != null && idServicioController.getSelected() == null) {
            idServicioController.setSelected(this.getSelected().getIdServicio());
        }
    }
}
