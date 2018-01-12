package session;

import entities.CobroTarjeta;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cobroTarjetaController")
@ViewScoped
public class CobroTarjetaController extends AbstractController<CobroTarjeta> {

    @Inject
    private CobroDetController cobroDetController;
    @Inject
    private TarjetaController idTarjetaController;

    public CobroTarjetaController() {
        // Inform the Abstract parent controller of the concrete CobroTarjeta Entity
        super(CobroTarjeta.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCobroTarjetaPK().setIdCobro(this.getSelected().getCobroDet().getCobroDetPK().getIdCobro());
        this.getSelected().getCobroTarjetaPK().setIdCtaACobrar(this.getSelected().getCobroDet().getCobroDetPK().getIdCtaACobrar());
        this.getSelected().getCobroTarjetaPK().setIdVenta(this.getSelected().getCobroDet().getCobroDetPK().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCobroTarjetaPK(new entities.CobroTarjetaPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cobroDetController.setSelected(null);
        idTarjetaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the CobroDet controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCobroDet(ActionEvent event) {
        if (this.getSelected() != null && cobroDetController.getSelected() == null) {
            cobroDetController.setSelected(this.getSelected().getCobroDet());
        }
    }

    /**
     * Sets the "selected" attribute of the Tarjeta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTarjeta(ActionEvent event) {
        if (this.getSelected() != null && idTarjetaController.getSelected() == null) {
            idTarjetaController.setSelected(this.getSelected().getIdTarjeta());
        }
    }

}
