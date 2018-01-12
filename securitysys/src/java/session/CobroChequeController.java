package session;

import entities.CobroCheque;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cobroChequeController")
@ViewScoped
public class CobroChequeController extends AbstractController<CobroCheque> {

    @Inject
    private BancoController idBancoController;
    @Inject
    private CobroDetController cobroDetController;

    public CobroChequeController() {
        // Inform the Abstract parent controller of the concrete CobroCheque Entity
        super(CobroCheque.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCobroChequePK().setIdCobro(this.getSelected().getCobroDet().getCobroDetPK().getIdCobro());
        this.getSelected().getCobroChequePK().setIdCtaACobrar(this.getSelected().getCobroDet().getCobroDetPK().getIdCtaACobrar());
        this.getSelected().getCobroChequePK().setIdVenta(this.getSelected().getCobroDet().getCobroDetPK().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCobroChequePK(new entities.CobroChequePK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBancoController.setSelected(null);
        cobroDetController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Banco controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBanco(ActionEvent event) {
        if (this.getSelected() != null && idBancoController.getSelected() == null) {
            idBancoController.setSelected(this.getSelected().getIdBanco());
        }
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


}
