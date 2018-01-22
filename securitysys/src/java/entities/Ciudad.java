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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByCiudad", query = "SELECT c FROM Ciudad c WHERE c.ciudad = :ciudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciudad")
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<Zona> zonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<Empresa> empresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<Sucursal> sucursalList;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Integer idCiudad, String ciudad) {
        this.idCiudad = idCiudad;
        this.ciudad = ciudad.toUpperCase();
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad.toUpperCase();
    }

    @XmlTransient
    public List<Zona> getZonaList() {
        return zonaList;
    }

    public void setZonaList(List<Zona> zonaList) {
        this.zonaList = zonaList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
