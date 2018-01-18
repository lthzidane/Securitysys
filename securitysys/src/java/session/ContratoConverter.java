package session;

import entities.Contrato;
import bean.ContratoFacade;
import session.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "contratoConverter")
public class ContratoConverter implements Converter {

    private ContratoFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    entities.ContratoPK getKey(String value) {
        entities.ContratoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entities.ContratoPK();
        key.setIdContrato(Integer.parseInt(values[0]));
        key.setIdCliente(Integer.parseInt(values[1]));
        return key;
    }

    String getStringKey(entities.ContratoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdContrato());
        sb.append(SEPARATOR);
        sb.append(value.getIdCliente());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Contrato) {
            Contrato o = (Contrato) object;
            return getStringKey(o.getContratoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Contrato.class.getName()});
            return null;
        }
    }

    private ContratoFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(ContratoFacade.class).get();
        return this.ejbFacade;
    }
}
