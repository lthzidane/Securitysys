/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author acer
 */
@ManagedBean(name="OrdenCompraBean")
@ViewScoped
@Data
public class OrdenCompraBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nroDeOrden;
    private String proveedor; //CNDDI = Codigo No Dependiente Del Idioma
    private String language; //{ESN,ENU,FRA}
    private String orderBy; //Pedido
    private BigDecimal pedido;
    private boolean active;
    private boolean translate;
    private boolean multilingual;
    private String estado;
    private String description;
    private boolean editando = false;
    private String fechaPedido;
    private String fechaRecepcion;
    
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
    
    public OrdenCompraBean(){
    }

    
    
    
    @PostConstruct
    void initialiseSession() {
        this.cargarVista();
    }   
    
    
    public void cargarVista() {

        try {

            setDetalleOC(new ArrayList<Sale>());
            for (int i = 0; i < 10; i++) {
                
                int cant = getRandomAmount();
                int pUni = getRandomPercentage();
                getDetalleOC().add(new Sale(getNombreProducto()[i], 
                        i+1, 
                        cant, 
                        pUni, 
                        cant*pUni  ));
            }

            nroDeOrden = "0001";

            Date date = Calendar.getInstance().getTime();

        //
            // Display a date in day, month, year format
            //
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);
            fechaPedido = today;

            proveedor = ""; //CNDDI = Codigo No Dependiente Del Idioma
            language = "ESN"; //{ESN,ENU,FRA} por defecto Español
            orderBy = ""; //Pedido
            pedido = null;
            active = false;
            translate = false;
            multilingual = false;
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
        
        this.editando = false; //ya terminé de Editar o Guardar
        
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
