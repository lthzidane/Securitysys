package session;

import entities.NotaRemisionVentaDet;
import bean.NotaRemisionVentaDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "notaRemisionVentaDetController")
@ViewScoped
public class NotaRemisionVentaDetController extends AbstractController<NotaRemisionVentaDet> {

    public NotaRemisionVentaDetController() {
        // Inform the Abstract parent controller of the concrete NotaRemisionVentaDet Entity
        super(NotaRemisionVentaDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getNotaRemisionVentaDetPK().setIdRemision(this.getSelected().getNotaRemisionVenta().getIdRemision());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setNotaRemisionVentaDetPK(new entities.NotaRemisionVentaDetPK());
    }

}
