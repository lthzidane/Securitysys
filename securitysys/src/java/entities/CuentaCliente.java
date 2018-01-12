/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "cuenta_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaCliente.findAll", query = "SELECT c FROM CuentaCliente c"),
    @NamedQuery(name = "CuentaCliente.findByIdCuenta", query = "SELECT c FROM CuentaCliente c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "CuentaCliente.findByContacto", query = "SELECT c FROM CuentaCliente c WHERE c.contacto = :contacto"),
    @NamedQuery(name = "CuentaCliente.findByFechaHabilitacion", query = "SELECT c FROM CuentaCliente c WHERE c.fechaHabilitacion = :fechaHabilitacion")})
public class CuentaCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_habilitacion")
    @Temporal(TemporalType.DATE)
    private Date fechaHabilitacion;
    
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    
    @JoinColumns({
        @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato",insertable = false, updatable = false),
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Contrato contrato;
    
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_segmento", referencedColumnName = "id_segmento")
    @ManyToOne(optional = false)
    private SegmentoContrato idSegmento;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public CuentaCliente() {
    }

    public CuentaCliente(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public CuentaCliente(Integer idCuenta, String contacto, Date fechaHabilitacion) {
        this.idCuenta = idCuenta;
        this.contacto = contacto;
        this.fechaHabilitacion = fechaHabilitacion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Date getFechaHabilitacion() {
        return fechaHabilitacion;
    }

    public void setFechaHabilitacion(Date fechaHabilitacion) {
        this.fechaHabilitacion = fechaHabilitacion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public SegmentoContrato getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(SegmentoContrato idSegmento) {
        this.idSegmento = idSegmento;
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
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaCliente)) {
            return false;
        }
        CuentaCliente other = (CuentaCliente) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CuentaCliente[ idCuenta=" + idCuenta + " ]";
    }
    
}
