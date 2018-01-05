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
public class VentasDetPK implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_secuencia")
    private BigInteger nroSecuencia;

    public VentasDetPK() {
    }

    public VentasDetPK(String tipoComprobante, String serComprobante, BigInteger nroComprobante, BigInteger nroSecuencia) {
        this.tipoComprobante = tipoComprobante;
        this.serComprobante = serComprobante;
        this.nroComprobante = nroComprobante;
        this.nroSecuencia = nroSecuencia;
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

    public BigInteger getNroSecuencia() {
        return nroSecuencia;
    }

    public void setNroSecuencia(BigInteger nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoComprobante != null ? tipoComprobante.hashCode() : 0);
        hash += (serComprobante != null ? serComprobante.hashCode() : 0);
        hash += (nroComprobante != null ? nroComprobante.hashCode() : 0);
        hash += (nroSecuencia != null ? nroSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDetPK)) {
            return false;
        }
        VentasDetPK other = (VentasDetPK) object;
        if ((this.tipoComprobante == null && other.tipoComprobante != null) || (this.tipoComprobante != null && !this.tipoComprobante.equals(other.tipoComprobante))) {
            return false;
        }
        if ((this.serComprobante == null && other.serComprobante != null) || (this.serComprobante != null && !this.serComprobante.equals(other.serComprobante))) {
            return false;
        }
        if ((this.nroComprobante == null && other.nroComprobante != null) || (this.nroComprobante != null && !this.nroComprobante.equals(other.nroComprobante))) {
            return false;
        }
        if ((this.nroSecuencia == null && other.nroSecuencia != null) || (this.nroSecuencia != null && !this.nroSecuencia.equals(other.nroSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentasDetPK[ tipoComprobante=" + tipoComprobante + ", serComprobante=" + serComprobante + ", nroComprobante=" + nroComprobante + ", nroSecuencia=" + nroSecuencia + " ]";
    }
    
}
