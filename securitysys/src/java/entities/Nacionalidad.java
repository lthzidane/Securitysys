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
@Table(name = "nacionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n")
    , @NamedQuery(name = "Nacionalidad.findByIdNacionalidad", query = "SELECT n FROM Nacionalidad n WHERE n.idNacionalidad = :idNacionalidad")
    , @NamedQuery(name = "Nacionalidad.findByDescripcion", query = "SELECT n FROM Nacionalidad n WHERE n.descripcion = :descripcion")})
public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nacionalidad")
    private Integer idNacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNacionalidad")
    private List<Cliente> clienteList;

    public Nacionalidad() {
    }

    public Nacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public Nacionalidad(Integer idNacionalidad, String descripcion) {
        this.idNacionalidad = idNacionalidad;
        this.descripcion = descripcion.toUpperCase();
    }

    public Integer getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(Integer idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNacionalidad != null ? idNacionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.idNacionalidad == null && other.idNacionalidad != null) || (this.idNacionalidad != null && !this.idNacionalidad.equals(other.idNacionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Nacionalidad[ idNacionalidad=" + idNacionalidad + " ]";
    }
    
}
