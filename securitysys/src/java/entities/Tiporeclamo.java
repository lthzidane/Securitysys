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
@Table(name = "tiporeclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiporeclamo.findAll", query = "SELECT t FROM Tiporeclamo t"),
    @NamedQuery(name = "Tiporeclamo.findByIdTiporecla", query = "SELECT t FROM Tiporeclamo t WHERE t.idTiporecla = :idTiporecla"),
    @NamedQuery(name = "Tiporeclamo.findByTipo", query = "SELECT t FROM Tiporeclamo t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tiporeclamo.findByDescripcion", query = "SELECT t FROM Tiporeclamo t WHERE t.descripcion = :descripcion")})
public class Tiporeclamo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tiporecla")
    private BigDecimal idTiporecla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTiporecla")
    private List<Reclamo> reclamoList;
    @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")
    @ManyToOne(optional = false)
    private Departamento idDpto;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTiporecla")
    private List<Subtipo> subtipoList;

    public Tiporeclamo() {
    }

    public Tiporeclamo(BigDecimal idTiporecla) {
        this.idTiporecla = idTiporecla;
    }

    public Tiporeclamo(BigDecimal idTiporecla, String tipo, String descripcion) {
        this.idTiporecla = idTiporecla;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdTiporecla() {
        return idTiporecla;
    }

    public void setIdTiporecla(BigDecimal idTiporecla) {
        this.idTiporecla = idTiporecla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Departamento getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Departamento idDpto) {
        this.idDpto = idDpto;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<Subtipo> getSubtipoList() {
        return subtipoList;
    }

    public void setSubtipoList(List<Subtipo> subtipoList) {
        this.subtipoList = subtipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiporecla != null ? idTiporecla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporeclamo)) {
            return false;
        }
        Tiporeclamo other = (Tiporeclamo) object;
        if ((this.idTiporecla == null && other.idTiporecla != null) || (this.idTiporecla != null && !this.idTiporecla.equals(other.idTiporecla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tiporeclamo[ idTiporecla=" + idTiporecla + " ]";
    }
    
}
