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
 * @author acer
 */
@Embeddable
public class PresupuestoDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presupuesto_cab")
    private int idPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public PresupuestoDetPK() {
    }

    public PresupuestoDetPK(int idPresupuesto, int idSecuencia) {
        this.idPresupuesto = idPresupuesto;
        this.idSecuencia = idSecuencia;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
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
        hash += (int) idPresupuesto;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoDetPK)) {
            return false;
        }
        PresupuestoDetPK other = (PresupuestoDetPK) object;
        if (this.idPresupuesto != other.idPresupuesto) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PresupuestoDetPK[ idPresupuesto=" + idPresupuesto + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
