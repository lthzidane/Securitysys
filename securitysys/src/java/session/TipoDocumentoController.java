package session;

import entities.TipoDocumento;
import entities.Cliente;
import java.util.List;
import bean.TipoDocumentoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoDocumentoController")
@ViewScoped
public class TipoDocumentoController extends AbstractController<TipoDocumento> {

    public TipoDocumentoController() {
        // Inform the Abstract parent controller of the concrete TipoDocumento Entity
        super(TipoDocumento.class);
    }

}
