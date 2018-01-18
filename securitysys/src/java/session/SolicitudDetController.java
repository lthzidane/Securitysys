package session;

import entities.SolicitudDet;
import bean.SolicitudDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitudDetController")
@ViewScoped
public class SolicitudDetController extends AbstractController<SolicitudDet> {

    public SolicitudDetController() {
        // Inform the Abstract parent controller of the concrete SolicitudDet Entity
        super(SolicitudDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getSolicitudDetPK().setIdSolicitudCab(this.getSelected().getSolicitud().getIdSolicitud());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSolicitudDetPK(new entities.SolicitudDetPK());
    }

}
