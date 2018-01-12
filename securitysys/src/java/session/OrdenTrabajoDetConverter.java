package session;

import entities.OrdenTrabajoDet;
import bean.OrdenTrabajoDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "ordenTrabajoDetConverter")
public class OrdenTrabajoDetConverter implements Converter {

    @Inject
    private OrdenTrabajoDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.OrdenTrabajoDetPK getKey(String value) {
        entities.OrdenTrabajoDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.OrdenTrabajoDetPK();
        key.setIdOrdenTrabajo(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.OrdenTrabajoDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdOrdenTrabajo());
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
        if (object instanceof OrdenTrabajoDet) {
            OrdenTrabajoDet o = (OrdenTrabajoDet) object;
            return getStringKey(o.getOrdenTrabajoDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OrdenTrabajoDet.class.getName()});
            return null;
        }
    }

}
