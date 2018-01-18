package session;

import entities.Recaudacion;
import bean.RecaudacionFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "recaudacionConverter")
public class RecaudacionConverter implements Converter {

    private RecaudacionFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    entities.RecaudacionPK getKey(String value) {
        entities.RecaudacionPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.RecaudacionPK();
        key.setIdRecaudacion(Integer.parseInt(values[0]));
        key.setIdFormaCobro(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.RecaudacionPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdRecaudacion());
        sb.append(SEPARATOR);
        sb.append(value.getIdFormaCobro());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Recaudacion) {
            Recaudacion o = (Recaudacion) object;
            return getStringKey(o.getRecaudacionPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Recaudacion.class.getName()});
            return null;
        }
    }

    private RecaudacionFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(RecaudacionFacade.class).get();
        return this.ejbFacade;
    }
}
