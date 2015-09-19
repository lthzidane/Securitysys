/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author LOTHAR
 */
@Embeddable
public class OrdenCompraDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_orden_compra")
    private String tipoOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ser_orden_compra")
    private String serOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_orden_compra")
    private BigInteger nroOrdenCompra;

    public OrdenCompraDetPK() {
    }

    public OrdenCompraDetPK(String tipoOrdenCompra, String serOrdenCompra, BigInteger nroOrdenCompra) {
        this.tipoOrdenCompra = tipoOrdenCompra;
        this.serOrdenCompra = serOrdenCompra;
        this.nroOrdenCompra = nroOrdenCompra;
    }

    public String getTipoOrdenCompra() {
        return tipoOrdenCompra;
    }

    public void setTipoOrdenCompra(String tipoOrdenCompra) {
        this.tipoOrdenCompra = tipoOrdenCompra;
    }

    public String getSerOrdenCompra() {
        return serOrdenCompra;
    }

    public void setSerOrdenCompra(String serOrdenCompra) {
        this.serOrdenCompra = serOrdenCompra;
    }

    public BigInteger getNroOrdenCompra() {
        return nroOrdenCompra;
    }

    public void setNroOrdenCompra(BigInteger nroOrdenCompra) {
        this.nroOrdenCompra = nroOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoOrdenCompra != null ? tipoOrdenCompra.hashCode() : 0);
        hash += (serOrdenCompra != null ? serOrdenCompra.hashCode() : 0);
        hash += (nroOrdenCompra != null ? nroOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraDetPK)) {
            return false;
        }
        OrdenCompraDetPK other = (OrdenCompraDetPK) object;
        if ((this.tipoOrdenCompra == null && other.tipoOrdenCompra != null) || (this.tipoOrdenCompra != null && !this.tipoOrdenCompra.equals(other.tipoOrdenCompra))) {
            return false;
        }
        if ((this.serOrdenCompra == null && other.serOrdenCompra != null) || (this.serOrdenCompra != null && !this.serOrdenCompra.equals(other.serOrdenCompra))) {
            return false;
        }
        if ((this.nroOrdenCompra == null && other.nroOrdenCompra != null) || (this.nroOrdenCompra != null && !this.nroOrdenCompra.equals(other.nroOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenCompraDetPK[ tipoOrdenCompra=" + tipoOrdenCompra + ", serOrdenCompra=" + serOrdenCompra + ", nroOrdenCompra=" + nroOrdenCompra + " ]";
    }
    
}
