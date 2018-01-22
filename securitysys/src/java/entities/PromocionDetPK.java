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
public class PromocionDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_promocion")
    private int idPromocion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public PromocionDetPK() {
    }

    public PromocionDetPK(int idPromocion, int idSecuencia) {
        this.idPromocion = idPromocion;
        this.idSecuencia = idSecuencia;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
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
        hash += (int) idPromocion;
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
        if (this.idPromocion != other.idPromocion) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PromocionDetPK[ idPromocion=" + idPromocion + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
