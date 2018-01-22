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
@Table(name = "forma_cobro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaCobro.findAll", query = "SELECT f FROM FormaCobro f")
    , @NamedQuery(name = "FormaCobro.findByIdFormaCobro", query = "SELECT f FROM FormaCobro f WHERE f.idFormaCobro = :idFormaCobro")
    , @NamedQuery(name = "FormaCobro.findByDescripcion", query = "SELECT f FROM FormaCobro f WHERE f.descripcion = :descripcion")})
public class FormaCobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_forma_cobro")
    private Integer idFormaCobro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaCobro")
    private List<Cobro> cobroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaCobro")
    private List<Recaudacion> recaudacionList;

    public FormaCobro() {
    }

    public FormaCobro(Integer idFormaCobro) {
        this.idFormaCobro = idFormaCobro;
    }

    public FormaCobro(Integer idFormaCobro, String descripcion) {
        this.idFormaCobro = idFormaCobro;
        this.descripcion = descripcion;
    }

    public Integer getIdFormaCobro() {
        return idFormaCobro;
    }

    public void setIdFormaCobro(Integer idFormaCobro) {
        this.idFormaCobro = idFormaCobro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cobro> getCobroList() {
        return cobroList;
    }

    public void setCobroList(List<Cobro> cobroList) {
        this.cobroList = cobroList;
    }

    @XmlTransient
    public List<Recaudacion> getRecaudacionList() {
        return recaudacionList;
    }

    public void setRecaudacionList(List<Recaudacion> recaudacionList) {
        this.recaudacionList = recaudacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaCobro != null ? idFormaCobro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaCobro)) {
            return false;
        }
        FormaCobro other = (FormaCobro) object;
        if ((this.idFormaCobro == null && other.idFormaCobro != null) || (this.idFormaCobro != null && !this.idFormaCobro.equals(other.idFormaCobro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FormaCobro[ idFormaCobro=" + idFormaCobro + " ]";
    }
    
}
