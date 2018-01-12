package session;

import entities.CuentaCliente;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cuentaClienteController")
@ViewScoped
public class CuentaClienteController extends AbstractController<CuentaCliente> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private ContratoController contratoController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private SegmentoContratoController idSegmentoController;
    @Inject
    private SucursalController idSucursalController;

    public CuentaClienteController() {
        // Inform the Abstract parent controller of the concrete CuentaCliente Entity
        super(CuentaCliente.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        contratoController.setSelected(null);
        idEstadoController.setSelected(null);
        idSegmentoController.setSelected(null);
        idSucursalController.setSelected(null);
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
     * Sets the "selected" attribute of the Contrato controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareContrato(ActionEvent event) {
        if (this.getSelected() != null && contratoController.getSelected() == null) {
            contratoController.setSelected(this.getSelected().getContrato());
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
     * Sets the "selected" attribute of the SegmentoContrato controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSegmento(ActionEvent event) {
        if (this.getSelected() != null && idSegmentoController.getSelected() == null) {
            idSegmentoController.setSelected(this.getSelected().getIdSegmento());
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
