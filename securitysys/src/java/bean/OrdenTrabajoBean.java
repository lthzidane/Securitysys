/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Data;
import util.Sale;

/**
 *
 * @author sebas
 */
@ManagedBean(name="OrdenTrabajoBean")
@ViewScoped
@Data
public class OrdenTrabajoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nroDeOrden;
    private String equipo; 
    private BigDecimal pedido;
    private String estado;
    private String description;
    private String fechaInicio;
    private String fechaFin;
    private String fechaRecepcion;
    private String tipoServicio;
    private String observacion;
    private String tecnico;
    private String cliente;
    private String ruc;
    private String razonsocial;
    private String direccion;
    private String telefono;
    
    private final static String[] nombreProducto;
    private List<Sale> detalleOC;
    
    static {
        nombreProducto = new String[10];
        nombreProducto[0] = "Apple";
        nombreProducto[1] = "Samsung";
        nombreProducto[2] = "Microsoft";
        nombreProducto[3] = "Philips";
        nombreProducto[4] = "Sony";
        nombreProducto[5] = "LG";
        nombreProducto[6] = "Sharp";
        nombreProducto[7] = "Panasonic";
        nombreProducto[8] = "HTC";
        nombreProducto[9] = "Nokia";
    }

    /**
     * @return the nombreProducto
     */
    public static String[] getNombreProducto() {
        return nombreProducto;
    }
    
    public OrdenTrabajoBean(){
    }

    @PostConstruct
    void initialiseSession() {
        this.cargarVista();
    }   
    
    
    public void cargarVista() {

        try {

            nroDeOrden = "0001";

            Date date = Calendar.getInstance().getTime();

        //
            // Display a date in day, month, year format
            //
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            fechaRecepcion = today;

            pedido = null;
            estado = "Pendiente";
            description = "";

        } catch (Exception ex) {
        }
    }

   
    public String guardarProducto(){
        FacesContext context = FacesContext.getCurrentInstance();
        String mensaje = "";
        
        context.addMessage(null, new FacesMessage("¡!", mensaje)); 
        
        if(mensaje.contains("Error")){
            return null;
        }
        
        return "Volver";
    }
    


    private int getRandomAmount() {
        return (int) (Math.random() * 10)+1;
    }
 
    private int getRandomPercentage() {
        return (int) (Math.random() * 100);
    }
    
    public String getLastYearTotal() {
        int total = 0;
 
        for(Sale sale : getDetalleOC()) {
            total += sale.getNroOrden();
        }
 
        return new DecimalFormat("###,###").format(total);
    }
 
    public String getOrdenCompraTotal() {
        int total = 0;
 
        for(Sale sale : getDetalleOC()) {
            total += sale.getPrecioTotal();
        }
 
        return new DecimalFormat("###,###").format(total);
    }
    
}
