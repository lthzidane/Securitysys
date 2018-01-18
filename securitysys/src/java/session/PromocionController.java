package session;

import entities.Promocion;
import entities.SolicitudDet;
import entities.PromocionDet;
import entities.PresupuestoDet;
import entities.Servicio;
import entities.VentaDet;
import java.util.List;
import bean.PromocionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "promocionController")
@ViewScoped
public class PromocionController extends AbstractController<Promocion> {

    public PromocionController() {
        // Inform the Abstract parent controller of the concrete Promocion Entity
        super(Promocion.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPromocionPK().setIdPresu(this.getSelected().getPresupuesto().getIdPresupuesto());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPromocionPK(new entities.PromocionPK());
    }

}
