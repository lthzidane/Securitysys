package session;

import entities.DescuentoDet;
import bean.DescuentoDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "descuentoDetConverter")
public class DescuentoDetConverter implements Converter {

    @Inject
    private DescuentoDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.DescuentoDetPK getKey(String value) {
        entities.DescuentoDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.DescuentoDetPK();
        key.setIdDescuentoCab(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.DescuentoDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdDescuentoCab());
        sb.append(SEPARATOR);
        sb.append(value.getIdSecuencia());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof DescuentoDet) {
            DescuentoDet o = (DescuentoDet) object;
            return getStringKey(o.getDescuentoDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DescuentoDet.class.getName()});
            return null;
        }
    }

}
