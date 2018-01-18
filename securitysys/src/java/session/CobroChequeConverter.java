package session;

import entities.CobroCheque;
import bean.CobroChequeFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "cobroChequeConverter")
public class CobroChequeConverter implements Converter {

    private CobroChequeFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    entities.CobroChequePK getKey(String value) {
        entities.CobroChequePK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.CobroChequePK();
        key.setIdCobroCheque(Integer.parseInt(values[0]));
        key.setIdCobro(Integer.parseInt(values[1]));
        key.setIdCtaACobrar(Integer.parseInt(values[2]));
        key.setIdVenta(Integer.parseInt(values[3]));
        return key;
    }

    String getStringKey(entities.CobroChequePK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdCobroCheque());
        sb.append(SEPARATOR);
        sb.append(value.getIdCobro());
        sb.append(SEPARATOR);
        sb.append(value.getIdCtaACobrar());
        sb.append(SEPARATOR);
        sb.append(value.getIdVenta());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof CobroCheque) {
            CobroCheque o = (CobroCheque) object;
            return getStringKey(o.getCobroChequePK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CobroCheque.class.getName()});
            return null;
        }
    }

    private CobroChequeFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(CobroChequeFacade.class).get();
        return this.ejbFacade;
    }
}
