/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "instalacion_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstalacionCab.findAll", query = "SELECT i FROM InstalacionCab i"),
    @NamedQuery(name = "InstalacionCab.findByIdInstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.idInstalacion = :idInstalacion"),
    @NamedQuery(name = "InstalacionCab.findByTipoInstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.tipoInstalacion = :tipoInstalacion"),
    @NamedQuery(name = "InstalacionCab.findByFechaInicio", query = "SELECT i FROM InstalacionCab i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "InstalacionCab.findByFechaFin", query = "SELECT i FROM InstalacionCab i WHERE i.fechaFin = :fechaFin"),
    @NamedQuery(name = "InstalacionCab.findByIdEstado", query = "SELECT i FROM InstalacionCab i WHERE i.idEstado = :idEstado"),
    @NamedQuery(name = "InstalacionCab.findByObservacion", query = "SELECT i FROM InstalacionCab i WHERE i.observacion = :observacion"),
    @NamedQuery(name = "InstalacionCab.findBetweenFechaInstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.fechaInicio BETWEEN :startDate AND :endDate")
})
public class InstalacionCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instalacion")
    private Integer idInstalacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_instalacion")
    private String tipoInstalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado")
    private int idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_ot", referencedColumnName = "id_ot")
    @ManyToOne(optional = false)
    private OrdenTrabajo idOt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instalacionCab")
    private List<InstalacionDet> instalacionDetList;

    public InstalacionCab() {
    }

    public InstalacionCab(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public InstalacionCab(Integer idInstalacion, String tipoInstalacion, Date fechaInicio, Date fechaFin, int idEstado, String observacion) {
        this.idInstalacion = idInstalacion;
        this.tipoInstalacion = tipoInstalacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idEstado = idEstado;
        this.observacion = observacion;
    }

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public OrdenTrabajo getIdOt() {
        return idOt;
    }

    public void setIdOt(OrdenTrabajo idOt) {
        this.idOt = idOt;
    }

    @XmlTransient
    public List<InstalacionDet> getInstalacionDetList() {
        return instalacionDetList;
    }

    public void setInstalacionDetList(List<InstalacionDet> instalacionDetList) {
        this.instalacionDetList = instalacionDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalacion != null ? idInstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionCab)) {
            return false;
        }
        InstalacionCab other = (InstalacionCab) object;
        if ((this.idInstalacion == null && other.idInstalacion != null) || (this.idInstalacion != null && !this.idInstalacion.equals(other.idInstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InstalacionCab[ idInstalacion=" + idInstalacion + " ]";
    }
    
}
