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
 * @author sebas
 */
@Entity
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursal.findByDescripcion", query = "SELECT s FROM Sucursal s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Sucursal.findByDirSucursal", query = "SELECT s FROM Sucursal s WHERE s.dirSucursal = :dirSucursal"),
    @NamedQuery(name = "Sucursal.findByTelSucursal", query = "SELECT s FROM Sucursal s WHERE s.telSucursal = :telSucursal")})
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dir_sucursal")
    private String dirSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tel_sucursal")
    private String telSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Promocion> promocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<CuentaCliente> cuentaClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<AperturaCierreCaja> aperturaCierreCajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Presupuesto> presupuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<OrdenTrabajo> ordenTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Reclamo> reclamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<NotaCrediDebiVenta> notaCrediDebiVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<SerieComprobante> serieComprobanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<NotaRemisionVenta> notaRemisionVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Diagnostico> diagnosticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Solicitud> solicitudList;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(Integer idSucursal, String descripcion, String dirSucursal, String telSucursal) {
        this.idSucursal = idSucursal;
        this.descripcion = descripcion.toUpperCase();
        this.dirSucursal = dirSucursal.toUpperCase();
        this.telSucursal = telSucursal;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public String getDirSucursal() {
        return dirSucursal;
    }

    public void setDirSucursal(String dirSucursal) {
        this.dirSucursal = dirSucursal.toUpperCase();
    }

    public String getTelSucursal() {
        return telSucursal;
    }

    public void setTelSucursal(String telSucursal) {
        this.telSucursal = telSucursal;
    }

    @XmlTransient
    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @XmlTransient
    public List<CuentaCliente> getCuentaClienteList() {
        return cuentaClienteList;
    }

    public void setCuentaClienteList(List<CuentaCliente> cuentaClienteList) {
        this.cuentaClienteList = cuentaClienteList;
    }

    @XmlTransient
    public List<AperturaCierreCaja> getAperturaCierreCajaList() {
        return aperturaCierreCajaList;
    }

    public void setAperturaCierreCajaList(List<AperturaCierreCaja> aperturaCierreCajaList) {
        this.aperturaCierreCajaList = aperturaCierreCajaList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @XmlTransient
    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<NotaCrediDebiVenta> getNotaCrediDebiVentaList() {
        return notaCrediDebiVentaList;
    }

    public void setNotaCrediDebiVentaList(List<NotaCrediDebiVenta> notaCrediDebiVentaList) {
        this.notaCrediDebiVentaList = notaCrediDebiVentaList;
    }

    @XmlTransient
    public List<SerieComprobante> getSerieComprobanteList() {
        return serieComprobanteList;
    }

    public void setSerieComprobanteList(List<SerieComprobante> serieComprobanteList) {
        this.serieComprobanteList = serieComprobanteList;
    }

    @XmlTransient
    public List<NotaRemisionVenta> getNotaRemisionVentaList() {
        return notaRemisionVentaList;
    }

    public void setNotaRemisionVentaList(List<NotaRemisionVenta> notaRemisionVentaList) {
        this.notaRemisionVentaList = notaRemisionVentaList;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sucursal[ idSucursal=" + idSucursal + " ]";
    }
    
}
