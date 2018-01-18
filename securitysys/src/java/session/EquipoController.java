package session;

import entities.Equipo;
import entities.PromocionDet;
import entities.NotaCrediDebiVentaDet;
import entities.DiagnosticoDet;
import entities.NotaRemisionVentaDet;
import entities.VentaDet;
import entities.InstalacionDet;
import java.util.List;
import bean.EquipoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "equipoController")
@ViewScoped
public class EquipoController extends AbstractController<Equipo> {

    public EquipoController() {
        // Inform the Abstract parent controller of the concrete Equipo Entity
        super(Equipo.class);
    }

}
