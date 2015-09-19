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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "orden_compra_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompraDet.findAll", query = "SELECT o FROM OrdenCompraDet o"),
    @NamedQuery(name = "OrdenCompraDet.findByTipoOrdenCompra", query = "SELECT o FROM OrdenCompraDet o WHERE o.ordenCompraDetPK.tipoOrdenCompra = :tipoOrdenCompra"),
    @NamedQuery(name = "OrdenCompraDet.findBySerOrdenCompra", query = "SELECT o FROM OrdenCompraDet o WHERE o.ordenCompraDetPK.serOrdenCompra = :serOrdenCompra"),
    @NamedQuery(name = "OrdenCompraDet.findByNroOrdenCompra", query = "SELECT o FROM OrdenCompraDet o WHERE o.ordenCompraDetPK.nroOrdenCompra = :nroOrdenCompra"),
    @NamedQuery(name = "OrdenCompraDet.findByCantidad", query = "SELECT o FROM OrdenCompraDet o WHERE o.cantidad = :cantidad")})
public class OrdenCompraDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenCompraDetPK ordenCompraDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @JoinColumns({
        @JoinColumn(name = "tipo_orden_compra", referencedColumnName = "tipo_orden_compra", insertable = false, updatable = false),
        @JoinColumn(name = "ser_orden_compra", referencedColumnName = "ser_orden_compra", insertable = false, updatable = false),
        @JoinColumn(name = "nro_orden_compra", referencedColumnName = "nro_orden_compra", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private OrdenCompraCab ordenCompraCab;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false)
    private Productos codProducto;

    public OrdenCompraDet() {
    }

    public OrdenCompraDet(OrdenCompraDetPK ordenCompraDetPK) {
        this.ordenCompraDetPK = ordenCompraDetPK;
    }

    public OrdenCompraDet(OrdenCompraDetPK ordenCompraDetPK, BigInteger cantidad) {
        this.ordenCompraDetPK = ordenCompraDetPK;
        this.cantidad = cantidad;
    }

    public OrdenCompraDet(String tipoOrdenCompra, String serOrdenCompra, BigInteger nroOrdenCompra) {
        this.ordenCompraDetPK = new OrdenCompraDetPK(tipoOrdenCompra, serOrdenCompra, nroOrdenCompra);
    }

    public OrdenCompraDetPK getOrdenCompraDetPK() {
        return ordenCompraDetPK;
    }

    public void setOrdenCompraDetPK(OrdenCompraDetPK ordenCompraDetPK) {
        this.ordenCompraDetPK = ordenCompraDetPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenCompraCab getOrdenCompraCab() {
        return ordenCompraCab;
    }

    public void setOrdenCompraCab(OrdenCompraCab ordenCompraCab) {
        this.ordenCompraCab = ordenCompraCab;
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
        hash += (ordenCompraDetPK != null ? ordenCompraDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraDet)) {
            return false;
        }
        OrdenCompraDet other = (OrdenCompraDet) object;
        if ((this.ordenCompraDetPK == null && other.ordenCompraDetPK != null) || (this.ordenCompraDetPK != null && !this.ordenCompraDetPK.equals(other.ordenCompraDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenCompraDet[ ordenCompraDetPK=" + ordenCompraDetPK + " ]";
    }
    
}
