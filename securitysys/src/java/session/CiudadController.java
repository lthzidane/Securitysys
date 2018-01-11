package session;

import bean.CiudadFacade;
import entities.Ciudad;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    @EJB
    private CiudadFacade ejbFacade;

    /**
     * Initialize the concrete Ciudad controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad Entity
        super(Ciudad.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cliente entities that are
     * retrieved from Ciudad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cliente page
     */
    public String navigateClienteList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cliente_items", this.getSelected().getClienteList());
        }
        return "/cliente/index";
    }

    /**
     * Sets the "items" attribute with a collection of Zona entities that are
     * retrieved from Ciudad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Zona page
     */
    public String navigateZonaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Zona_items", this.getSelected().getZonaList());
        }
        return "/zona/index";
    }

    /**
     * Sets the "items" attribute with a collection of Sucursal entities that
     * are retrieved from Ciudad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Sucursal page
     */
    public String navigateSucursalList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Sucursal_items", this.getSelected().getSucursalList());
        }
        return "/sucursal/index";
    }

    /**
     * Sets the "items" attribute with a collection of Empresa entities that are
     * retrieved from Ciudad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Empresa page
     */
    public String navigateEmpresaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empresa_items", this.getSelected().getEmpresaList());
        }
        return "/empresa/index";
    }

}
