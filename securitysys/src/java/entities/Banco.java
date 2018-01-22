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
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b")
    , @NamedQuery(name = "Banco.findByIdBanco", query = "SELECT b FROM Banco b WHERE b.idBanco = :idBanco")
    , @NamedQuery(name = "Banco.findByDescBanco", query = "SELECT b FROM Banco b WHERE b.descBanco = :descBanco")
    , @NamedQuery(name = "Banco.findByRucBanco", query = "SELECT b FROM Banco b WHERE b.rucBanco = :rucBanco")
    , @NamedQuery(name = "Banco.findByDirBanco", query = "SELECT b FROM Banco b WHERE b.dirBanco = :dirBanco")
    , @NamedQuery(name = "Banco.findByTelBanco", query = "SELECT b FROM Banco b WHERE b.telBanco = :telBanco")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banco")
    private Integer idBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_banco")
    private String descBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruc_banco")
    private String rucBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dir_banco")
    private String dirBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tel_banco")
    private String telBanco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanco")
    private List<CobroCheque> cobroChequeList;

    public Banco() {
    }

    public Banco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Banco(Integer idBanco, String descBanco, String rucBanco, String dirBanco, String telBanco) {
        this.idBanco = idBanco;
        this.descBanco = descBanco.toUpperCase();
        this.rucBanco = rucBanco;
        this.dirBanco = dirBanco.toUpperCase();
        this.telBanco = telBanco;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getDescBanco() {
        return descBanco;
    }

    public void setDescBanco(String descBanco) {
        this.descBanco = descBanco.toUpperCase();
    }

    public String getRucBanco() {
        return rucBanco;
    }

    public void setRucBanco(String rucBanco) {
        this.rucBanco = rucBanco;
    }

    public String getDirBanco() {
        return dirBanco;
    }

    public void setDirBanco(String dirBanco) {
        this.dirBanco = dirBanco.toUpperCase();
    }

    public String getTelBanco() {
        return telBanco;
    }

    public void setTelBanco(String telBanco) {
        this.telBanco = telBanco;
    }

    @XmlTransient
    public List<CobroCheque> getCobroChequeList() {
        return cobroChequeList;
    }

    public void setCobroChequeList(List<CobroCheque> cobroChequeList) {
        this.cobroChequeList = cobroChequeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Banco[ idBanco=" + idBanco + " ]";
    }
    
}
