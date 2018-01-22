/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "venta_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaDet.findAll", query = "SELECT v FROM VentaDet v")
    , @NamedQuery(name = "VentaDet.findByIdVenta", query = "SELECT v FROM VentaDet v WHERE v.ventaDetPK.idVenta = :idVenta")
    , @NamedQuery(name = "VentaDet.findByIdSecuencia", query = "SELECT v FROM VentaDet v WHERE v.ventaDetPK.idSecuencia = :idSecuencia")
    , @NamedQuery(name = "VentaDet.findByCantidad", query = "SELECT v FROM VentaDet v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "VentaDet.findByPrecioVenta", query = "SELECT v FROM VentaDet v WHERE v.precioVenta = :precioVenta")
    , @NamedQuery(name = "VentaDet.findByExento", query = "SELECT v FROM VentaDet v WHERE v.exento = :exento")
    , @NamedQuery(name = "VentaDet.findByGravada5", query = "SELECT v FROM VentaDet v WHERE v.gravada5 = :gravada5")
    , @NamedQuery(name = "VentaDet.findByGravada10", query = "SELECT v FROM VentaDet v WHERE v.gravada10 = :gravada10")
    , @NamedQuery(name = "VentaDet.findByIva5", query = "SELECT v FROM VentaDet v WHERE v.iva5 = :iva5")
    , @NamedQuery(name = "VentaDet.findByIva10", query = "SELECT v FROM VentaDet v WHERE v.iva10 = :iva10")})
public class VentaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaDetPK ventaDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private int precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exento")
    private int exento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada5")
    private int gravada5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada10")
    private int gravada10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva5")
    private int iva5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva10")
    private int iva10;
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento idDescuento;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_promocion", referencedColumnName = "id_promocion")
    @ManyToOne(optional = false)
    private Promocion idPromocion;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaDet() {
    }

    public VentaDet(VentaDetPK ventaDetPK) {
        this.ventaDetPK = ventaDetPK;
    }

    public VentaDet(VentaDetPK ventaDetPK, int cantidad, int precioVenta, int exento, int gravada5, int gravada10, int iva5, int iva10) {
        this.ventaDetPK = ventaDetPK;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.exento = exento;
        this.gravada5 = gravada5;
        this.gravada10 = gravada10;
        this.iva5 = iva5;
        this.iva10 = iva10;
    }

    public VentaDet(int idVenta, int idSecuencia) {
        this.ventaDetPK = new VentaDetPK(idVenta, idSecuencia);
    }

    public VentaDetPK getVentaDetPK() {
        return ventaDetPK;
    }

    public void setVentaDetPK(VentaDetPK ventaDetPK) {
        this.ventaDetPK = ventaDetPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExento() {
        return exento;
    }

    public void setExento(int exento) {
        this.exento = exento;
    }

    public int getGravada5() {
        return gravada5;
    }

    public void setGravada5(int gravada5) {
        this.gravada5 = gravada5;
    }

    public int getGravada10() {
        return gravada10;
    }

    public void setGravada10(int gravada10) {
        this.gravada10 = gravada10;
    }

    public int getIva5() {
        return iva5;
    }

    public void setIva5(int iva5) {
        this.iva5 = iva5;
    }

    public int getIva10() {
        return iva10;
    }

    public void setIva10(int iva10) {
        this.iva10 = iva10;
    }

    public Descuento getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Descuento idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Promocion getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaDetPK != null ? ventaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDet)) {
            return false;
        }
        VentaDet other = (VentaDet) object;
        if ((this.ventaDetPK == null && other.ventaDetPK != null) || (this.ventaDetPK != null && !this.ventaDetPK.equals(other.ventaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VentaDet[ ventaDetPK=" + ventaDetPK + " ]";
    }
    
}
