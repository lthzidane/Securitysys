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
public class SolicitudDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitud_cab")
    private int idSolicitudCab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public SolicitudDetPK() {
    }

    public SolicitudDetPK(int idSolicitudCab, int idSecuencia) {
        this.idSolicitudCab = idSolicitudCab;
        this.idSecuencia = idSecuencia;
    }

    public int getIdSolicitudCab() {
        return idSolicitudCab;
    }

    public void setIdSolicitudCab(int idSolicitudCab) {
        this.idSolicitudCab = idSolicitudCab;
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
        hash += (int) idSolicitudCab;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudDetPK)) {
            return false;
        }
        SolicitudDetPK other = (SolicitudDetPK) object;
        if (this.idSolicitudCab != other.idSolicitudCab) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SolicitudDetPK[ idSolicitudCab=" + idSolicitudCab + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
