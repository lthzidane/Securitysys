package session;

import entities.CobroDet;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "cobroDetController")
@ViewScoped
public class CobroDetController extends AbstractController<CobroDet> {

    @Inject
    private CobroController cobroController;
    @Inject
    private CtaACobrarController ctaACobrarController;

    public CobroDetController() {
        // Inform the Abstract parent controller of the concrete CobroDet Entity
        super(CobroDet.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCobroDetPK().setIdCobro(this.getSelected().getCobro().getIdCobro());
        this.getSelected().getCobroDetPK().setIdCtaACobrar(this.getSelected().getCtaACobrar().getCtaACobrarPK().getIdCtaACobrar());
        this.getSelected().getCobroDetPK().setIdVenta(this.getSelected().getCtaACobrar().getCtaACobrarPK().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCobroDetPK(new entities.CobroDetPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cobroController.setSelected(null);
        ctaACobrarController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cobro controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCobro(ActionEvent event) {
        if (this.getSelected() != null && cobroController.getSelected() == null) {
            cobroController.setSelected(this.getSelected().getCobro());
        }
    }

    /**
     * Sets the "selected" attribute of the CtaACobrar controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCtaACobrar(ActionEvent event) {
        if (this.getSelected() != null && ctaACobrarController.getSelected() == null) {
            ctaACobrarController.setSelected(this.getSelected().getCtaACobrar());
        }
    }

    /**
     * Sets the "items" attribute with a collection of CobroCheque entities that
     * are retrieved from CobroDet?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for CobroCheque page
     */
    public String navigateCobroChequeList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CobroCheque_items", this.getSelected().getCobroChequeList());
        }
        return "/cobroCheque/index";
    }

    /**
     * Sets the "items" attribute with a collection of CobroTarjeta entities
     * that are retrieved from CobroDet?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CobroTarjeta page
     */
    public String navigateCobroTarjetaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CobroTarjeta_items", this.getSelected().getCobroTarjetaList());
        }
        return "/cobroTarjeta/index";
    }


}
