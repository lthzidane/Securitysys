/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "ventas_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasCab.findAll", query = "SELECT v FROM VentasCab v"),
    @NamedQuery(name = "VentasCab.findByTipoComprobante", query = "SELECT v FROM VentasCab v WHERE v.ventasCabPK.tipoComprobante = :tipoComprobante"),
    @NamedQuery(name = "VentasCab.findBySerComprobante", query = "SELECT v FROM VentasCab v WHERE v.ventasCabPK.serComprobante = :serComprobante"),
    @NamedQuery(name = "VentasCab.findByNroComprobante", query = "SELECT v FROM VentasCab v WHERE v.ventasCabPK.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "VentasCab.findByTotalIva", query = "SELECT v FROM VentasCab v WHERE v.totalIva = :totalIva"),
    @NamedQuery(name = "VentasCab.findByFecha", query = "SELECT v FROM VentasCab v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "VentasCab.findByTotal", query = "SELECT v FROM VentasCab v WHERE v.total = :total"),
    @NamedQuery(name = "VentasCab.findByFechaVto", query = "SELECT v FROM VentasCab v WHERE v.fechaVto = :fechaVto")})
public class VentasCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasCabPK ventasCabPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_iva")
    private BigInteger totalIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigInteger total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vto")
    @Temporal(TemporalType.DATE)
    private Date fechaVto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventasCab")
    private List<VentasDet> ventasDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_habilitacion", referencedColumnName = "id_habilitacion")
    @ManyToOne(optional = false)
    private HabilitacionesCajas idHabilitacion;
    @JoinColumns({
        @JoinColumn(name = "tipo_pedido", referencedColumnName = "tipo_pedido"),
        @JoinColumn(name = "ser_pedido", referencedColumnName = "ser_pedido"),
        @JoinColumn(name = "nro_pedido", referencedColumnName = "nro_pedido")})
    @ManyToOne(optional = false)
    private PedidosCab pedidosCab;
    @JoinColumns({
        @JoinColumn(name = "tipo_presupuesto", referencedColumnName = "tipo_presupuesto"),
        @JoinColumn(name = "ser_presupuesto", referencedColumnName = "ser_presupuesto"),
        @JoinColumn(name = "nro_presupuesto", referencedColumnName = "nro_presupuesto")})
    @ManyToOne(optional = false)
    private PresupuestoCab presupuestoCab;
    @JoinColumn(name = "ser_comprobante", referencedColumnName = "id_serie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SerieComprobante serieComprobante;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursales idSucursal;
    @JoinColumn(name = "tipo_comprobante", referencedColumnName = "id_comprobante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoComprobante tipoComprobante1;

    public VentasCab() {
    }

    public VentasCab(VentasCabPK ventasCabPK) {
        this.ventasCabPK = ventasCabPK;
    }

    public VentasCab(VentasCabPK ventasCabPK, BigInteger totalIva, Date fecha, BigInteger total, Date fechaVto) {
        this.ventasCabPK = ventasCabPK;
        this.totalIva = totalIva;
        this.fecha = fecha;
        this.total = total;
        this.fechaVto = fechaVto;
    }

    public VentasCab(String tipoComprobante, String serComprobante, BigInteger nroComprobante) {
        this.ventasCabPK = new VentasCabPK(tipoComprobante, serComprobante, nroComprobante);
    }

    public VentasCabPK getVentasCabPK() {
        return ventasCabPK;
    }

    public void setVentasCabPK(VentasCabPK ventasCabPK) {
        this.ventasCabPK = ventasCabPK;
    }

    public BigInteger getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigInteger totalIva) {
        this.totalIva = totalIva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

    @XmlTransient
    public List<VentasDet> getVentasDetList() {
        return ventasDetList;
    }

    public void setVentasDetList(List<VentasDet> ventasDetList) {
        this.ventasDetList = ventasDetList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public HabilitacionesCajas getIdHabilitacion() {
        return idHabilitacion;
    }

    public void setIdHabilitacion(HabilitacionesCajas idHabilitacion) {
        this.idHabilitacion = idHabilitacion;
    }

    public PedidosCab getPedidosCab() {
        return pedidosCab;
    }

    public void setPedidosCab(PedidosCab pedidosCab) {
        this.pedidosCab = pedidosCab;
    }

    public PresupuestoCab getPresupuestoCab() {
        return presupuestoCab;
    }

    public void setPresupuestoCab(PresupuestoCab presupuestoCab) {
        this.presupuestoCab = presupuestoCab;
    }

    public SerieComprobante getSerieComprobante() {
        return serieComprobante;
    }

    public void setSerieComprobante(SerieComprobante serieComprobante) {
        this.serieComprobante = serieComprobante;
    }

    public Sucursales getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursales idSucursal) {
        this.idSucursal = idSucursal;
    }

    public TipoComprobante getTipoComprobante1() {
        return tipoComprobante1;
    }

    public void setTipoComprobante1(TipoComprobante tipoComprobante1) {
        this.tipoComprobante1 = tipoComprobante1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasCabPK != null ? ventasCabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasCab)) {
            return false;
        }
        VentasCab other = (VentasCab) object;
        if ((this.ventasCabPK == null && other.ventasCabPK != null) || (this.ventasCabPK != null && !this.ventasCabPK.equals(other.ventasCabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentasCab[ ventasCabPK=" + ventasCabPK + " ]";
    }
    
}
