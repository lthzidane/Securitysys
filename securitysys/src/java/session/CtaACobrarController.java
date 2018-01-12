package session;

import entities.CtaACobrar;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "ctaACobrarController")
@ViewScoped
public class CtaACobrarController extends AbstractController<CtaACobrar> {

    @Inject
    private VentaController ventaController;

    public CtaACobrarController() {
        // Inform the Abstract parent controller of the concrete CtaACobrar Entity
        super(CtaACobrar.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCtaACobrarPK().setIdVenta(this.getSelected().getVenta().getIdVenta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCtaACobrarPK(new entities.CtaACobrarPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ventaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of CobroDet entities that
     * are retrieved from CtaACobrar?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CobroDet page
     */
    public String navigateCobroDetList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CobroDet_items", this.getSelected().getCobroDetList());
        }
        return "/cobroDet/index";
    }

    /**
     * Sets the "selected" attribute of the Venta controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareVenta(ActionEvent event) {
        if (this.getSelected() != null && ventaController.getSelected() == null) {
            ventaController.setSelected(this.getSelected().getVenta());
        }
    }

}
