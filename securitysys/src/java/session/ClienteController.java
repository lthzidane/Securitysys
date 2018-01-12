package session;

import entities.Cliente;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "clienteController")
@ViewScoped
public class ClienteController extends AbstractController<Cliente> {

    @Inject
    private CiudadController idCiudadController;
    @Inject
    private NacionalidadController idNacionalidadController;
    @Inject
    private TipoDocumentoController idTipoDocumentoController;

    public ClienteController() {
        // Inform the Abstract parent controller of the concrete Cliente Entity
        super(Cliente.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCiudadController.setSelected(null);
        idNacionalidadController.setSelected(null);
        idTipoDocumentoController.setSelected(null);
    }

       /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCiudad(ActionEvent event) {
        if (this.getSelected() != null && idCiudadController.getSelected() == null) {
            idCiudadController.setSelected(this.getSelected().getIdCiudad());
        }
    }

    /**
     * Sets the "selected" attribute of the Nacionalidad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdNacionalidad(ActionEvent event) {
        if (this.getSelected() != null && idNacionalidadController.getSelected() == null) {
            idNacionalidadController.setSelected(this.getSelected().getIdNacionalidad());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoDocumento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoDocumento(ActionEvent event) {
        if (this.getSelected() != null && idTipoDocumentoController.getSelected() == null) {
            idTipoDocumentoController.setSelected(this.getSelected().getIdTipoDocumento());
        }
    }


   
}
