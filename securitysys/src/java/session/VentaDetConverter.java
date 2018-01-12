package session;

import entities.VentaDet;
import bean.VentaDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "ventaDetConverter")
public class VentaDetConverter implements Converter {

    @Inject
    private VentaDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entities.VentaDetPK getKey(String value) {
        entities.VentaDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.VentaDetPK();
        key.setIdVenta(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.VentaDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdVenta());
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
        if (object instanceof VentaDet) {
            VentaDet o = (VentaDet) object;
            return getStringKey(o.getVentaDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VentaDet.class.getName()});
            return null;
        }
    }

}
