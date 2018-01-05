/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "ventas_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasDet.findAll", query = "SELECT v FROM VentasDet v"),
    @NamedQuery(name = "VentasDet.findByTipoComprobante", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.tipoComprobante = :tipoComprobante"),
    @NamedQuery(name = "VentasDet.findBySerComprobante", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.serComprobante = :serComprobante"),
    @NamedQuery(name = "VentasDet.findByNroComprobante", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "VentasDet.findByNroSecuencia", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.nroSecuencia = :nroSecuencia"),
    @NamedQuery(name = "VentasDet.findByCantidad", query = "SELECT v FROM VentasDet v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentasDet.findByPrecio", query = "SELECT v FROM VentasDet v WHERE v.precio = :precio"),
    @NamedQuery(name = "VentasDet.findByTotalDetalle", query = "SELECT v FROM VentasDet v WHERE v.totalDetalle = :totalDetalle")})
public class VentasDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasDetPK ventasDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigInteger precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_detalle")
    private BigInteger totalDetalle;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false)
    private Stock codProducto;
    @JoinColumns({
        @JoinColumn(name = "tipo_comprobante", referencedColumnName = "tipo_comprobante", insertable = false, updatable = false),
        @JoinColumn(name = "ser_comprobante", referencedColumnName = "ser_comprobante", insertable = false, updatable = false),
        @JoinColumn(name = "nro_comprobante", referencedColumnName = "nro_comprobante", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private VentasCab ventasCab;

    public VentasDet() {
    }

    public VentasDet(VentasDetPK ventasDetPK) {
        this.ventasDetPK = ventasDetPK;
    }

    public VentasDet(VentasDetPK ventasDetPK, BigInteger cantidad, BigInteger precio, BigInteger totalDetalle) {
        this.ventasDetPK = ventasDetPK;
        this.cantidad = cantidad;
        this.precio = precio;
        this.totalDetalle = totalDetalle;
    }

    public VentasDet(String tipoComprobante, String serComprobante, BigInteger nroComprobante, BigInteger nroSecuencia) {
        this.ventasDetPK = new VentasDetPK(tipoComprobante, serComprobante, nroComprobante, nroSecuencia);
    }

    public VentasDetPK getVentasDetPK() {
        return ventasDetPK;
    }

    public void setVentasDetPK(VentasDetPK ventasDetPK) {
        this.ventasDetPK = ventasDetPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public BigInteger getTotalDetalle() {
        return totalDetalle;
    }

    public void setTotalDetalle(BigInteger totalDetalle) {
        this.totalDetalle = totalDetalle;
    }

    public Stock getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Stock codProducto) {
        this.codProducto = codProducto;
    }

    public VentasCab getVentasCab() {
        return ventasCab;
    }

    public void setVentasCab(VentasCab ventasCab) {
        this.ventasCab = ventasCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasDetPK != null ? ventasDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDet)) {
            return false;
        }
        VentasDet other = (VentasDet) object;
        if ((this.ventasDetPK == null && other.ventasDetPK != null) || (this.ventasDetPK != null && !this.ventasDetPK.equals(other.ventasDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentasDet[ ventasDetPK=" + ventasDetPK + " ]";
    }
    
}
