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
public class PromocionDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_promocion_cab")
    private int idPromocionCab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public PromocionDetPK() {
    }

    public PromocionDetPK(int idPromocionCab, int idSecuencia) {
        this.idPromocionCab = idPromocionCab;
        this.idSecuencia = idSecuencia;
    }

    public int getIdPromocionCab() {
        return idPromocionCab;
    }

    public void setIdPromocionCab(int idPromocionCab) {
        this.idPromocionCab = idPromocionCab;
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
        hash += (int) idPromocionCab;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionDetPK)) {
            return false;
        }
        PromocionDetPK other = (PromocionDetPK) object;
        if (this.idPromocionCab != other.idPromocionCab) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PromocionDetPK[ idPromocionCab=" + idPromocionCab + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
