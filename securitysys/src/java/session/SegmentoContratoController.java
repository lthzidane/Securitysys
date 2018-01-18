package session;

import entities.SegmentoContrato;
import entities.CuentaCliente;
import java.util.List;
import bean.SegmentoContratoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "segmentoContratoController")
@ViewScoped
public class SegmentoContratoController extends AbstractController<SegmentoContrato> {

    public SegmentoContratoController() {
        // Inform the Abstract parent controller of the concrete SegmentoContrato Entity
        super(SegmentoContrato.class);
    }

}
