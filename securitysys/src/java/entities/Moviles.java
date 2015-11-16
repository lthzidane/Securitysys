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
 * @author LOTHAR
 */
@Entity
@Table(name = "moviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviles.findAll", query = "SELECT m FROM Moviles m"),
    @NamedQuery(name = "Moviles.findByIdMovil", query = "SELECT m FROM Moviles m WHERE m.idMovil = :idMovil"),
    @NamedQuery(name = "Moviles.findByTipoMovil", query = "SELECT m FROM Moviles m WHERE m.tipoMovil = :tipoMovil"),
    @NamedQuery(name = "Moviles.findByMarca", query = "SELECT m FROM Moviles m WHERE m.marca = :marca"),
    @NamedQuery(name = "Moviles.findByA\u00f1o", query = "SELECT m FROM Moviles m WHERE m.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "Moviles.findByNroMatricula", query = "SELECT m FROM Moviles m WHERE m.nroMatricula = :nroMatricula"),
    @NamedQuery(name = "Moviles.findByFuncion", query = "SELECT m FROM Moviles m WHERE m.funcion = :funcion")})
public class Moviles implements Serializable {
    @OneToMany(mappedBy = "idMovil")
    private List<InstalacionCab> instalacionCabList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_movil")
      @GeneratedValue(generator="MovSeq") 
    @SequenceGenerator(name="MovSeq",sequenceName="id_moviles_seq", allocationSize=1) 
    private BigDecimal idMovil;
    @Size(max = 50)
    @Column(name = "tipo_movil")
    private String tipoMovil;
    @Size(max = 35)
    @Column(name = "marca")
    private String marca;
    @Column(name = "a\u00f1o")
    private BigInteger año;
    @Size(max = 8)
    @Column(name = "nro_matricula")
    private String nroMatricula;
    @Size(max = 2147483647)
    @Column(name = "funcion")
    private String funcion;

    public Moviles() {
    }

    public Moviles(BigDecimal idMovil) {
        this.idMovil = idMovil;
    }

    public BigDecimal getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(BigDecimal idMovil) {
        this.idMovil = idMovil;
    }

    public String getTipoMovil() {
        return tipoMovil;
    }

    public void setTipoMovil(String tipoMovil) {
        this.tipoMovil = tipoMovil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigInteger getAño() {
        return año;
    }

    public void setAño(BigInteger año) {
        this.año = año;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
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

    @XmlTransient
    public List<InstalacionCab> getInstalacionCabList() {
        return instalacionCabList;
    }

    public void setInstalacionCabList(List<InstalacionCab> instalacionCabList) {
        this.instalacionCabList = instalacionCabList;
    }
    
}
