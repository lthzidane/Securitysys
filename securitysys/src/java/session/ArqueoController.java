package session;

import entities.Arqueo;
import entities.Recaudacion;
import java.util.List;
import bean.ArqueoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "arqueoController")
@ViewScoped
public class ArqueoController extends AbstractController<Arqueo> {

    public ArqueoController() {
        // Inform the Abstract parent controller of the concrete Arqueo Entity
        super(Arqueo.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getArqueoPK().setIdValor(this.getSelected().getValor().getIdValor());
        this.getSelected().getArqueoPK().setIdAperturaCierre(this.getSelected().getAperturaCierreCaja().getIdAperturaCierre());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setArqueoPK(new entities.ArqueoPK());
    }

}
