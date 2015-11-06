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
import javax.persistence.GeneratedValue;
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
 * @author Acer
 */
@Entity
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p"),
    @NamedQuery(name = "Paises.findByIdPais", query = "SELECT p FROM Paises p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Paises.findByPrefijo", query = "SELECT p FROM Paises p WHERE p.prefijo = :prefijo"),
    @NamedQuery(name = "Paises.findByNombre", query = "SELECT p FROM Paises p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Paises.findByNacionalidad", query = "SELECT p FROM Paises p WHERE p.nacionalidad = :nacionalidad")})
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    @GeneratedValue(generator="PaisSeq") 
    @SequenceGenerator(name="PaisSeq",sequenceName="id_pais_paises_seq_1", allocationSize=1) 
    private BigDecimal idPais;
       @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "prefijo")
    private String prefijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPais")
    private List<Ciudad> ciudadList;

    public Paises() {
    }

    public Paises(BigDecimal idPais) {
        this.idPais = idPais;
    }

    public Paises(BigDecimal idPais, String prefijo, String nombre, String nacionalidad) {
        this.idPais = idPais;
        this.prefijo = prefijo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public BigDecimal getIdPais() {
        return idPais;
    }

    public void setIdPais(BigDecimal idPais) {
        this.idPais = idPais;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Paises[ idPais=" + idPais + " ]";
    }
    
}
