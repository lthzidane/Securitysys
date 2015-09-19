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
import javax.persistence.Id;
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
 * @author LOTHAR
 */
@Entity
@Table(name = "medidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidas.findAll", query = "SELECT m FROM Medidas m"),
    @NamedQuery(name = "Medidas.findByIdMedida", query = "SELECT m FROM Medidas m WHERE m.idMedida = :idMedida"),
    @NamedQuery(name = "Medidas.findByDescMedida", query = "SELECT m FROM Medidas m WHERE m.descMedida = :descMedida")})
public class Medidas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medida")
    private BigDecimal idMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_medida")
    private String descMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedida")
    private List<Productos> productosList;

    public Medidas() {
    }

    public Medidas(BigDecimal idMedida) {
        this.idMedida = idMedida;
    }

    public Medidas(BigDecimal idMedida, String descMedida) {
        this.idMedida = idMedida;
        this.descMedida = descMedida;
    }

    public BigDecimal getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(BigDecimal idMedida) {
        this.idMedida = idMedida;
    }

    public String getDescMedida() {
        return descMedida;
    }

    public void setDescMedida(String descMedida) {
        this.descMedida = descMedida;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedida != null ? idMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidas)) {
            return false;
        }
        Medidas other = (Medidas) object;
        if ((this.idMedida == null && other.idMedida != null) || (this.idMedida != null && !this.idMedida.equals(other.idMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medidas[ idMedida=" + idMedida + " ]";
    }
    
}
