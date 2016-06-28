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
 * @author LOTHAR
 */
@Entity
@Table(name = "presupuesto_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoDet.findAll", query = "SELECT p FROM PresupuestoDet p"),
    @NamedQuery(name = "PresupuestoDet.findByTipoPresupuesto", query = "SELECT p FROM PresupuestoDet p WHERE p.presupuestoDetPK.tipoPresupuesto = :tipoPresupuesto"),
    @NamedQuery(name = "PresupuestoDet.findBySerPresupuesto", query = "SELECT p FROM PresupuestoDet p WHERE p.presupuestoDetPK.serPresupuesto = :serPresupuesto"),
    @NamedQuery(name = "PresupuestoDet.findByNroPresupuesto", query = "SELECT p FROM PresupuestoDet p WHERE p.presupuestoDetPK.nroPresupuesto = :nroPresupuesto"),
    @NamedQuery(name = "PresupuestoDet.findByNroSecuencia", query = "SELECT p FROM PresupuestoDet p WHERE p.presupuestoDetPK.nroSecuencia = :nroSecuencia"),
    @NamedQuery(name = "PresupuestoDet.findByPrecio", query = "SELECT p FROM PresupuestoDet p WHERE p.precio = :precio"),
    @NamedQuery(name = "PresupuestoDet.findByTotalDetalle", query = "SELECT p FROM PresupuestoDet p WHERE p.totalDetalle = :totalDetalle"),
    @NamedQuery(name = "PresupuestoDet.findByCantidad", query = "SELECT p FROM PresupuestoDet p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PresupuestoDet.findByTotalDescuento", query = "SELECT p FROM PresupuestoDet p WHERE p.totalDescuento = :totalDescuento")})
public class PresupuestoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoDetPK presupuestoDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigInteger precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_detalle")
    private BigInteger totalDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Column(name = "total_descuento")
    private BigInteger totalDescuento;
    @JoinColumns({
        @JoinColumn(name = "tipo_presupuesto", referencedColumnName = "tipo_presupuesto", insertable = false, updatable = false),
        @JoinColumn(name = "ser_presupuesto", referencedColumnName = "ser_presupuesto", insertable = false, updatable = false),
        @JoinColumn(name = "nro_presupuesto", referencedColumnName = "nro_presupuesto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PresupuestoCab presupuestoCab;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false)
    private Productos codProducto;

    public PresupuestoDet() {
    }

    public PresupuestoDet(PresupuestoDetPK presupuestoDetPK) {
        this.presupuestoDetPK = presupuestoDetPK;
    }

    public PresupuestoDet(PresupuestoDetPK presupuestoDetPK, BigInteger precio, BigInteger totalDetalle, BigInteger cantidad) {
        this.presupuestoDetPK = presupuestoDetPK;
        this.precio = precio;
        this.totalDetalle = totalDetalle;
        this.cantidad = cantidad;
    }

    public PresupuestoDet(String tipoPresupuesto, String serPresupuesto, BigInteger nroPresupuesto, BigInteger nroSecuencia) {
        this.presupuestoDetPK = new PresupuestoDetPK(tipoPresupuesto, serPresupuesto, nroPresupuesto, nroSecuencia);
    }

    public PresupuestoDetPK getPresupuestoDetPK() {
        return presupuestoDetPK;
    }

    public void setPresupuestoDetPK(PresupuestoDetPK presupuestoDetPK) {
        this.presupuestoDetPK = presupuestoDetPK;
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

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(BigInteger totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public PresupuestoCab getPresupuestoCab() {
        return presupuestoCab;
    }

    public void setPresupuestoCab(PresupuestoCab presupuestoCab) {
        this.presupuestoCab = presupuestoCab;
    }

    public Productos getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Productos codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoDetPK != null ? presupuestoDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoDet)) {
            return false;
        }
        PresupuestoDet other = (PresupuestoDet) object;
        if ((this.presupuestoDetPK == null && other.presupuestoDetPK != null) || (this.presupuestoDetPK != null && !this.presupuestoDetPK.equals(other.presupuestoDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PresupuestoDet[ presupuestoDetPK=" + presupuestoDetPK + " ]";
    }
    
}
