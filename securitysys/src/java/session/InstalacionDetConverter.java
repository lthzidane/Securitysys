package session;

import entities.InstalacionDet;
import bean.InstalacionDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "instalacionDetConverter")
public class InstalacionDetConverter implements Converter {

    @Inject
    private InstalacionDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.InstalacionDetPK getKey(String value) {
        entities.InstalacionDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.InstalacionDetPK();
        key.setIdInstalacion(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.InstalacionDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdInstalacion());
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
        if (object instanceof InstalacionDet) {
            InstalacionDet o = (InstalacionDet) object;
            return getStringKey(o.getInstalacionDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InstalacionDet.class.getName()});
            return null;
        }
    }

}
