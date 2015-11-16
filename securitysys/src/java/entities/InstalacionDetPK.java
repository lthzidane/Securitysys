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
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author LOTHAR
 */
@Embeddable
public class InstalacionDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_instalacion")
    private BigInteger idInstalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_linea")
    private BigInteger nroLinea;

    public InstalacionDetPK() {
    }

    public InstalacionDetPK(BigInteger idInstalacion, BigInteger nroLinea) {
        this.idInstalacion = idInstalacion;
        this.nroLinea = nroLinea;
    }

    public BigInteger getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(BigInteger idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public BigInteger getNroLinea() {
        return nroLinea;
    }

    public void setNroLinea(BigInteger nroLinea) {
        this.nroLinea = nroLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalacion != null ? idInstalacion.hashCode() : 0);
        hash += (nroLinea != null ? nroLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionDetPK)) {
            return false;
        }
        InstalacionDetPK other = (InstalacionDetPK) object;
        if ((this.idInstalacion == null && other.idInstalacion != null) || (this.idInstalacion != null && !this.idInstalacion.equals(other.idInstalacion))) {
            return false;
        }
        if ((this.nroLinea == null && other.nroLinea != null) || (this.nroLinea != null && !this.nroLinea.equals(other.nroLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InstalacionDetPK[ idInstalacion=" + idInstalacion + ", nroLinea=" + nroLinea + " ]";
    }
    
}
