package session;

import entities.Promocion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "promocionController")
@ViewScoped
public class PromocionController extends AbstractController<Promocion> {

    @Inject
    private PresupuestoController presupuestoController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private UsuarioController idUsuarioController;

    public PromocionController() {
        // Inform the Abstract parent controller of the concrete Promocion Entity
        super(Promocion.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPromocionPK().setIdPresu(this.getSelected().getPresupuesto().getIdPresupuesto());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPromocionPK(new entities.PromocionPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        presupuestoController.setSelected(null);
        idSucursalController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Presupuesto controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePresupuesto(ActionEvent event) {
        if (this.getSelected() != null && presupuestoController.getSelected() == null) {
            presupuestoController.setSelected(this.getSelected().getPresupuesto());
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

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUsuario(ActionEvent event) {
        if (this.getSelected() != null && idUsuarioController.getSelected() == null) {
            idUsuarioController.setSelected(this.getSelected().getIdUsuario());
        }
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudDet entities
     * that are retrieved from Promocion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SolicitudDet page
     */
    public String navigateSolicitudDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SolicitudDet_items", this.getSelected().getSolicitudDetList());
        }
        return "/solicitudDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of PromocionDet entities
     * that are retrieved from Promocion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PromocionDet page
     */
    public String navigatePromocionDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PromocionDet_items", this.getSelected().getPromocionDetList());
        }
        return "/promocionDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of PresupuestoDet entities
     * that are retrieved from Promocion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PresupuestoDet page
     */
    public String navigatePresupuestoDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PresupuestoDet_items", this.getSelected().getPresupuestoDetList());
        }
        return "/presupuestoDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of Servicio entities that
     * are retrieved from Promocion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Servicio page
     */
    public String navigateServicioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Servicio_items", this.getSelected().getServicioList());
        }
        return "/servicio/index";
    }

    /**
     * Sets the "items" attribute with a collection of VentaDet entities that
     * are retrieved from Promocion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for VentaDet page
     */
    public String navigateVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("VentaDet_items", this.getSelected().getVentaDetList());
        }
        return "/ventaDet/index";
    }

}
