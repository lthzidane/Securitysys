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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "presupuesto_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoDet.findAll", query = "SELECT p FROM PresupuestoDet p")
    , @NamedQuery(name = "PresupuestoDet.findByIdPresupuestoCab", query = "SELECT p FROM PresupuestoDet p WHERE p.presupuestoDetPK.idPresupuestoCab = :idPresupuestoCab")
    , @NamedQuery(name = "PresupuestoDet.findByIdSecuencia", query = "SELECT p FROM PresupuestoDet p WHERE p.presupuestoDetPK.idSecuencia = :idSecuencia")
    , @NamedQuery(name = "PresupuestoDet.findByCantidad", query = "SELECT p FROM PresupuestoDet p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "PresupuestoDet.findByExenta", query = "SELECT p FROM PresupuestoDet p WHERE p.exenta = :exenta")
    , @NamedQuery(name = "PresupuestoDet.findByGravada5", query = "SELECT p FROM PresupuestoDet p WHERE p.gravada5 = :gravada5")
    , @NamedQuery(name = "PresupuestoDet.findByGravada10", query = "SELECT p FROM PresupuestoDet p WHERE p.gravada10 = :gravada10")
    , @NamedQuery(name = "PresupuestoDet.findByPrecio", query = "SELECT p FROM PresupuestoDet p WHERE p.precio = :precio")})
public class PresupuestoDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoDetPK presupuestoDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exenta")
    private int exenta;
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
    @Column(name = "precio")
    private int precio;
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento idDescuento;
    @JoinColumn(name = "id_presupuesto_cab", referencedColumnName = "id_presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Presupuesto presupuesto;
    @JoinColumn(name = "id_promocion", referencedColumnName = "id_promocion")
    @ManyToOne(optional = false)
    private Promocion idPromocion;

    @Transient
    private Servicio codProducto;
    
    @Transient
    private String totalDescuento;
    
    @Transient
    private String totalDetalle;
    
    public PresupuestoDet() {
    }

    public PresupuestoDet(PresupuestoDetPK presupuestoDetPK) {
        this.presupuestoDetPK = presupuestoDetPK;
    }

    public PresupuestoDet(PresupuestoDetPK presupuestoDetPK, int cantidad, int exenta, int gravada5, int gravada10, int precio) {
        this.presupuestoDetPK = presupuestoDetPK;
        this.cantidad = cantidad;
        this.exenta = exenta;
        this.gravada5 = gravada5;
        this.gravada10 = gravada10;
        this.precio = precio;
    }

    public PresupuestoDet(int idPresupuestoCab, int idSecuencia) {
        this.presupuestoDetPK = new PresupuestoDetPK(idPresupuestoCab, idSecuencia);
    }

    public PresupuestoDetPK getPresupuestoDetPK() {
        return presupuestoDetPK;
    }

    public void setPresupuestoDetPK(PresupuestoDetPK presupuestoDetPK) {
        this.presupuestoDetPK = presupuestoDetPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getExenta() {
        return exenta;
    }

    public void setExenta(int exenta) {
        this.exenta = exenta;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Descuento getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Descuento idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Promocion getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
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

    public Servicio getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Servicio codProducto) {
        this.codProducto = codProducto;
    }

    public String getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(String totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public String getTotalDetalle() {
        return totalDetalle;
    }

    public void setTotalDetalle(String totalDetalle) {
        this.totalDetalle = totalDetalle;
    }
    
    
}
