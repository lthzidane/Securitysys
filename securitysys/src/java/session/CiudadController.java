package session;

import entities.Ciudad;
import entities.Zona;
import entities.Cliente;
import entities.Empresa;
import entities.Sucursal;
import java.util.List;
import bean.CiudadFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad Entity
        super(Ciudad.class);
    }

}
