package session;

import entities.TipoComprobante;
import entities.Timbrado;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import entities.NotaRemisionVenta;
import java.util.List;
import bean.TipoComprobanteFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tipoComprobanteController")
@ViewScoped
public class TipoComprobanteController extends AbstractController<TipoComprobante> {

    public TipoComprobanteController() {
        // Inform the Abstract parent controller of the concrete TipoComprobante Entity
        super(TipoComprobante.class);
    }

}
