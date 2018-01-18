package session;

import entities.TipoCuadrilla;
import entities.Cuadrilla;
import java.util.List;
import bean.TipoCuadrillaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoCuadrillaController")
@ViewScoped
public class TipoCuadrillaController extends AbstractController<TipoCuadrilla> {

    public TipoCuadrillaController() {
        // Inform the Abstract parent controller of the concrete TipoCuadrilla Entity
        super(TipoCuadrilla.class);
    }

}
