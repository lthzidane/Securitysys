/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "entidad_emisora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadEmisora.findAll", query = "SELECT e FROM EntidadEmisora e"),
    @NamedQuery(name = "EntidadEmisora.findByIdEntidadEmisora", query = "SELECT e FROM EntidadEmisora e WHERE e.idEntidadEmisora = :idEntidadEmisora"),
    @NamedQuery(name = "EntidadEmisora.findByDescEntidadEmisora", query = "SELECT e FROM EntidadEmisora e WHERE e.descEntidadEmisora = :descEntidadEmisora"),
    @NamedQuery(name = "EntidadEmisora.findByRucEntidadEmisora", query = "SELECT e FROM EntidadEmisora e WHERE e.rucEntidadEmisora = :rucEntidadEmisora"),
    @NamedQuery(name = "EntidadEmisora.findByDirEntidadEmisora", query = "SELECT e FROM EntidadEmisora e WHERE e.dirEntidadEmisora = :dirEntidadEmisora"),
    @NamedQuery(name = "EntidadEmisora.findByTelEntidadEmisora", query = "SELECT e FROM EntidadEmisora e WHERE e.telEntidadEmisora = :telEntidadEmisora")})
public class EntidadEmisora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_entidad_emisora")
    @GeneratedValue(generator="EntidadSeq") 
    @SequenceGenerator(name="EntidadSeq",sequenceName="entidad_emisora_id_entidad_emisora_seq_1", allocationSize=1) 
    private Integer idEntidadEmisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "desc_entidad_emisora")
    private String descEntidadEmisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruc_entidad_emisora")
    private String rucEntidadEmisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dir_entidad_emisora")
    private String dirEntidadEmisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tel_entidad_emisora")
    private String telEntidadEmisora;

    public EntidadEmisora() {
    }

    public EntidadEmisora(Integer idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    public EntidadEmisora(Integer idEntidadEmisora, String descEntidadEmisora, String rucEntidadEmisora, String dirEntidadEmisora, String telEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
        this.descEntidadEmisora = descEntidadEmisora;
        this.rucEntidadEmisora = rucEntidadEmisora;
        this.dirEntidadEmisora = dirEntidadEmisora;
        this.telEntidadEmisora = telEntidadEmisora;
    }

    public Integer getIdEntidadEmisora() {
        return idEntidadEmisora;
    }

    public void setIdEntidadEmisora(Integer idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    public String getDescEntidadEmisora() {
        return descEntidadEmisora;
    }

    public void setDescEntidadEmisora(String descEntidadEmisora) {
        this.descEntidadEmisora = descEntidadEmisora;
    }

    public String getRucEntidadEmisora() {
        return rucEntidadEmisora;
    }

    public void setRucEntidadEmisora(String rucEntidadEmisora) {
        this.rucEntidadEmisora = rucEntidadEmisora;
    }

    public String getDirEntidadEmisora() {
        return dirEntidadEmisora;
    }

    public void setDirEntidadEmisora(String dirEntidadEmisora) {
        this.dirEntidadEmisora = dirEntidadEmisora;
    }

    public String getTelEntidadEmisora() {
        return telEntidadEmisora;
    }

    public void setTelEntidadEmisora(String telEntidadEmisora) {
        this.telEntidadEmisora = telEntidadEmisora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidadEmisora != null ? idEntidadEmisora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadEmisora)) {
            return false;
        }
        EntidadEmisora other = (EntidadEmisora) object;
        if ((this.idEntidadEmisora == null && other.idEntidadEmisora != null) || (this.idEntidadEmisora != null && !this.idEntidadEmisora.equals(other.idEntidadEmisora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EntidadEmisora[ idEntidadEmisora=" + idEntidadEmisora + " ]";
    }
    
}
