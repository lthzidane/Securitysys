package session;

import entities.SerieComprobante;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import java.util.List;
import bean.SerieComprobanteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "serieComprobanteController")
@ViewScoped
public class SerieComprobanteController extends AbstractController<SerieComprobante> {

    public SerieComprobanteController() {
        // Inform the Abstract parent controller of the concrete SerieComprobante Entity
        super(SerieComprobante.class);
    }

}
