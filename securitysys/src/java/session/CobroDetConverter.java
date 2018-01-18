package session;

import entities.CobroDet;
import bean.CobroDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "cobroDetConverter")
public class CobroDetConverter implements Converter {

    private CobroDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    entities.CobroDetPK getKey(String value) {
        entities.CobroDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.CobroDetPK();
        key.setIdCobro(Integer.parseInt(values[0]));
        key.setIdCtaACobrar(Integer.parseInt(values[1]));
        key.setIdVenta(Integer.parseInt(values[2]));
        return key;
    }

    String getStringKey(entities.CobroDetPK value) {
        StringBuffer sb = new StringBuffer();
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
        if (object instanceof CobroDet) {
            CobroDet o = (CobroDet) object;
            return getStringKey(o.getCobroDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CobroDet.class.getName()});
            return null;
        }
    }

    private CobroDetFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(CobroDetFacade.class).get();
        return this.ejbFacade;
    }
}
