/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "productos_kit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosKit.findAll", query = "SELECT p FROM ProductosKit p"),
    @NamedQuery(name = "ProductosKit.findByIdProductosKit", query = "SELECT p FROM ProductosKit p WHERE p.idProductosKit = :idProductosKit"),
    @NamedQuery(name = "ProductosKit.findByCodProducto", query = "SELECT p FROM ProductosKit p WHERE p.codProducto = :codProducto"),
    @NamedQuery(name = "ProductosKit.findByCantidad", query = "SELECT p FROM ProductosKit p WHERE p.cantidad = :cantidad")})
public class ProductosKit implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_productos_kit")
    @GeneratedValue(generator="ProductosKitSeq") 
    @SequenceGenerator(name="ProductosKitSeq",sequenceName="id_producto_kit_seq_1", allocationSize=1) 
    private BigDecimal idProductosKit;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false)
    private Productos codProducto;
    @Column(name = "cantidad")
    private BigInteger cantidad;

    public ProductosKit() {
    }

    public ProductosKit(BigDecimal idProductosKit) {
        this.idProductosKit = idProductosKit;
    }

    public BigDecimal getIdProductosKit() {
        return idProductosKit;
    }

    public void setIdProductosKit(BigDecimal idProductosKit) {
        this.idProductosKit = idProductosKit;
    }

    public Productos getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Productos codProducto) {
        this.codProducto = codProducto;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductosKit != null ? idProductosKit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosKit)) {
            return false;
        }
        ProductosKit other = (ProductosKit) object;
        if ((this.idProductosKit == null && other.idProductosKit != null) || (this.idProductosKit != null && !this.idProductosKit.equals(other.idProductosKit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductosKit[ idProductosKit=" + idProductosKit + " ]";
    }
    
}
