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
 * @author sebas
 */
@Entity
@Table(name = "serie_comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SerieComprobante.findAll", query = "SELECT s FROM SerieComprobante s"),
    @NamedQuery(name = "SerieComprobante.findByIdSerie", query = "SELECT s FROM SerieComprobante s WHERE s.idSerie = :idSerie")})
public class SerieComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "id_serie")
    private String idSerie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serieComprobante")
    private List<VentasCab> ventasCabList;
    @JoinColumn(name = "id_comprobante", referencedColumnName = "id_comprobante")
    @ManyToOne
    private TipoComprobante idComprobante;

    public SerieComprobante() {
    }

    public SerieComprobante(String idSerie) {
        this.idSerie = idSerie;
    }

    public String getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(String idSerie) {
        this.idSerie = idSerie;
    }

    @XmlTransient
    public List<VentasCab> getVentasCabList() {
        return ventasCabList;
    }

    public void setVentasCabList(List<VentasCab> ventasCabList) {
        this.ventasCabList = ventasCabList;
    }

    public TipoComprobante getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(TipoComprobante idComprobante) {
        this.idComprobante = idComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerie != null ? idSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerieComprobante)) {
            return false;
        }
        SerieComprobante other = (SerieComprobante) object;
        if ((this.idSerie == null && other.idSerie != null) || (this.idSerie != null && !this.idSerie.equals(other.idSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SerieComprobante[ idSerie=" + idSerie + " ]";
    }
    
}
