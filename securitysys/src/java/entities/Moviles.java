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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "moviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviles.findAll", query = "SELECT m FROM Moviles m"),
    @NamedQuery(name = "Moviles.findByIdMovil", query = "SELECT m FROM Moviles m WHERE m.idMovil = :idMovil"),
    @NamedQuery(name = "Moviles.findByMatricula", query = "SELECT m FROM Moviles m WHERE m.matricula = :matricula"),
    @NamedQuery(name = "Moviles.findByAnio", query = "SELECT m FROM Moviles m WHERE m.anio = :anio")})
public class Moviles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="MovilSeq") 
    @SequenceGenerator(name="MovilSeq",sequenceName="moviles_id_movil_seq", allocationSize=1) 
    @Basic(optional = false)
    @Column(name = "id_movil")
    private Integer idMovil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca idMarca;
    @JoinColumn(name = "id_tipo_movil", referencedColumnName = "id_tipo_movil")
    @ManyToOne(optional = false)
    private TipoMovil idTipoMovil;

    public Moviles() {
    }

    public Moviles(Integer idMovil) {
        this.idMovil = idMovil;
    }

    public Moviles(Integer idMovil, String matricula, int anio) {
        this.idMovil = idMovil;
        this.matricula = matricula;
        this.anio = anio;
    }

    public Integer getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(Integer idMovil) {
        this.idMovil = idMovil;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public TipoMovil getIdTipoMovil() {
        return idTipoMovil;
    }

    public void setIdTipoMovil(TipoMovil idTipoMovil) {
        this.idTipoMovil = idTipoMovil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovil != null ? idMovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviles)) {
            return false;
        }
        Moviles other = (Moviles) object;
        if ((this.idMovil == null && other.idMovil != null) || (this.idMovil != null && !this.idMovil.equals(other.idMovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Moviles[ idMovil=" + idMovil + " ]";
    }
    
}
