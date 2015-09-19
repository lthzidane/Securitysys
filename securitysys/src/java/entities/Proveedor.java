/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByCodProv", query = "SELECT p FROM Proveedor p WHERE p.codProv = :codProv"),
    @NamedQuery(name = "Proveedor.findByRucProv", query = "SELECT p FROM Proveedor p WHERE p.rucProv = :rucProv"),
    @NamedQuery(name = "Proveedor.findByDescriProv", query = "SELECT p FROM Proveedor p WHERE p.descriProv = :descriProv"),
    @NamedQuery(name = "Proveedor.findByTelProv", query = "SELECT p FROM Proveedor p WHERE p.telProv = :telProv")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_prov")
    private Integer codProv;
    @Size(max = 30)
    @Column(name = "ruc_prov")
    private String rucProv;
    @Size(max = 30)
    @Column(name = "descri_prov")
    private String descriProv;
    @Size(max = 30)
    @Column(name = "tel_prov")
    private String telProv;
    @OneToMany(mappedBy = "codProv")
    private List<OrdenCompraCab> ordenCompraCabList;

    public Proveedor() {
    }

    public Proveedor(Integer codProv) {
        this.codProv = codProv;
    }

    public Integer getCodProv() {
        return codProv;
    }

    public void setCodProv(Integer codProv) {
        this.codProv = codProv;
    }

    public String getRucProv() {
        return rucProv;
    }

    public void setRucProv(String rucProv) {
        this.rucProv = rucProv;
    }

    public String getDescriProv() {
        return descriProv;
    }

    public void setDescriProv(String descriProv) {
        this.descriProv = descriProv;
    }

    public String getTelProv() {
        return telProv;
    }

    public void setTelProv(String telProv) {
        this.telProv = telProv;
    }

    @XmlTransient
    public List<OrdenCompraCab> getOrdenCompraCabList() {
        return ordenCompraCabList;
    }

    public void setOrdenCompraCabList(List<OrdenCompraCab> ordenCompraCabList) {
        this.ordenCompraCabList = ordenCompraCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProv != null ? codProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codProv == null && other.codProv != null) || (this.codProv != null && !this.codProv.equals(other.codProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proveedor[ codProv=" + codProv + " ]";
    }
    
}
