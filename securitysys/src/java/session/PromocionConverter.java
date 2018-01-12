package session;

import entities.Promocion;
import bean.PromocionFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "promocionConverter")
public class PromocionConverter implements Converter {

    @Inject
    private PromocionFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.PromocionPK getKey(String value) {
        entities.PromocionPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.PromocionPK();
        key.setIdPromocion(Integer.parseInt(values[0]));
        key.setIdPresu(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.PromocionPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdPromocion());
        sb.append(SEPARATOR);
        sb.append(value.getIdPresu());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Promocion) {
            Promocion o = (Promocion) object;
            return getStringKey(o.getPromocionPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Promocion.class.getName()});
            return null;
        }
    }

}
