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
 * @author acer
 */
@Entity
@Table(name = "marca_tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaTarjeta.findAll", query = "SELECT m FROM MarcaTarjeta m")
    , @NamedQuery(name = "MarcaTarjeta.findByIdMarcaTarjeta", query = "SELECT m FROM MarcaTarjeta m WHERE m.idMarcaTarjeta = :idMarcaTarjeta")
    , @NamedQuery(name = "MarcaTarjeta.findByDescMarcaTarjeta", query = "SELECT m FROM MarcaTarjeta m WHERE m.descMarcaTarjeta = :descMarcaTarjeta")})
public class MarcaTarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca_tarjeta")
    private Integer idMarcaTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_marca_tarjeta")
    private String descMarcaTarjeta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarcaTarjeta")
    private List<Tarjeta> tarjetaList;

    public MarcaTarjeta() {
    }

    public MarcaTarjeta(Integer idMarcaTarjeta) {
        this.idMarcaTarjeta = idMarcaTarjeta;
    }

    public MarcaTarjeta(Integer idMarcaTarjeta, String descMarcaTarjeta) {
        this.idMarcaTarjeta = idMarcaTarjeta;
        this.descMarcaTarjeta = descMarcaTarjeta.toUpperCase();
    }

    public Integer getIdMarcaTarjeta() {
        return idMarcaTarjeta;
    }

    public void setIdMarcaTarjeta(Integer idMarcaTarjeta) {
        this.idMarcaTarjeta = idMarcaTarjeta;
    }

    public String getDescMarcaTarjeta() {
        return descMarcaTarjeta;
    }

    public void setDescMarcaTarjeta(String descMarcaTarjeta) {
        this.descMarcaTarjeta = descMarcaTarjeta.toUpperCase();
    }

    @XmlTransient
    public List<Tarjeta> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<Tarjeta> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcaTarjeta != null ? idMarcaTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaTarjeta)) {
            return false;
        }
        MarcaTarjeta other = (MarcaTarjeta) object;
        if ((this.idMarcaTarjeta == null && other.idMarcaTarjeta != null) || (this.idMarcaTarjeta != null && !this.idMarcaTarjeta.equals(other.idMarcaTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MarcaTarjeta[ idMarcaTarjeta=" + idMarcaTarjeta + " ]";
    }
    
}
