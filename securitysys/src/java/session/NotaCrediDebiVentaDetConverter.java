package session;

import entities.NotaCrediDebiVentaDet;
import bean.NotaCrediDebiVentaDetFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "notaCrediDebiVentaDetConverter")
public class NotaCrediDebiVentaDetConverter implements Converter {

    private NotaCrediDebiVentaDetFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    entities.NotaCrediDebiVentaDetPK getKey(String value) {
        entities.NotaCrediDebiVentaDetPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.NotaCrediDebiVentaDetPK();
        key.setIdNotaVenta(Integer.parseInt(values[0]));
        key.setIdSecuencia(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.NotaCrediDebiVentaDetPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdNotaVenta());
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
        if (object instanceof NotaCrediDebiVentaDet) {
            NotaCrediDebiVentaDet o = (NotaCrediDebiVentaDet) object;
            return getStringKey(o.getNotaCrediDebiVentaDetPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NotaCrediDebiVentaDet.class.getName()});
            return null;
        }
    }

    private NotaCrediDebiVentaDetFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(NotaCrediDebiVentaDetFacade.class).get();
        return this.ejbFacade;
    }
}
