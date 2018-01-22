/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "diagnostico_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiagnosticoDet.findAll", query = "SELECT d FROM DiagnosticoDet d")
    , @NamedQuery(name = "DiagnosticoDet.findByIdDiagnostico", query = "SELECT d FROM DiagnosticoDet d WHERE d.diagnosticoDetPK.idDiagnostico = :idDiagnostico")
    , @NamedQuery(name = "DiagnosticoDet.findByIdSecuencia", query = "SELECT d FROM DiagnosticoDet d WHERE d.diagnosticoDetPK.idSecuencia = :idSecuencia")
    , @NamedQuery(name = "DiagnosticoDet.findByDetalle", query = "SELECT d FROM DiagnosticoDet d WHERE d.detalle = :detalle")})
public class DiagnosticoDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticoDetPK diagnosticoDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diagnostico diagnostico;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;

    public DiagnosticoDet() {
    }

    public DiagnosticoDet(DiagnosticoDetPK diagnosticoDetPK) {
        this.diagnosticoDetPK = diagnosticoDetPK;
    }

    public DiagnosticoDet(DiagnosticoDetPK diagnosticoDetPK, String detalle) {
        this.diagnosticoDetPK = diagnosticoDetPK;
        this.detalle = detalle;
    }

    public DiagnosticoDet(int idDiagnostico, int idSecuencia) {
        this.diagnosticoDetPK = new DiagnosticoDetPK(idDiagnostico, idSecuencia);
    }

    public DiagnosticoDetPK getDiagnosticoDetPK() {
        return diagnosticoDetPK;
    }

    public void setDiagnosticoDetPK(DiagnosticoDetPK diagnosticoDetPK) {
        this.diagnosticoDetPK = diagnosticoDetPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoDetPK != null ? diagnosticoDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticoDet)) {
            return false;
        }
        DiagnosticoDet other = (DiagnosticoDet) object;
        if ((this.diagnosticoDetPK == null && other.diagnosticoDetPK != null) || (this.diagnosticoDetPK != null && !this.diagnosticoDetPK.equals(other.diagnosticoDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DiagnosticoDet[ diagnosticoDetPK=" + diagnosticoDetPK + " ]";
    }
    
}
