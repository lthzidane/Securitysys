package session;

import entities.Recaudacion;
import bean.RecaudacionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "recaudacionController")
@ViewScoped
public class RecaudacionController extends AbstractController<Recaudacion> {

    public RecaudacionController() {
        // Inform the Abstract parent controller of the concrete Recaudacion Entity
        super(Recaudacion.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getRecaudacionPK().setIdFormaCobro(this.getSelected().getFormaCobro().getIdFormaCobro());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setRecaudacionPK(new entities.RecaudacionPK());
    }

}
