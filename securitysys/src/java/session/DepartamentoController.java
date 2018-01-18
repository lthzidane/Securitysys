package session;

import entities.Departamento;
import entities.Reclamo;
import java.util.List;
import bean.DepartamentoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento Entity
        super(Departamento.class);
    }

}
