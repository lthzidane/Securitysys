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
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Acer
 */
@Entity
@Table(name = "estado_trab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoTrab.findAll", query = "SELECT e FROM EstadoTrab e"),
    @NamedQuery(name = "EstadoTrab.findByIdEstadoTrab", query = "SELECT e FROM EstadoTrab e WHERE e.idEstadoTrab = :idEstadoTrab"),
    @NamedQuery(name = "EstadoTrab.findByEstado", query = "SELECT e FROM EstadoTrab e WHERE e.estado = :estado")})
public class EstadoTrab implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_trab")
    private BigDecimal idEstadoTrab;
    @Size(max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idEstadoTrab")
    private List<OrdenTrabajoCab> ordenTrabajoCabList;

    public EstadoTrab() {
    }

    public EstadoTrab(BigDecimal idEstadoTrab) {
        this.idEstadoTrab = idEstadoTrab;
    }

    public BigDecimal getIdEstadoTrab() {
        return idEstadoTrab;
    }

    public void setIdEstadoTrab(BigDecimal idEstadoTrab) {
        this.idEstadoTrab = idEstadoTrab;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<OrdenTrabajoCab> getOrdenTrabajoCabList() {
        return ordenTrabajoCabList;
    }

    public void setOrdenTrabajoCabList(List<OrdenTrabajoCab> ordenTrabajoCabList) {
        this.ordenTrabajoCabList = ordenTrabajoCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoTrab != null ? idEstadoTrab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTrab)) {
            return false;
        }
        EstadoTrab other = (EstadoTrab) object;
        if ((this.idEstadoTrab == null && other.idEstadoTrab != null) || (this.idEstadoTrab != null && !this.idEstadoTrab.equals(other.idEstadoTrab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EstadoTrab[ idEstadoTrab=" + idEstadoTrab + " ]";
    }
    
}
