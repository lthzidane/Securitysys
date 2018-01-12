package session;

import entities.CtaACobrar;
import bean.CtaACobrarFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "ctaACobrarConverter")
public class CtaACobrarConverter implements Converter {

    @Inject
    private CtaACobrarFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.CtaACobrarPK getKey(String value) {
        entities.CtaACobrarPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.CtaACobrarPK();
        key.setIdCtaACobrar(Integer.parseInt(values[0]));
        key.setIdVenta(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.CtaACobrarPK value) {
        StringBuffer sb = new StringBuffer();
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
        if (object instanceof CtaACobrar) {
            CtaACobrar o = (CtaACobrar) object;
            return getStringKey(o.getCtaACobrarPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CtaACobrar.class.getName()});
            return null;
        }
    }

}
