/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Acer
 */
@Entity
@Table(name = "subtipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subtipo.findAll", query = "SELECT s FROM Subtipo s"),
    @NamedQuery(name = "Subtipo.findByIdSubtipo", query = "SELECT s FROM Subtipo s WHERE s.idSubtipo = :idSubtipo"),
    @NamedQuery(name = "Subtipo.findBySubtipo", query = "SELECT s FROM Subtipo s WHERE s.subtipo = :subtipo")})
public class Subtipo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_subtipo")
    private BigDecimal idSubtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "subtipo")
    private String subtipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubtipo")
    private List<Reclamo> reclamoList;
    @JoinColumn(name = "id_tiporecla", referencedColumnName = "id_tiporecla")
    @ManyToOne(optional = false)
    private Tiporeclamo idTiporecla;

    public Subtipo() {
    }

    public Subtipo(BigDecimal idSubtipo) {
        this.idSubtipo = idSubtipo;
    }

    public Subtipo(BigDecimal idSubtipo, String subtipo) {
        this.idSubtipo = idSubtipo;
        this.subtipo = subtipo;
    }

    public BigDecimal getIdSubtipo() {
        return idSubtipo;
    }

    public void setIdSubtipo(BigDecimal idSubtipo) {
        this.idSubtipo = idSubtipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    @XmlTransient
    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    public Tiporeclamo getIdTiporecla() {
        return idTiporecla;
    }

    public void setIdTiporecla(Tiporeclamo idTiporecla) {
        this.idTiporecla = idTiporecla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubtipo != null ? idSubtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subtipo)) {
            return false;
        }
        Subtipo other = (Subtipo) object;
        if ((this.idSubtipo == null && other.idSubtipo != null) || (this.idSubtipo != null && !this.idSubtipo.equals(other.idSubtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Subtipo[ idSubtipo=" + idSubtipo + " ]";
    }
    
}
