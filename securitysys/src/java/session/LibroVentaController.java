package session;

import entities.LibroVenta;
import bean.LibroVentaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "libroVentaController")
@ViewScoped
public class LibroVentaController extends AbstractController<LibroVenta> {

    public LibroVentaController() {
        // Inform the Abstract parent controller of the concrete LibroVenta Entity
        super(LibroVenta.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getLibroVentaPK().setIdVenta(this.getSelected().getVenta().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setLibroVentaPK(new entities.LibroVentaPK());
    }

}
