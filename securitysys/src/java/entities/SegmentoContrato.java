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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author acer
 */
@Entity
@Table(name = "segmento_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegmentoContrato.findAll", query = "SELECT s FROM SegmentoContrato s")
    , @NamedQuery(name = "SegmentoContrato.findByIdSegmento", query = "SELECT s FROM SegmentoContrato s WHERE s.idSegmento = :idSegmento")
    , @NamedQuery(name = "SegmentoContrato.findByDescripcion", query = "SELECT s FROM SegmentoContrato s WHERE s.descripcion = :descripcion")})
public class SegmentoContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_segmento")
    @GeneratedValue(generator = "SegmentoSeq")
    @SequenceGenerator(name = "SegmentoSeq", sequenceName = "segmento_contrato_id_segmento_contrato_seq", allocationSize = 1)
    private Integer idSegmento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSegmento")
    private List<CuentaCliente> cuentaClienteList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public SegmentoContrato() {
    }

    public SegmentoContrato(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    public SegmentoContrato(Integer idSegmento, String descripcion) {
        this.idSegmento = idSegmento;
        this.descripcion = descripcion.toUpperCase();
    }

    public Integer getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    @XmlTransient
    public List<CuentaCliente> getCuentaClienteList() {
        return cuentaClienteList;
    }

    public void setCuentaClienteList(List<CuentaCliente> cuentaClienteList) {
        this.cuentaClienteList = cuentaClienteList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSegmento != null ? idSegmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegmentoContrato)) {
            return false;
        }
        SegmentoContrato other = (SegmentoContrato) object;
        if ((this.idSegmento == null && other.idSegmento != null) || (this.idSegmento != null && !this.idSegmento.equals(other.idSegmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegmentoContrato[ idSegmento=" + idSegmento + " ]";
    }
    
}
