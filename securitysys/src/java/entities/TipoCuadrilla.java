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
 * @author sebas
 */
@Entity
@Table(name = "tipo_cuadrilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuadrilla.findAll", query = "SELECT t FROM TipoCuadrilla t"),
    @NamedQuery(name = "TipoCuadrilla.findByIdTipoCuadrilla", query = "SELECT t FROM TipoCuadrilla t WHERE t.idTipoCuadrilla = :idTipoCuadrilla"),
    @NamedQuery(name = "TipoCuadrilla.findByDescripcion", query = "SELECT t FROM TipoCuadrilla t WHERE t.descripcion = :descripcion")})
public class TipoCuadrilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cuadrilla")
    private Integer idTipoCuadrilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCuadrilla")
    private List<Cuadrilla> cuadrillaList;

    public TipoCuadrilla() {
    }

    public TipoCuadrilla(Integer idTipoCuadrilla) {
        this.idTipoCuadrilla = idTipoCuadrilla;
    }

    public TipoCuadrilla(Integer idTipoCuadrilla, String descripcion) {
        this.idTipoCuadrilla = idTipoCuadrilla;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoCuadrilla() {
        return idTipoCuadrilla;
    }

    public void setIdTipoCuadrilla(Integer idTipoCuadrilla) {
        this.idTipoCuadrilla = idTipoCuadrilla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cuadrilla> getCuadrillaList() {
        return cuadrillaList;
    }

    public void setCuadrillaList(List<Cuadrilla> cuadrillaList) {
        this.cuadrillaList = cuadrillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCuadrilla != null ? idTipoCuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuadrilla)) {
            return false;
        }
        TipoCuadrilla other = (TipoCuadrilla) object;
        if ((this.idTipoCuadrilla == null && other.idTipoCuadrilla != null) || (this.idTipoCuadrilla != null && !this.idTipoCuadrilla.equals(other.idTipoCuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoCuadrilla[ idTipoCuadrilla=" + idTipoCuadrilla + " ]";
    }
    
}
