package session;

import entities.AperturaCierreCaja;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "aperturaCierreCajaController")
@ViewScoped
public class AperturaCierreCajaController extends AbstractController<AperturaCierreCaja> {

    @Inject
    private CajaController idCajaController;
    @Inject
    private SucursalController idSucursalController;
    @Inject
    private UsuarioController idUsuarioController;

    public AperturaCierreCajaController() {
        // Inform the Abstract parent controller of the concrete AperturaCierreCaja Entity
        super(AperturaCierreCaja.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCajaController.setSelected(null);
        idSucursalController.setSelected(null);
        idUsuarioController.setSelected(null);
    }

    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
