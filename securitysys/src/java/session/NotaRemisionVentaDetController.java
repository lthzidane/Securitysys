package session;

import entities.NotaRemisionVentaDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "notaRemisionVentaDetController")
@ViewScoped
public class NotaRemisionVentaDetController extends AbstractController<NotaRemisionVentaDet> {

    @Inject
    private EquipoController idEquipoController;
    @Inject
    private NotaRemisionVentaController notaRemisionVentaController;

    public NotaRemisionVentaDetController() {
        // Inform the Abstract parent controller of the concrete NotaRemisionVentaDet Entity
        super(NotaRemisionVentaDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getNotaRemisionVentaDetPK().setIdRemision(this.getSelected().getNotaRemisionVenta().getIdRemision());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setNotaRemisionVentaDetPK(new entities.NotaRemisionVentaDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEquipoController.setSelected(null);
        notaRemisionVentaController.setSelected(null);
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
     * Sets the "selected" attribute of the NotaRemisionVenta controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNotaRemisionVenta(ActionEvent event) {
        if (this.getSelected() != null && notaRemisionVentaController.getSelected() == null) {
            notaRemisionVentaController.setSelected(this.getSelected().getNotaRemisionVenta());
        }
    }
}
