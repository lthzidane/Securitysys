/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import entities.Venta;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author moreno
 */
@ManagedBean(name = "ReportesVentasBean")
@ViewScoped
@Data
public class ReportesVentasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(ReportesVentasBean.class.getName());

    private ArrayList<Venta> listaVenta = new ArrayList<>();
    private List<Venta> filteredVentas;

    private Date fromFecVent;
    private Date toFecVent;

    @EJB
    private bean.VentaFacade ventaFacade;

    private Venta venta;

    @PostConstruct
    void initialiseSession() {
        cargarTabRepoVenta();
    }

    public void cargarTabRepoVenta() {
        try {
            listaVenta = new ArrayList<>();
            for (Venta vent : ventaFacade.findAll()) {
                listaVenta.add(vent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException, ParseException {
        com.lowagie.text.Document pdf = (com.lowagie.text.Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.LEGAL.rotate());

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "Security.png";

        pdf.add(com.lowagie.text.Image.getInstance(logo));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

        if (fromFecVent != null && toFecVent != null) {
            String startDateToStr = format.format(fromFecVent);
            String stopDateToStr = format.format(toFecVent);
            pdf.add(new Paragraph("Ventas del " + startDateToStr + " hasta " + stopDateToStr));
        } else {
            pdf.add(new Paragraph("Todas los Ventas existentes"));
        }

        pdf.add(new Paragraph(" "));
    }

    public void filtrarFechasVent() {
        Date startDate = fromFecVent;
        Date endDate = toFecVent;

        if (startDate == null && endDate == null) {
            cargarTabRepoVenta();
        } else {
            listaVenta = new ArrayList<>();
            for (Venta rcl : ventaFacade.findBetweenfechaVenta(startDate, endDate)) {
                listaVenta.add(rcl);
            }
        }

    }

    public ArrayList<Venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(ArrayList<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public List<Venta> getFilteredVentas() {
        return filteredVentas;
    }

    public void setFilteredVentas(List<Venta> filteredVentas) {
        this.filteredVentas = filteredVentas;
    }

    public Date getFromFecVent() {
        return fromFecVent;
    }

    public void setFromFecVent(Date fromFecVent) {
        this.fromFecVent = fromFecVent;
    }

    public Date getToFecVent() {
        return toFecVent;
    }

    public void setToFecVent(Date toFecVent) {
        this.toFecVent = toFecVent;
    }

    public VentaFacade getVentaFacade() {
        return ventaFacade;
    }

    public void setVentaFacade(VentaFacade ventaFacade) {
        this.ventaFacade = ventaFacade;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

}
