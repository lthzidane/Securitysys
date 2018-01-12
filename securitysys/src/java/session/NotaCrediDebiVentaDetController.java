package session;

import entities.NotaCrediDebiVentaDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "notaCrediDebiVentaDetController")
@ViewScoped
public class NotaCrediDebiVentaDetController extends AbstractController<NotaCrediDebiVentaDet> {

    @Inject
    private EquipoController idEquipoController;
    @Inject
    private NotaCrediDebiVentaController notaCrediDebiVentaController;

    public NotaCrediDebiVentaDetController() {
        // Inform the Abstract parent controller of the concrete NotaCrediDebiVentaDet Entity
        super(NotaCrediDebiVentaDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getNotaCrediDebiVentaDetPK().setIdNotaVenta(this.getSelected().getNotaCrediDebiVenta().getIdNotaVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setNotaCrediDebiVentaDetPK(new entities.NotaCrediDebiVentaDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEquipoController.setSelected(null);
        notaCrediDebiVentaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Equipo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEquipo(ActionEvent event) {
        if (this.getSelected() != null && idEquipoController.getSelected() == null) {
            idEquipoController.setSelected(this.getSelected().getIdEquipo());
        }
    }

    /**
     * Sets the "selected" attribute of the NotaCrediDebiVenta controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNotaCrediDebiVenta(ActionEvent event) {
        if (this.getSelected() != null && notaCrediDebiVentaController.getSelected() == null) {
            notaCrediDebiVentaController.setSelected(this.getSelected().getNotaCrediDebiVenta());
        }
    }
}
