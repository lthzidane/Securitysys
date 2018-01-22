/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author expsee
 */
@Embeddable
public class LibroVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_libro_venta")
    private int idLibroVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_venta")
    private int idVenta;

    public LibroVentaPK() {
    }

    public LibroVentaPK(int idLibroVenta, int idVenta) {
        this.idLibroVenta = idLibroVenta;
        this.idVenta = idVenta;
    }

    public int getIdLibroVenta() {
        return idLibroVenta;
    }

    public void setIdLibroVenta(int idLibroVenta) {
        this.idLibroVenta = idLibroVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLibroVenta;
        hash += (int) idVenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroVentaPK)) {
            return false;
        }
        LibroVentaPK other = (LibroVentaPK) object;
        if (this.idLibroVenta != other.idLibroVenta) {
            return false;
        }
        if (this.idVenta != other.idVenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LibroVentaPK[ idLibroVenta=" + idLibroVenta + ", idVenta=" + idVenta + " ]";
    }
    
}
