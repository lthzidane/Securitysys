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
public class InstalacionDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_instalacion")
    private int idInstalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public InstalacionDetPK() {
    }

    public InstalacionDetPK(int idInstalacion, int idSecuencia) {
        this.idInstalacion = idInstalacion;
        this.idSecuencia = idSecuencia;
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
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
        hash += (int) idInstalacion;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionDetPK)) {
            return false;
        }
        InstalacionDetPK other = (InstalacionDetPK) object;
        if (this.idInstalacion != other.idInstalacion) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InstalacionDetPK[ idInstalacion=" + idInstalacion + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
