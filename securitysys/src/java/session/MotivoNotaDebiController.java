package session;

import entities.MotivoNotaDebi;
import entities.NotaCrediDebiVenta;
import entities.NotaRemisionVenta;
import java.util.List;
import bean.MotivoNotaDebiFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "motivoNotaDebiController")
@ViewScoped
public class MotivoNotaDebiController extends AbstractController<MotivoNotaDebi> {

    public MotivoNotaDebiController() {
        // Inform the Abstract parent controller of the concrete MotivoNotaDebi Entity
        super(MotivoNotaDebi.class);
    }

}
