/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import entities.Reclamo;
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

    private ArrayList<Reclamo> listaReclamo = new ArrayList<>();
    private List<Reclamo> filteredReclamos;

    private Date fromFecRecl;
    private Date toFecRecl;

    @EJB
    private bean.ReclamoFacade reclamoFacade;

    private Reclamo reclamo;

    @PostConstruct
    void initialiseSession() {
        cargarTabRepoReclamo();
    }

    public void cargarTabRepoReclamo() {
        try {
            listaReclamo = new ArrayList<>();
            for (Reclamo rcl : reclamoFacade.findAll()) {
                listaReclamo.add(rcl);
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
        String startDateToStr = format.format(fromFecRecl);
        String stopDateToStr = format.format(toFecRecl);

        if (fromFecRecl != null && toFecRecl != null) {
            pdf.add(new Paragraph("Reclamos del " + startDateToStr + " hasta " + stopDateToStr));
        } else {
            pdf.add(new Paragraph("Todas los Reclamos existentes"));
        }

        pdf.add(new Paragraph(" "));
    }

    public void filtrarFechasRecl() {
        Date startDate = fromFecRecl;
        Date endDate = toFecRecl;

        if (startDate == null && endDate == null) {
            cargarTabRepoReclamo();
        } else {
            listaReclamo = new ArrayList<>();
            for (Reclamo rcl : reclamoFacade.findBetweenfechaAlta(startDate, endDate)) {
                listaReclamo.add(rcl);
            }
        }

    }

}
