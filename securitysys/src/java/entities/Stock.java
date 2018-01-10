/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByCodProducto", query = "SELECT s FROM Stock s WHERE s.codProducto = :codProducto"),
    @NamedQuery(name = "Stock.findByCantidad", query = "SELECT s FROM Stock s WHERE s.cantidad = :cantidad")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_producto")
    private BigDecimal codProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto")
    private List<VentasDet> ventasDetList;
    @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito")
    @ManyToOne(optional = false)
    private Depositos idDeposito;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;

    public Stock() {
    }

    public Stock(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public Stock(BigDecimal codProducto, BigInteger cantidad) {
        this.codProducto = codProducto;
        this.cantidad = cantidad;
    }

    public BigDecimal getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<VentasDet> getVentasDetList() {
        return ventasDetList;
    }

    public void setVentasDetList(List<VentasDet> ventasDetList) {
        this.ventasDetList = ventasDetList;
    }

    public Depositos getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Depositos idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stock[ codProducto=" + codProducto + " ]";
    }
    
}
