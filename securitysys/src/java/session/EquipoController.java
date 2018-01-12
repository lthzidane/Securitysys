package session;

import entities.Equipo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "equipoController")
@ViewScoped
public class EquipoController extends AbstractController<Equipo> {

    public EquipoController() {
        // Inform the Abstract parent controller of the concrete Equipo Entity
        super(Equipo.class);
    }

    /**
     * Sets the "items" attribute with a collection of PromocionDet entities
     * that are retrieved from Equipo?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of NotaCrediDebiVentaDet
     * entities that are retrieved from Equipo?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaCrediDebiVentaDet page
     */
    public String navigateNotaCrediDebiVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaCrediDebiVentaDet_items", this.getSelected().getNotaCrediDebiVentaDetList());
        }
        return "/notaCrediDebiVentaDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of DiagnosticoDet entities
     * that are retrieved from Equipo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DiagnosticoDet page
     */
    public String navigateDiagnosticoDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DiagnosticoDet_items", this.getSelected().getDiagnosticoDetList());
        }
        return "/diagnosticoDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of NotaRemisionVentaDet
     * entities that are retrieved from Equipo?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for NotaRemisionVentaDet page
     */
    public String navigateNotaRemisionVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("NotaRemisionVentaDet_items", this.getSelected().getNotaRemisionVentaDetList());
        }
        return "/notaRemisionVentaDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of VentaDet entities that
     * are retrieved from Equipo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for VentaDet page
     */
    public String navigateVentaDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("VentaDet_items", this.getSelected().getVentaDetList());
        }
        return "/ventaDet/index";
    }

    /**
     * Sets the "items" attribute with a collection of InstalacionDet entities
     * that are retrieved from Equipo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for InstalacionDet page
     */
    public String navigateInstalacionDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("InstalacionDet_items", this.getSelected().getInstalacionDetList());
        }
        return "/instalacionDet/index";
    }

}
