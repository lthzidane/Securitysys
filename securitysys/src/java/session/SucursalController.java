package session;

import entities.Sucursal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "sucursalController")
@ViewScoped
public class SucursalController extends AbstractController<Sucursal> {

    @Inject
    private CiudadController idCiudadController;

    public SucursalController() {
        // Inform the Abstract parent controller of the concrete Sucursal Entity
        super(Sucursal.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCiudadController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Promocion entities that
     * are retrieved from Sucursal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Promocion page
     */
    public String navigatePromocionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Promocion_items", this.getSelected().getPromocionList());
        }
        return "/promocion/index";
    }

    /**
     * Sets the "items" attribute with a collection of CuentaCliente entities
     * that are retrieved from Sucursal?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of AperturaCierreCaja
     * entities that are retrieved from Sucursal?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AperturaCierreCaja page
     */
    public String navigateAperturaCierreCajaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AperturaCierreCaja_items", this.getSelected().getAperturaCierreCajaList());
        }
        return "/aperturaCierreCaja/index";
    }

    /**
     * Sets the "items" attribute with a collection of Contrato entities that
     * are retrieved from Sucursal?cap_first and returns the navigation outcome.
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
     * are retrieved from Sucursal?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of OrdenTrabajo entities
     * that are retrieved from Sucursal?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for OrdenTrabajo page
     */
    public String navigateOrdenTrabajoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("OrdenTrabajo_items", this.getSelected().getOrdenTrabajoList());
        }
        return "/ordenTrabajo/index";
    }

    /**
     * Sets the "items" attribute with a collection of Reclamo entities that are
     * retrieved from Sucursal?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Venta entities that are
     * retrieved from Sucursal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Venta page
     */
    public String navigateVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Venta_items", this.getSelected().getVentaList());
        }
        return "/venta/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotaCrediDebiVenta
     * entities that are retrieved from Sucursal?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaCrediDebiVenta page
     */
    public String navigateNotaCrediDebiVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaCrediDebiVenta_items", this.getSelected().getNotaCrediDebiVentaList());
        }
        return "/notaCrediDebiVenta/index";
    }

    /**
     * Sets the "items" attribute with a collection of SerieComprobante entities
     * that are retrieved from Sucursal?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SerieComprobante page
     */
    public String navigateSerieComprobanteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SerieComprobante_items", this.getSelected().getSerieComprobanteList());
        }
        return "/serieComprobante/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotaRemisionVenta
     * entities that are retrieved from Sucursal?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaRemisionVenta page
     */
    public String navigateNotaRemisionVentaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaRemisionVenta_items", this.getSelected().getNotaRemisionVentaList());
        }
        return "/notaRemisionVenta/index";
    }

    /**
     * Sets the "items" attribute with a collection of Diagnostico entities that
     * are retrieved from Sucursal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Diagnostico page
     */
    public String navigateDiagnosticoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Diagnostico_items", this.getSelected().getDiagnosticoList());
        }
        return "/diagnostico/index";
    }

    /**
     * Sets the "items" attribute with a collection of Solicitud entities that
     * are retrieved from Sucursal?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Solicitud page
     */
    public String navigateSolicitudList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Solicitud_items", this.getSelected().getSolicitudList());
        }
        return "/solicitud/index";
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
}
