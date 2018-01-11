package session;

import bean.EmpresaFacade;
import entities.Empresa;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "empresaController")
@ViewScoped
public class EmpresaController extends AbstractController<Empresa> {

    @EJB
    private EmpresaFacade ejbFacade;
    @ManagedProperty(value = "#{ciudadController}")
    private CiudadController idCiudadController;

    /* Setter method for managed property idCiudadController */
    public void setIdCiudadController(CiudadController idCiudadController) {
        this.idCiudadController = idCiudadController;
    }

    /**
     * Initialize the concrete Empresa controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public EmpresaController() {
        // Inform the Abstract parent controller of the concrete Empresa Entity
        super(Empresa.class);
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
