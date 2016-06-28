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
public class PresupuestoDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tipo_presupuesto")
    private String tipoPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ser_presupuesto")
    private String serPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_presupuesto")
    private BigInteger nroPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_secuencia")
    private BigInteger nroSecuencia;

    public PresupuestoDetPK() {
    }

    public PresupuestoDetPK(String tipoPresupuesto, String serPresupuesto, BigInteger nroPresupuesto, BigInteger nroSecuencia) {
        this.tipoPresupuesto = tipoPresupuesto;
        this.serPresupuesto = serPresupuesto;
        this.nroPresupuesto = nroPresupuesto;
        this.nroSecuencia = nroSecuencia;
    }

    public String getTipoPresupuesto() {
        return tipoPresupuesto;
    }

    public void setTipoPresupuesto(String tipoPresupuesto) {
        this.tipoPresupuesto = tipoPresupuesto;
    }

    public String getSerPresupuesto() {
        return serPresupuesto;
    }

    public void setSerPresupuesto(String serPresupuesto) {
        this.serPresupuesto = serPresupuesto;
    }

    public BigInteger getNroPresupuesto() {
        return nroPresupuesto;
    }

    public void setNroPresupuesto(BigInteger nroPresupuesto) {
        this.nroPresupuesto = nroPresupuesto;
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
        hash += (tipoPresupuesto != null ? tipoPresupuesto.hashCode() : 0);
        hash += (serPresupuesto != null ? serPresupuesto.hashCode() : 0);
        hash += (nroPresupuesto != null ? nroPresupuesto.hashCode() : 0);
        hash += (nroSecuencia != null ? nroSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoDetPK)) {
            return false;
        }
        PresupuestoDetPK other = (PresupuestoDetPK) object;
        if ((this.tipoPresupuesto == null && other.tipoPresupuesto != null) || (this.tipoPresupuesto != null && !this.tipoPresupuesto.equals(other.tipoPresupuesto))) {
            return false;
        }
        if ((this.serPresupuesto == null && other.serPresupuesto != null) || (this.serPresupuesto != null && !this.serPresupuesto.equals(other.serPresupuesto))) {
            return false;
        }
        if ((this.nroPresupuesto == null && other.nroPresupuesto != null) || (this.nroPresupuesto != null && !this.nroPresupuesto.equals(other.nroPresupuesto))) {
            return false;
        }
        if ((this.nroSecuencia == null && other.nroSecuencia != null) || (this.nroSecuencia != null && !this.nroSecuencia.equals(other.nroSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PresupuestoDetPK[ tipoPresupuesto=" + tipoPresupuesto + ", serPresupuesto=" + serPresupuesto + ", nroPresupuesto=" + nroPresupuesto + ", nroSecuencia=" + nroSecuencia + " ]";
    }
    
}
