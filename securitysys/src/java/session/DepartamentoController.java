package session;

import entities.Departamento;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento Entity
        super(Departamento.class);
    }
}
