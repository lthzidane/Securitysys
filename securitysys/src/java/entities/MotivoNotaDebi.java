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
@Table(name = "motivo_nota_debi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoNotaDebi.findAll", query = "SELECT m FROM MotivoNotaDebi m")
    , @NamedQuery(name = "MotivoNotaDebi.findByIdMotivoNota", query = "SELECT m FROM MotivoNotaDebi m WHERE m.idMotivoNota = :idMotivoNota")
    , @NamedQuery(name = "MotivoNotaDebi.findByDescMotivoNota", query = "SELECT m FROM MotivoNotaDebi m WHERE m.descMotivoNota = :descMotivoNota")
    , @NamedQuery(name = "MotivoNotaDebi.findByTipoNota", query = "SELECT m FROM MotivoNotaDebi m WHERE m.tipoNota = :tipoNota")})
public class MotivoNotaDebi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo_nota")
    private Integer idMotivoNota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_motivo_nota")
    private String descMotivoNota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipo_nota")
    private String tipoNota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivoNota")
    private List<NotaCrediDebiVenta> notaCrediDebiVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivoNota")
    private List<NotaRemisionVenta> notaRemisionVentaList;

    public MotivoNotaDebi() {
    }

    public MotivoNotaDebi(Integer idMotivoNota) {
        this.idMotivoNota = idMotivoNota;
    }

    public MotivoNotaDebi(Integer idMotivoNota, String descMotivoNota, String tipoNota) {
        this.idMotivoNota = idMotivoNota;
        this.descMotivoNota = descMotivoNota;
        this.tipoNota = tipoNota;
    }

    public Integer getIdMotivoNota() {
        return idMotivoNota;
    }

    public void setIdMotivoNota(Integer idMotivoNota) {
        this.idMotivoNota = idMotivoNota;
    }

    public String getDescMotivoNota() {
        return descMotivoNota;
    }

    public void setDescMotivoNota(String descMotivoNota) {
        this.descMotivoNota = descMotivoNota;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    @XmlTransient
    public List<NotaCrediDebiVenta> getNotaCrediDebiVentaList() {
        return notaCrediDebiVentaList;
    }

    public void setNotaCrediDebiVentaList(List<NotaCrediDebiVenta> notaCrediDebiVentaList) {
        this.notaCrediDebiVentaList = notaCrediDebiVentaList;
    }

    @XmlTransient
    public List<NotaRemisionVenta> getNotaRemisionVentaList() {
        return notaRemisionVentaList;
    }

    public void setNotaRemisionVentaList(List<NotaRemisionVenta> notaRemisionVentaList) {
        this.notaRemisionVentaList = notaRemisionVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivoNota != null ? idMotivoNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoNotaDebi)) {
            return false;
        }
        MotivoNotaDebi other = (MotivoNotaDebi) object;
        if ((this.idMotivoNota == null && other.idMotivoNota != null) || (this.idMotivoNota != null && !this.idMotivoNota.equals(other.idMotivoNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MotivoNotaDebi[ idMotivoNota=" + idMotivoNota + " ]";
    }
    
}
