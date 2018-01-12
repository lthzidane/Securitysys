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
 * @author sebas
 */
@Entity
@Table(name = "instalacion_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstalacionDet.findAll", query = "SELECT i FROM InstalacionDet i"),
    @NamedQuery(name = "InstalacionDet.findByIdInstalacion", query = "SELECT i FROM InstalacionDet i WHERE i.instalacionDetPK.idInstalacion = :idInstalacion"),
    @NamedQuery(name = "InstalacionDet.findByIdSecuencia", query = "SELECT i FROM InstalacionDet i WHERE i.instalacionDetPK.idSecuencia = :idSecuencia"),
    @NamedQuery(name = "InstalacionDet.findByDetalle", query = "SELECT i FROM InstalacionDet i WHERE i.detalle = :detalle")})
public class InstalacionDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstalacionDetPK instalacionDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_instalacion", referencedColumnName = "id_instalacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private InstalacionCab instalacionCab;

    public InstalacionDet() {
    }

    public InstalacionDet(InstalacionDetPK instalacionDetPK) {
        this.instalacionDetPK = instalacionDetPK;
    }

    public InstalacionDet(InstalacionDetPK instalacionDetPK, String detalle) {
        this.instalacionDetPK = instalacionDetPK;
        this.detalle = detalle;
    }

    public InstalacionDet(int idInstalacion, int idSecuencia) {
        this.instalacionDetPK = new InstalacionDetPK(idInstalacion, idSecuencia);
    }

    public InstalacionDetPK getInstalacionDetPK() {
        return instalacionDetPK;
    }

    public void setInstalacionDetPK(InstalacionDetPK instalacionDetPK) {
        this.instalacionDetPK = instalacionDetPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public InstalacionCab getInstalacionCab() {
        return instalacionCab;
    }

    public void setInstalacionCab(InstalacionCab instalacionCab) {
        this.instalacionCab = instalacionCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instalacionDetPK != null ? instalacionDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionDet)) {
            return false;
        }
        InstalacionDet other = (InstalacionDet) object;
        if ((this.instalacionDetPK == null && other.instalacionDetPK != null) || (this.instalacionDetPK != null && !this.instalacionDetPK.equals(other.instalacionDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InstalacionDet[ instalacionDetPK=" + instalacionDetPK + " ]";
    }
    
}
