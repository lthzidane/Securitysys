/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "serie_comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SerieComprobante.findAll", query = "SELECT s FROM SerieComprobante s"),
    @NamedQuery(name = "SerieComprobante.findByIdSerieComprobante", query = "SELECT s FROM SerieComprobante s WHERE s.idSerieComprobante = :idSerieComprobante"),
    @NamedQuery(name = "SerieComprobante.findByDescripcion", query = "SELECT s FROM SerieComprobante s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SerieComprobante.findByPrefijo", query = "SELECT s FROM SerieComprobante s WHERE s.prefijo = :prefijo")})
public class SerieComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "SerieCompSeq")
    @SequenceGenerator(name = "SerieCompSeq", sequenceName = "serie_comprobante_id_serie_comprobante_seq_1", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id_serie_comprobante")
    private Integer idSerieComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "prefijo")
    private String prefijo;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public SerieComprobante() {
    }

    public SerieComprobante(Integer idSerieComprobante) {
        this.idSerieComprobante = idSerieComprobante;
    }

    public SerieComprobante(Integer idSerieComprobante, String descripcion, String prefijo) {
        this.idSerieComprobante = idSerieComprobante;
        this.descripcion = descripcion.toUpperCase();
        this.prefijo = prefijo.toUpperCase();
    }

    public Integer getIdSerieComprobante() {
        return idSerieComprobante;
    }

    public void setIdSerieComprobante(Integer idSerieComprobante) {
        this.idSerieComprobante = idSerieComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo.toUpperCase();
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSerieComprobante != null ? idSerieComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerieComprobante)) {
            return false;
        }
        SerieComprobante other = (SerieComprobante) object;
        if ((this.idSerieComprobante == null && other.idSerieComprobante != null) || (this.idSerieComprobante != null && !this.idSerieComprobante.equals(other.idSerieComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SerieComprobante[ idSerieComprobante=" + idSerieComprobante + " ]";
    }
    
}
