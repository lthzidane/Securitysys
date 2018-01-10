package session;

import session.util.MobilePageController;
import entities.Ruta;
import bean.RutaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
@ManagedBean(name = "rutaController")
@ViewScoped
public class RutaController extends AbstractController<Ruta> {

    @EJB
    private RutaFacade ejbFacade;
    @ManagedProperty(value = "#{zonaController}")
    private ZonaController idZonaController;
    @ManagedProperty(value = "#{mobilePageController}")
    private MobilePageController mobilePageController;

    /* Setter method for managed property idZonaController */
    public void setIdZonaController(ZonaController idZonaController) {
        this.idZonaController = idZonaController;
    }

    /* Setter method for managed property mobilePageController */
    public void setMobilePageController(MobilePageController mobilePageController) {
        this.mobilePageController = mobilePageController;
    }

    /**
     * Initialize the concrete Ruta controller bean.
     * The AbstractController requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public RutaController() {
        // Inform the Abstract parent controller of the concrete Ruta Entity
        super(Ruta.class);
    }


    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idZonaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Zona controller
     * in order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdZona(ActionEvent event) {
        if (this.getSelected() != null && idZonaController.getSelected() == null) {
            idZonaController.setSelected(this.getSelected().getIdZona());
        }
    }
}
