/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByCodProducto", query = "SELECT p FROM Productos p WHERE p.codProducto = :codProducto"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")})
public class Productos implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto")
    private List<PresupuestoDet> presupuestoDetList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_producto")
    @GeneratedValue(generator="ProductosSeq") 
    @SequenceGenerator(name="ProductosSeq",sequenceName="cod_producto_producto_seq_1", allocationSize=1) 
    
    private BigDecimal codProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto")
    private List<OrdenCompraDet> ordenCompraDetList;
    @JoinColumn(name = "id_medida", referencedColumnName = "id_medida")
    @ManyToOne(optional = false)
    private Medidas idMedida;

    public Productos() {
    }

    public Productos(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public Productos(BigDecimal codProducto, String descripcion) {
        this.codProducto = codProducto;
        this.descripcion = descripcion;
    }

    public BigDecimal getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(BigDecimal codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<OrdenCompraDet> getOrdenCompraDetList() {
        return ordenCompraDetList;
    }

    public void setOrdenCompraDetList(List<OrdenCompraDet> ordenCompraDetList) {
        this.ordenCompraDetList = ordenCompraDetList;
    }

    public Medidas getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Medidas idMedida) {
        this.idMedida = idMedida;
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
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productos[ codProducto=" + codProducto + " ]";
    }

    @XmlTransient
    public List<PresupuestoDet> getPresupuestoDetList() {
        return presupuestoDetList;
    }

    public void setPresupuestoDetList(List<PresupuestoDet> presupuestoDetList) {
        this.presupuestoDetList = presupuestoDetList;
    }
    
}
