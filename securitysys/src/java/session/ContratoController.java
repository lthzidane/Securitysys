package session;

import entities.Contrato;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "contratoController")
@ViewScoped
public class ContratoController extends AbstractController<Contrato> {

    @Inject
    private ClienteController clienteController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private SucursalController idSucursalController;

    public ContratoController() {
        // Inform the Abstract parent controller of the concrete Contrato Entity
        super(Contrato.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getContratoPK().setIdCliente(this.getSelected().getCliente().getIdCliente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setContratoPK(new entities.ContratoPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        clienteController.setSelected(null);
        idEstadoController.setSelected(null);
        idServicioController.setSelected(null);
        idSucursalController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CuentaCliente entities
     * that are retrieved from Contrato?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCliente(ActionEvent event) {
        if (this.getSelected() != null && clienteController.getSelected() == null) {
            clienteController.setSelected(this.getSelected().getCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Estado controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEstado(ActionEvent event) {
        if (this.getSelected() != null && idEstadoController.getSelected() == null) {
            idEstadoController.setSelected(this.getSelected().getIdEstado());
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

    /**
     * Sets the "selected" attribute of the Sucursal controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSucursal(ActionEvent event) {
        if (this.getSelected() != null && idSucursalController.getSelected() == null) {
            idSucursalController.setSelected(this.getSelected().getIdSucursal());
        }
    }


}
