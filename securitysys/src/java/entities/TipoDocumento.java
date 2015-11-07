/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByIdTipoDocu", query = "SELECT t FROM TipoDocumento t WHERE t.idTipoDocu = :idTipoDocu"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocu", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocu = :tipoDocu")})
public class TipoDocumento implements Serializable {
    @OneToMany(mappedBy = "tipoDocumento")
    private Collection<Tecnicos> tecnicosCollection;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_docu")
    @GeneratedValue(generator="TipoDocuSeq") 
    @SequenceGenerator(name="TipoDocuSeq",sequenceName="id_tipo_docu_seq", allocationSize=1) 
    private BigDecimal idTipoDocu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_docu")
    private String tipoDocu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDocu")
    private List<Cliente> clienteList;

    public TipoDocumento() {
    }

    public TipoDocumento(BigDecimal idTipoDocu) {
        this.idTipoDocu = idTipoDocu;
    }

    public TipoDocumento(BigDecimal idTipoDocu, String tipoDocu) {
        this.idTipoDocu = idTipoDocu;
        this.tipoDocu = tipoDocu;
    }

    public BigDecimal getIdTipoDocu() {
        return idTipoDocu;
    }

    public void setIdTipoDocu(BigDecimal idTipoDocu) {
        this.idTipoDocu = idTipoDocu;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocu != null ? idTipoDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTipoDocu == null && other.idTipoDocu != null) || (this.idTipoDocu != null && !this.idTipoDocu.equals(other.idTipoDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoDocumento[ idTipoDocu=" + idTipoDocu + " ]";
    }

    @XmlTransient
    public Collection<Tecnicos> getTecnicosCollection() {
        return tecnicosCollection;
    }

    public void setTecnicosCollection(Collection<Tecnicos> tecnicosCollection) {
        this.tecnicosCollection = tecnicosCollection;
    }
    
}
