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
public class DescuentoDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_descuento_cab")
    private int idDescuentoCab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public DescuentoDetPK() {
    }

    public DescuentoDetPK(int idDescuentoCab, int idSecuencia) {
        this.idDescuentoCab = idDescuentoCab;
        this.idSecuencia = idSecuencia;
    }

    public int getIdDescuentoCab() {
        return idDescuentoCab;
    }

    public void setIdDescuentoCab(int idDescuentoCab) {
        this.idDescuentoCab = idDescuentoCab;
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
        hash += (int) idDescuentoCab;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoDetPK)) {
            return false;
        }
        DescuentoDetPK other = (DescuentoDetPK) object;
        if (this.idDescuentoCab != other.idDescuentoCab) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DescuentoDetPK[ idDescuentoCab=" + idDescuentoCab + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
