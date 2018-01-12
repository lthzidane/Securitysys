package session;

import entities.SolicitudDet;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "solicitudDetController")
@ViewScoped
public class SolicitudDetController extends AbstractController<SolicitudDet> {

    @Inject
    private DescuentoController idDescuentoController;
    @Inject
    private PromocionController idPromocionController;
    @Inject
    private ServicioController idServicioController;
    @Inject
    private SolicitudController solicitudController;

    public SolicitudDetController() {
        // Inform the Abstract parent controller of the concrete SolicitudDet Entity
        super(SolicitudDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getSolicitudDetPK().setIdSolicitudCab(this.getSelected().getSolicitud().getIdSolicitud());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSolicitudDetPK(new entities.SolicitudDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDescuentoController.setSelected(null);
        idPromocionController.setSelected(null);
        idServicioController.setSelected(null);
        solicitudController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Descuento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDescuento(ActionEvent event) {
        if (this.getSelected() != null && idDescuentoController.getSelected() == null) {
            idDescuentoController.setSelected(this.getSelected().getIdDescuento());
        }
    }

    /**
     * Sets the "selected" attribute of the Promocion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPromocion(ActionEvent event) {
        if (this.getSelected() != null && idPromocionController.getSelected() == null) {
            idPromocionController.setSelected(this.getSelected().getIdPromocion());
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
     * Sets the "selected" attribute of the Solicitud controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSolicitud(ActionEvent event) {
        if (this.getSelected() != null && solicitudController.getSelected() == null) {
            solicitudController.setSelected(this.getSelected().getSolicitud());
        }
    }
}
