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
public class OrdenTrabajoDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_trabajo")
    private int idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public OrdenTrabajoDetPK() {
    }

    public OrdenTrabajoDetPK(int idOrdenTrabajo, int idSecuencia) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.idSecuencia = idSecuencia;
    }

    public int getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(int idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
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
        hash += (int) idOrdenTrabajo;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoDetPK)) {
            return false;
        }
        OrdenTrabajoDetPK other = (OrdenTrabajoDetPK) object;
        if (this.idOrdenTrabajo != other.idOrdenTrabajo) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenTrabajoDetPK[ idOrdenTrabajo=" + idOrdenTrabajo + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
