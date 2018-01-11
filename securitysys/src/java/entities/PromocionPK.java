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
public class PromocionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_promocion")
    private int idPromocion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presu")
    private int idPresu;

    public PromocionPK() {
    }

    public PromocionPK(int idPromocion, int idPresu) {
        this.idPromocion = idPromocion;
        this.idPresu = idPresu;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public int getIdPresu() {
        return idPresu;
    }

    public void setIdPresu(int idPresu) {
        this.idPresu = idPresu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPromocion;
        hash += (int) idPresu;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionPK)) {
            return false;
        }
        PromocionPK other = (PromocionPK) object;
        if (this.idPromocion != other.idPromocion) {
            return false;
        }
        if (this.idPresu != other.idPresu) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PromocionPK[ idPromocion=" + idPromocion + ", idPresu=" + idPresu + " ]";
    }
    
}
