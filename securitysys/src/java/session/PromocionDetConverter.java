package session;

import entities.PromocionDet;
import bean.PromocionDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "promocionDetConverter")
public class PromocionDetConverter implements Converter {

    @Inject
    private PromocionDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.PromocionDetPK getKey(String value) {
        entities.PromocionDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.PromocionDetPK();
        key.setIdPromocionCab(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.PromocionDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdPromocionCab());
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
        if (object instanceof PromocionDet) {
            PromocionDet o = (PromocionDet) object;
            return getStringKey(o.getPromocionDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PromocionDet.class.getName()});
            return null;
        }
    }

}
