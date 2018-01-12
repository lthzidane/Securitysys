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
public class NotaCrediDebiVentaDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nota_venta")
    private int idNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public NotaCrediDebiVentaDetPK() {
    }

    public NotaCrediDebiVentaDetPK(int idNotaVenta, int idSecuencia) {
        this.idNotaVenta = idNotaVenta;
        this.idSecuencia = idSecuencia;
    }

    public int getIdNotaVenta() {
        return idNotaVenta;
    }

    public void setIdNotaVenta(int idNotaVenta) {
        this.idNotaVenta = idNotaVenta;
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
        hash += (int) idNotaVenta;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCrediDebiVentaDetPK)) {
            return false;
        }
        NotaCrediDebiVentaDetPK other = (NotaCrediDebiVentaDetPK) object;
        if (this.idNotaVenta != other.idNotaVenta) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotaCrediDebiVentaDetPK[ idNotaVenta=" + idNotaVenta + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
