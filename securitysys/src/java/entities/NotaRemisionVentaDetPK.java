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
public class NotaRemisionVentaDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_remision")
    private int idRemision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public NotaRemisionVentaDetPK() {
    }

    public NotaRemisionVentaDetPK(int idRemision, int idSecuencia) {
        this.idRemision = idRemision;
        this.idSecuencia = idSecuencia;
    }

    public int getIdRemision() {
        return idRemision;
    }

    public void setIdRemision(int idRemision) {
        this.idRemision = idRemision;
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
        hash += (int) idRemision;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaRemisionVentaDetPK)) {
            return false;
        }
        NotaRemisionVentaDetPK other = (NotaRemisionVentaDetPK) object;
        if (this.idRemision != other.idRemision) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotaRemisionVentaDetPK[ idRemision=" + idRemision + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
