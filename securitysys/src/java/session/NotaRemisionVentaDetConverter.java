package session;

import entities.NotaRemisionVentaDet;
import bean.NotaRemisionVentaDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "notaRemisionVentaDetConverter")
public class NotaRemisionVentaDetConverter implements Converter {

    @Inject
    private NotaRemisionVentaDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.NotaRemisionVentaDetPK getKey(String value) {
        entities.NotaRemisionVentaDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.NotaRemisionVentaDetPK();
        key.setIdRemision(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.NotaRemisionVentaDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdRemision());
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
        if (object instanceof NotaRemisionVentaDet) {
            NotaRemisionVentaDet o = (NotaRemisionVentaDet) object;
            return getStringKey(o.getNotaRemisionVentaDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NotaRemisionVentaDet.class.getName()});
            return null;
        }
    }

}
