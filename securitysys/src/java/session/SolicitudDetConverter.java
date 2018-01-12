package session;

import entities.SolicitudDet;
import bean.SolicitudDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "solicitudDetConverter")
public class SolicitudDetConverter implements Converter {

    @Inject
    private SolicitudDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.SolicitudDetPK getKey(String value) {
        entities.SolicitudDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.SolicitudDetPK();
        key.setIdSolicitudCab(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.SolicitudDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdSolicitudCab());
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
        if (object instanceof SolicitudDet) {
            SolicitudDet o = (SolicitudDet) object;
            return getStringKey(o.getSolicitudDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SolicitudDet.class.getName()});
            return null;
        }
    }

}
