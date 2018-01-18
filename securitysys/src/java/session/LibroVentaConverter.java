package session;

import entities.LibroVenta;
import bean.LibroVentaFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "libroVentaConverter")
public class LibroVentaConverter implements Converter {

    private LibroVentaFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    entities.LibroVentaPK getKey(String value) {
        entities.LibroVentaPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.LibroVentaPK();
        key.setIdLibroVenta(Integer.parseInt(values[0]));
        key.setIdVenta(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.LibroVentaPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdLibroVenta());
        sb.append(SEPARATOR);
        sb.append(value.getIdVenta());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof LibroVenta) {
            LibroVenta o = (LibroVenta) object;
            return getStringKey(o.getLibroVentaPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LibroVenta.class.getName()});
            return null;
        }
    }

    private LibroVentaFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(LibroVentaFacade.class).get();
        return this.ejbFacade;
    }
}
