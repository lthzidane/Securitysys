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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "tipo_movil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovil.findAll", query = "SELECT t FROM TipoMovil t"),
    @NamedQuery(name = "TipoMovil.findByIdTipoMovil", query = "SELECT t FROM TipoMovil t WHERE t.idTipoMovil = :idTipoMovil"),
    @NamedQuery(name = "TipoMovil.findByDescripcion", query = "SELECT t FROM TipoMovil t WHERE t.descripcion = :descripcion")})
public class TipoMovil implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMovil")
    private List<Moviles> movilesList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_movil")
    @GeneratedValue(generator = "TipMovSeq")
    @SequenceGenerator(name = "TipMovSeq", sequenceName = "tipo_movil_id_tipo_movil_seq", allocationSize = 1)
    private Integer idTipoMovil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoMovil() {
    }

    public TipoMovil(Integer idTipoMovil) {
        this.idTipoMovil = idTipoMovil;
    }

    public TipoMovil(Integer idTipoMovil, String descripcion) {
        this.idTipoMovil = idTipoMovil;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoMovil() {
        return idTipoMovil;
    }

    public void setIdTipoMovil(Integer idTipoMovil) {
        this.idTipoMovil = idTipoMovil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMovil != null ? idTipoMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovil)) {
            return false;
        }
        TipoMovil other = (TipoMovil) object;
        if ((this.idTipoMovil == null && other.idTipoMovil != null) || (this.idTipoMovil != null && !this.idTipoMovil.equals(other.idTipoMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoMovil[ idTipoMovil=" + idTipoMovil + " ]";
    }

    @XmlTransient
    public List<Moviles> getMovilesList() {
        return movilesList;
    }

    public void setMovilesList(List<Moviles> movilesList) {
        this.movilesList = movilesList;
    }

}
