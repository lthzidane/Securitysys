package session;

import entities.InstalacionDet;
import bean.InstalacionDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "instalacionDetController")
@ViewScoped
public class InstalacionDetController extends AbstractController<InstalacionDet> {

    public InstalacionDetController() {
        // Inform the Abstract parent controller of the concrete InstalacionDet Entity
        super(InstalacionDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getInstalacionDetPK().setIdInstalacion(this.getSelected().getInstalacionCab().getIdInstalacion());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setInstalacionDetPK(new entities.InstalacionDetPK());
    }

}
