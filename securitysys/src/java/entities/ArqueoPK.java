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
public class ArqueoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_arqueo")
    private int idArqueo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_valor")
    private int idValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_apertura_cierre")
    private int idAperturaCierre;

    public ArqueoPK() {
    }

    public ArqueoPK(int idArqueo, int idValor, int idAperturaCierre) {
        this.idArqueo = idArqueo;
        this.idValor = idValor;
        this.idAperturaCierre = idAperturaCierre;
    }

    public int getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(int idArqueo) {
        this.idArqueo = idArqueo;
    }

    public int getIdValor() {
        return idValor;
    }

    public void setIdValor(int idValor) {
        this.idValor = idValor;
    }

    public int getIdAperturaCierre() {
        return idAperturaCierre;
    }

    public void setIdAperturaCierre(int idAperturaCierre) {
        this.idAperturaCierre = idAperturaCierre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArqueo;
        hash += (int) idValor;
        hash += (int) idAperturaCierre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArqueoPK)) {
            return false;
        }
        ArqueoPK other = (ArqueoPK) object;
        if (this.idArqueo != other.idArqueo) {
            return false;
        }
        if (this.idValor != other.idValor) {
            return false;
        }
        if (this.idAperturaCierre != other.idAperturaCierre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ArqueoPK[ idArqueo=" + idArqueo + ", idValor=" + idValor + ", idAperturaCierre=" + idAperturaCierre + " ]";
    }
    
}
