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
 * @author expsee
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
    , @NamedQuery(name = "Tarjeta.findByIdTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta")
    , @NamedQuery(name = "Tarjeta.findByDescTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.descTarjeta = :descTarjeta")
    , @NamedQuery(name = "Tarjeta.findByNroTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.nroTarjeta = :nroTarjeta")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_tarjeta")
    private String descTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nro_tarjeta")
    private String nroTarjeta;
    @JoinColumn(name = "id_entidad_emisora", referencedColumnName = "id_entidad_emisora")
    @ManyToOne(optional = false)
    private EntidadEmisora idEntidadEmisora;
    @JoinColumn(name = "id_marca_tarjeta", referencedColumnName = "id_marca_tarjeta")
    @ManyToOne(optional = false)
    private MarcaTarjeta idMarcaTarjeta;
    @JoinColumn(name = "id_tipo_tarjeta", referencedColumnName = "id_tipo_tarjeta")
    @ManyToOne(optional = false)
    private TipoTarjeta idTipoTarjeta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarjeta")
    private List<CobroTarjeta> cobroTarjetaList;

    public Tarjeta() {
    }

    public Tarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Tarjeta(Integer idTarjeta, String descTarjeta, String nroTarjeta) {
        this.idTarjeta = idTarjeta;
        this.descTarjeta = descTarjeta;
        this.nroTarjeta = nroTarjeta;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getDescTarjeta() {
        return descTarjeta;
    }

    public void setDescTarjeta(String descTarjeta) {
        this.descTarjeta = descTarjeta;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public EntidadEmisora getIdEntidadEmisora() {
        return idEntidadEmisora;
    }

    public void setIdEntidadEmisora(EntidadEmisora idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    public MarcaTarjeta getIdMarcaTarjeta() {
        return idMarcaTarjeta;
    }

    public void setIdMarcaTarjeta(MarcaTarjeta idMarcaTarjeta) {
        this.idMarcaTarjeta = idMarcaTarjeta;
    }

    public TipoTarjeta getIdTipoTarjeta() {
        return idTipoTarjeta;
    }

    public void setIdTipoTarjeta(TipoTarjeta idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    @XmlTransient
    public List<CobroTarjeta> getCobroTarjetaList() {
        return cobroTarjetaList;
    }

    public void setCobroTarjetaList(List<CobroTarjeta> cobroTarjetaList) {
        this.cobroTarjetaList = cobroTarjetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tarjeta[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
