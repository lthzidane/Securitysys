/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

public class Sale implements Serializable {
 
    private String nombreProducto;
 
    private int nroOrden;
 
    private int cantidad;
 
    private int precioUnitario;
 
    private int precioTotal;
 
    public Sale() {}
 
    public Sale(String nombreProducto, int nroOrden, int cantidad, int precioUnitario, int precioTotal) {
        this.nombreProducto = nombreProducto;
        this.nroOrden = nroOrden;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }
 
    public int getPrecioUnitario() {
        return precioUnitario;
    }
 
    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
 
    public int getNroOrden() {
        return nroOrden;
    }
 
    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }
 
    public String getNombreProducto() {
        return nombreProducto;
    }
 
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
 
    public int getPrecioTotal() {
        return precioTotal;
    }
 
    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
 
    public int getCantidad() {
        return cantidad;
    }
 
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
