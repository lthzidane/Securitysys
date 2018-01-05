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
 * @author sebas
 */
@Embeddable
public class VentasCabPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tipo_comprobante")
    private String tipoComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ser_comprobante")
    private String serComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_comprobante")
    private BigInteger nroComprobante;

    public VentasCabPK() {
    }

    public VentasCabPK(String tipoComprobante, String serComprobante, BigInteger nroComprobante) {
        this.tipoComprobante = tipoComprobante;
        this.serComprobante = serComprobante;
        this.nroComprobante = nroComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getSerComprobante() {
        return serComprobante;
    }

    public void setSerComprobante(String serComprobante) {
        this.serComprobante = serComprobante;
    }

    public BigInteger getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(BigInteger nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoComprobante != null ? tipoComprobante.hashCode() : 0);
        hash += (serComprobante != null ? serComprobante.hashCode() : 0);
        hash += (nroComprobante != null ? nroComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasCabPK)) {
            return false;
        }
        VentasCabPK other = (VentasCabPK) object;
        if ((this.tipoComprobante == null && other.tipoComprobante != null) || (this.tipoComprobante != null && !this.tipoComprobante.equals(other.tipoComprobante))) {
            return false;
        }
        if ((this.serComprobante == null && other.serComprobante != null) || (this.serComprobante != null && !this.serComprobante.equals(other.serComprobante))) {
            return false;
        }
        if ((this.nroComprobante == null && other.nroComprobante != null) || (this.nroComprobante != null && !this.nroComprobante.equals(other.nroComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentasCabPK[ tipoComprobante=" + tipoComprobante + ", serComprobante=" + serComprobante + ", nroComprobante=" + nroComprobante + " ]";
    }
    
}
