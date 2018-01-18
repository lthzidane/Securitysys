package session;

import entities.NotaCrediDebiVentaDet;
import bean.NotaCrediDebiVentaDetFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "notaCrediDebiVentaDetController")
@ViewScoped
public class NotaCrediDebiVentaDetController extends AbstractController<NotaCrediDebiVentaDet> {

    public NotaCrediDebiVentaDetController() {
        // Inform the Abstract parent controller of the concrete NotaCrediDebiVentaDet Entity
        super(NotaCrediDebiVentaDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getNotaCrediDebiVentaDetPK().setIdNotaVenta(this.getSelected().getNotaCrediDebiVenta().getIdNotaVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setNotaCrediDebiVentaDetPK(new entities.NotaCrediDebiVentaDetPK());
    }

}
