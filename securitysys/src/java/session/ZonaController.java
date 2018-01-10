package session;

import session.CiudadController;
import bean.ZonaFacade;
import bean.util.MobilePageController;
import entities.Zona;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "zonaController")
@ViewScoped
public class ZonaController extends AbstractController<Zona> {

    @EJB
    private ZonaFacade ejbFacade;
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
     * Initialize the concrete Zona controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ZonaController() {
        // Inform the Abstract parent controller of the concrete Zona Entity
        super(Zona.class);
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
