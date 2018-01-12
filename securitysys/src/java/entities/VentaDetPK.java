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
 * @author sebas
 */
@Embeddable
public class VentaDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_venta")
    private int idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public VentaDetPK() {
    }

    public VentaDetPK(int idVenta, int idSecuencia) {
        this.idVenta = idVenta;
        this.idSecuencia = idSecuencia;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdSecuencia() {
        return idSecuencia;
    }

    public void setIdSecuencia(int idSecuencia) {
        this.idSecuencia = idSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVenta;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetPK)) {
            return false;
        }
        VentaDetPK other = (VentaDetPK) object;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentaDetPK[ idVenta=" + idVenta + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
