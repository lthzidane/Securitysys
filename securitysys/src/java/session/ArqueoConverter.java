package session;

import entities.Arqueo;
import bean.ArqueoFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "arqueoConverter")
public class ArqueoConverter implements Converter {

    @Inject
    private ArqueoFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.ArqueoPK getKey(String value) {
        entities.ArqueoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.ArqueoPK();
        key.setIdArqueo(Integer.parseInt(values[0]));
        key.setIdValor(Integer.parseInt(values[1]));
        key.setIdAperturaCierre(Integer.parseInt(values[2]));
        return key;
    }

    String getStringKey(entities.ArqueoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdArqueo());
        sb.append(SEPARATOR);
        sb.append(value.getIdValor());
        sb.append(SEPARATOR);
        sb.append(value.getIdAperturaCierre());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Arqueo) {
            Arqueo o = (Arqueo) object;
            return getStringKey(o.getArqueoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Arqueo.class.getName()});
            return null;
        }
    }

}
