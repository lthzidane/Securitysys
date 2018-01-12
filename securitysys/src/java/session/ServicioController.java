package session;

import entities.Servicio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "servicioController")
@ViewScoped
public class ServicioController extends AbstractController<Servicio> {

    @Inject
    private DescuentoController idDescuentoController;
    @Inject
    private EstadoController idEstadoController;
    @Inject
    private MonedaController idMonedaController;
    @Inject
    private PromocionController idPromocionController;

    public ServicioController() {
        // Inform the Abstract parent controller of the concrete Servicio Entity
        super(Servicio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDescuentoController.setSelected(null);
        idEstadoController.setSelected(null);
        idMonedaController.setSelected(null);
        idPromocionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of SolicitudDet entities
     * that are retrieved from Servicio?cap_first and returns the navigation
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
     * that are retrieved from Servicio?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Contrato entities that
     * are retrieved from Servicio?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Moneda controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMoneda(ActionEvent event) {
        if (this.getSelected() != null && idMonedaController.getSelected() == null) {
            idMonedaController.setSelected(this.getSelected().getIdMoneda());
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
     * Sets the "items" attribute with a collection of SegmentoContrato entities
     * that are retrieved from Servicio?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SegmentoContrato page
     */
    public String navigateSegmentoContratoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SegmentoContrato_items", this.getSelected().getSegmentoContratoList());
        }
        return "/segmentoContrato/index";
    }

}
