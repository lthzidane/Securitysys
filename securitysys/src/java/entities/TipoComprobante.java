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
 * @author sebas
 */
@Entity
@Table(name = "tipo_comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoComprobante.findAll", query = "SELECT t FROM TipoComprobante t"),
    @NamedQuery(name = "TipoComprobante.findByIdComprobante", query = "SELECT t FROM TipoComprobante t WHERE t.idComprobante = :idComprobante"),
    @NamedQuery(name = "TipoComprobante.findByComprobante", query = "SELECT t FROM TipoComprobante t WHERE t.comprobante = :comprobante")})
public class TipoComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "id_comprobante")
    private String idComprobante;
    @Size(max = 50)
    @Column(name = "comprobante")
    private String comprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoComprobante1")
    private List<VentasCab> ventasCabList;
    @OneToMany(mappedBy = "idComprobante")
    private List<SerieComprobante> serieComprobanteList;

    public TipoComprobante() {
    }

    public TipoComprobante(String idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(String idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    @XmlTransient
    public List<VentasCab> getVentasCabList() {
        return ventasCabList;
    }

    public void setVentasCabList(List<VentasCab> ventasCabList) {
        this.ventasCabList = ventasCabList;
    }

    @XmlTransient
    public List<SerieComprobante> getSerieComprobanteList() {
        return serieComprobanteList;
    }

    public void setSerieComprobanteList(List<SerieComprobante> serieComprobanteList) {
        this.serieComprobanteList = serieComprobanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobante != null ? idComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobante)) {
            return false;
        }
        TipoComprobante other = (TipoComprobante) object;
        if ((this.idComprobante == null && other.idComprobante != null) || (this.idComprobante != null && !this.idComprobante.equals(other.idComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoComprobante[ idComprobante=" + idComprobante + " ]";
    }
    
}
