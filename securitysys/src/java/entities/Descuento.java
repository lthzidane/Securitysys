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
@Table(name = "descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d")
    , @NamedQuery(name = "Descuento.findByIdDescuento", query = "SELECT d FROM Descuento d WHERE d.idDescuento = :idDescuento")
    , @NamedQuery(name = "Descuento.findByIdUsuario", query = "SELECT d FROM Descuento d WHERE d.idUsuario = :idUsuario")
    , @NamedQuery(name = "Descuento.findByIdSucursal", query = "SELECT d FROM Descuento d WHERE d.idSucursal = :idSucursal")
    , @NamedQuery(name = "Descuento.findByDescripcionDesc", query = "SELECT d FROM Descuento d WHERE d.descripcionDesc = :descripcionDesc")})
public class Descuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descuento")
    private Integer idDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal")
    private int idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_desc")
    private String descripcionDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<SolicitudDet> solicitudDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descuento")
    private List<DescuentoDet> descuentoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<PresupuestoDet> presupuestoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<Servicio> servicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescuento")
    private List<VentaDet> ventaDetList;

    public Descuento() {
    }

    public Descuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Descuento(Integer idDescuento, int idUsuario, int idSucursal, String descripcionDesc) {
        this.idDescuento = idDescuento;
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.descripcionDesc = descripcionDesc;
    }

    public Integer getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcionDesc() {
        return descripcionDesc;
    }

    public void setDescripcionDesc(String descripcionDesc) {
        this.descripcionDesc = descripcionDesc;
    }

    @XmlTransient
    public List<SolicitudDet> getSolicitudDetList() {
        return solicitudDetList;
    }

    public void setSolicitudDetList(List<SolicitudDet> solicitudDetList) {
        this.solicitudDetList = solicitudDetList;
    }

    @XmlTransient
    public List<DescuentoDet> getDescuentoDetList() {
        return descuentoDetList;
    }

    public void setDescuentoDetList(List<DescuentoDet> descuentoDetList) {
        this.descuentoDetList = descuentoDetList;
    }

    @XmlTransient
    public List<PresupuestoDet> getPresupuestoDetList() {
        return presupuestoDetList;
    }

    public void setPresupuestoDetList(List<PresupuestoDet> presupuestoDetList) {
        this.presupuestoDetList = presupuestoDetList;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @XmlTransient
    public List<VentaDet> getVentaDetList() {
        return ventaDetList;
    }

    public void setVentaDetList(List<VentaDet> ventaDetList) {
        this.ventaDetList = ventaDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescuento != null ? idDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.idDescuento == null && other.idDescuento != null) || (this.idDescuento != null && !this.idDescuento.equals(other.idDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Descuento[ idDescuento=" + idDescuento + " ]";
    }
    
}
