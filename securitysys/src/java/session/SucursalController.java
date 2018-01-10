package session;

import session.util.MobilePageController;
import entities.Sucursal;
import bean.SucursalFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "sucursalController")
@ViewScoped
public class SucursalController extends AbstractController<Sucursal> {

    @EJB
    private SucursalFacade ejbFacade;
    @ManagedProperty(value = "#{ciudadController}")
    private CiudadController idCiudadController;
    @ManagedProperty(value = "#{mobilePageController}")
    private MobilePageController mobilePageController;

    /* Setter method for managed property idCiudadController */
    public void setIdCiudadController(CiudadController idCiudadController) {
        this.idCiudadController = idCiudadController;
    }

    /* Setter method for managed property mobilePageController */
    public void setMobilePageController(MobilePageController mobilePageController) {
        this.mobilePageController = mobilePageController;
    }

    /**
     * Initialize the concrete Sucursal controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

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
