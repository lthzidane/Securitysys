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
public class RecaudacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_recaudacion")
    private int idRecaudacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_forma_cobro")
    private int idFormaCobro;

    public RecaudacionPK() {
    }

    public RecaudacionPK(int idRecaudacion, int idFormaCobro) {
        this.idRecaudacion = idRecaudacion;
        this.idFormaCobro = idFormaCobro;
    }

    public int getIdRecaudacion() {
        return idRecaudacion;
    }

    public void setIdRecaudacion(int idRecaudacion) {
        this.idRecaudacion = idRecaudacion;
    }

    public int getIdFormaCobro() {
        return idFormaCobro;
    }

    public void setIdFormaCobro(int idFormaCobro) {
        this.idFormaCobro = idFormaCobro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRecaudacion;
        hash += (int) idFormaCobro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecaudacionPK)) {
            return false;
        }
        RecaudacionPK other = (RecaudacionPK) object;
        if (this.idRecaudacion != other.idRecaudacion) {
            return false;
        }
        if (this.idFormaCobro != other.idFormaCobro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RecaudacionPK[ idRecaudacion=" + idRecaudacion + ", idFormaCobro=" + idFormaCobro + " ]";
    }
    
}
