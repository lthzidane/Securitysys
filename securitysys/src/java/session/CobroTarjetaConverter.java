package session;

import entities.CobroTarjeta;
import bean.CobroTarjetaFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "cobroTarjetaConverter")
public class CobroTarjetaConverter implements Converter {

    @Inject
    private CobroTarjetaFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.CobroTarjetaPK getKey(String value) {
        entities.CobroTarjetaPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.CobroTarjetaPK();
        key.setIdCobroTarjeta(Integer.parseInt(values[0]));
        key.setIdCobro(Integer.parseInt(values[1]));
        key.setIdCtaACobrar(Integer.parseInt(values[2]));
        key.setIdVenta(Integer.parseInt(values[3]));
        return key;
    }

    String getStringKey(entities.CobroTarjetaPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdCobroTarjeta());
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
        if (object instanceof CobroTarjeta) {
            CobroTarjeta o = (CobroTarjeta) object;
            return getStringKey(o.getCobroTarjetaPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CobroTarjeta.class.getName()});
            return null;
        }
    }

}
