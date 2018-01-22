/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "tipo_reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReclamo.findAll", query = "SELECT t FROM TipoReclamo t")
    , @NamedQuery(name = "TipoReclamo.findByIdTipoReclamo", query = "SELECT t FROM TipoReclamo t WHERE t.idTipoReclamo = :idTipoReclamo")
    , @NamedQuery(name = "TipoReclamo.findByDescripcion", query = "SELECT t FROM TipoReclamo t WHERE t.descripcion = :descripcion")})
public class TipoReclamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_reclamo")
    private Integer idTipoReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoReclamo")
    private List<Reclamo> reclamoList;

    public TipoReclamo() {
    }

    public TipoReclamo(Integer idTipoReclamo) {
        this.idTipoReclamo = idTipoReclamo;
    }

    public TipoReclamo(Integer idTipoReclamo, String descripcion) {
        this.idTipoReclamo = idTipoReclamo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoReclamo() {
        return idTipoReclamo;
    }

    public void setIdTipoReclamo(Integer idTipoReclamo) {
        this.idTipoReclamo = idTipoReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoReclamo != null ? idTipoReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReclamo)) {
            return false;
        }
        TipoReclamo other = (TipoReclamo) object;
        if ((this.idTipoReclamo == null && other.idTipoReclamo != null) || (this.idTipoReclamo != null && !this.idTipoReclamo.equals(other.idTipoReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoReclamo[ idTipoReclamo=" + idTipoReclamo + " ]";
    }
    
}
