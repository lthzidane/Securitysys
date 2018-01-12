package session;

import entities.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Sets the "items" attribute with a collection of Promocion entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of AperturaCierreCaja
     * entities that are retrieved from Usuario?cap_first and returns the
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
     * Sets the "items" attribute with a collection of Presupuesto entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
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
     * that are retrieved from Usuario?cap_first and returns the navigation
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
     * retrieved from Usuario?cap_first and returns the navigation outcome.
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
     * retrieved from Usuario?cap_first and returns the navigation outcome.
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
     * entities that are retrieved from Usuario?cap_first and returns the
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
     * Sets the "items" attribute with a collection of NotaRemisionVenta
     * entities that are retrieved from Usuario?cap_first and returns the
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
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
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
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Solicitud page
     */
    public String navigateSolicitudList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Solicitud_items", this.getSelected().getSolicitudList());
        }
        return "/solicitud/index";
    }

}
