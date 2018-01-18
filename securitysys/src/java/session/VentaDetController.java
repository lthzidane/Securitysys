package session;

import entities.VentaDet;
import bean.VentaDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ventaDetController")
@ViewScoped
public class VentaDetController extends AbstractController<VentaDet> {

    public VentaDetController() {
        // Inform the Abstract parent controller of the concrete VentaDet Entity
        super(VentaDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getVentaDetPK().setIdVenta(this.getSelected().getVenta().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setVentaDetPK(new entities.VentaDetPK());
    }

}
