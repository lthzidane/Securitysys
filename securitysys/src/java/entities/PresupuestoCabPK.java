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
public class PresupuestoCabPK implements Serializable {
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

    public PresupuestoCabPK() {
    }

    public PresupuestoCabPK(String tipoPresupuesto, String serPresupuesto, BigInteger nroPresupuesto) {
        this.tipoPresupuesto = tipoPresupuesto;
        this.serPresupuesto = serPresupuesto;
        this.nroPresupuesto = nroPresupuesto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPresupuesto != null ? tipoPresupuesto.hashCode() : 0);
        hash += (serPresupuesto != null ? serPresupuesto.hashCode() : 0);
        hash += (nroPresupuesto != null ? nroPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoCabPK)) {
            return false;
        }
        PresupuestoCabPK other = (PresupuestoCabPK) object;
        if ((this.tipoPresupuesto == null && other.tipoPresupuesto != null) || (this.tipoPresupuesto != null && !this.tipoPresupuesto.equals(other.tipoPresupuesto))) {
            return false;
        }
        if ((this.serPresupuesto == null && other.serPresupuesto != null) || (this.serPresupuesto != null && !this.serPresupuesto.equals(other.serPresupuesto))) {
            return false;
        }
        if ((this.nroPresupuesto == null && other.nroPresupuesto != null) || (this.nroPresupuesto != null && !this.nroPresupuesto.equals(other.nroPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PresupuestoCabPK[ tipoPresupuesto=" + tipoPresupuesto + ", serPresupuesto=" + serPresupuesto + ", nroPresupuesto=" + nroPresupuesto + " ]";
    }
    
}
