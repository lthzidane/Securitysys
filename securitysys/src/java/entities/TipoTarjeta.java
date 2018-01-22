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
@Table(name = "tipo_tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTarjeta.findAll", query = "SELECT t FROM TipoTarjeta t")
    , @NamedQuery(name = "TipoTarjeta.findByIdTipoTarjeta", query = "SELECT t FROM TipoTarjeta t WHERE t.idTipoTarjeta = :idTipoTarjeta")
    , @NamedQuery(name = "TipoTarjeta.findByDescTipoTarjeta", query = "SELECT t FROM TipoTarjeta t WHERE t.descTipoTarjeta = :descTipoTarjeta")})
public class TipoTarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_tarjeta")
    private Integer idTipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_tipo_tarjeta")
    private String descTipoTarjeta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTarjeta")
    private List<Tarjeta> tarjetaList;

    public TipoTarjeta() {
    }

    public TipoTarjeta(Integer idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    public TipoTarjeta(Integer idTipoTarjeta, String descTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
        this.descTipoTarjeta = descTipoTarjeta;
    }

    public Integer getIdTipoTarjeta() {
        return idTipoTarjeta;
    }

    public void setIdTipoTarjeta(Integer idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    public String getDescTipoTarjeta() {
        return descTipoTarjeta;
    }

    public void setDescTipoTarjeta(String descTipoTarjeta) {
        this.descTipoTarjeta = descTipoTarjeta;
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
        hash += (idTipoTarjeta != null ? idTipoTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTarjeta)) {
            return false;
        }
        TipoTarjeta other = (TipoTarjeta) object;
        if ((this.idTipoTarjeta == null && other.idTipoTarjeta != null) || (this.idTipoTarjeta != null && !this.idTipoTarjeta.equals(other.idTipoTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoTarjeta[ idTipoTarjeta=" + idTipoTarjeta + " ]";
    }
    
}
