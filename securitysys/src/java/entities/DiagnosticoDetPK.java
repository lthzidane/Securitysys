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
public class DiagnosticoDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_diagnostico")
    private int idDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_secuencia")
    private int idSecuencia;

    public DiagnosticoDetPK() {
    }

    public DiagnosticoDetPK(int idDiagnostico, int idSecuencia) {
        this.idDiagnostico = idDiagnostico;
        this.idSecuencia = idSecuencia;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
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
        hash += (int) idDiagnostico;
        hash += (int) idSecuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoDetPK)) {
            return false;
        }
        DiagnosticoDetPK other = (DiagnosticoDetPK) object;
        if (this.idDiagnostico != other.idDiagnostico) {
            return false;
        }
        if (this.idSecuencia != other.idSecuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DiagnosticoDetPK[ idDiagnostico=" + idDiagnostico + ", idSecuencia=" + idSecuencia + " ]";
    }
    
}
