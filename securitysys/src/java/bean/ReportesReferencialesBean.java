/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import entities.Cliente;
import entities.Contrato;
import entities.Servicio;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import lombok.Data;

/**
 *
 * @author sebas
 */
@ManagedBean(name = "ReportesReferencialesBean")
@ViewScoped
@Data
public class ReportesReferencialesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Contrato> listaContratos = new ArrayList<>();

    private List<Cliente> listaRepoCliente = new ArrayList<>();

    private List<Servicio> listaRepoServicios = new ArrayList<>();

    private List<Contrato> filteredContrato;
    private List<Cliente> filteredCliente;
    private List<Servicio> filteredServicio;

    private static final Logger LOG = Logger.getLogger(ReportesReferencialesBean.class.getName());
    /**
     * String Base64 that represents the image bytes
     */

    @EJB
    private bean.ContratoFacade contratoFacade;
    @EJB
    private bean.ClienteFacade clienteFacade;

    @EJB
    private bean.ServicioFacade servicioFacade;

    @PostConstruct
    void initialiseSession() {
        cargarTabContrato();
        cargarTabCliente();
        cargarTabServicio();
    }

    public void cargarTabContrato() {
        try {
            setListaContratos(getContratoFacade().findAll());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cargarTabServicio() {
        try {
            setListaRepoServicios(getServicioFacade().findAll());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarTabCliente() {
        try {
            setListaRepoCliente(getClienteFacade().findAll());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException, ParseException {
        com.lowagie.text.Document pdf = (com.lowagie.text.Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4.rotate());

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "Security.png";

        pdf.add(com.lowagie.text.Image.getInstance(logo));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

        pdf.add(new Paragraph("Todos los registros existentes"));

        pdf.add(new Paragraph(" "));
    }

    public List<Contrato> getListaContratos() {
        return listaContratos;
    }

    public void setListaContratos(List<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public List<Cliente> getListaRepoCliente() {
        return listaRepoCliente;
    }

    public void setListaRepoCliente(List<Cliente> listaRepoCliente) {
        this.listaRepoCliente = listaRepoCliente;
    }

    public List<Servicio> getListaRepoServicios() {
        return listaRepoServicios;
    }

    public void setListaRepoServicios(List<Servicio> listaRepoServicios) {
        this.listaRepoServicios = listaRepoServicios;
    }

    public List<Contrato> getFilteredContrato() {
        return filteredContrato;
    }

    public void setFilteredContrato(List<Contrato> filteredContrato) {
        this.filteredContrato = filteredContrato;
    }

    public List<Cliente> getFilteredCliente() {
        return filteredCliente;
    }

    public void setFilteredCliente(List<Cliente> filteredCliente) {
        this.filteredCliente = filteredCliente;
    }

    public List<Servicio> getFilteredServicio() {
        return filteredServicio;
    }

    public void setFilteredServicio(List<Servicio> filteredServicio) {
        this.filteredServicio = filteredServicio;
    }

    public ContratoFacade getContratoFacade() {
        return contratoFacade;
    }

    public void setContratoFacade(ContratoFacade contratoFacade) {
        this.contratoFacade = contratoFacade;
    }

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public ServicioFacade getServicioFacade() {
        return servicioFacade;
    }

    public void setServicioFacade(ServicioFacade servicioFacade) {
        this.servicioFacade = servicioFacade;
    }

}
