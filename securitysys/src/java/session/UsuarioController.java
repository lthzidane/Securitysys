package session;

import entities.Usuario;
import entities.Promocion;
import entities.AperturaCierreCaja;
import entities.Presupuesto;
import entities.OrdenTrabajo;
import entities.Reclamo;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import entities.NotaRemisionVenta;
import entities.Diagnostico;
import entities.Solicitud;
import java.util.List;
import bean.UsuarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

}
