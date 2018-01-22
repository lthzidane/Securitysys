/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author expsee
 */
@Entity
@Table(name = "valor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v")
    , @NamedQuery(name = "Valor.findByIdValor", query = "SELECT v FROM Valor v WHERE v.idValor = :idValor")
    , @NamedQuery(name = "Valor.findByDescripcion", query = "SELECT v FROM Valor v WHERE v.descripcion = :descripcion")})
public class Valor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valor")
    private Integer idValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valor")
    private List<Arqueo> arqueoList;

    public Valor() {
    }

    public Valor(Integer idValor) {
        this.idValor = idValor;
    }

    public Valor(Integer idValor, String descripcion) {
        this.idValor = idValor;
        this.descripcion = descripcion;
    }

    public Integer getIdValor() {
        return idValor;
    }

    public void setIdValor(Integer idValor) {
        this.idValor = idValor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Arqueo> getArqueoList() {
        return arqueoList;
    }

    public void setArqueoList(List<Arqueo> arqueoList) {
        this.arqueoList = arqueoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValor != null ? idValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.idValor == null && other.idValor != null) || (this.idValor != null && !this.idValor.equals(other.idValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Valor[ idValor=" + idValor + " ]";
    }
    
}
