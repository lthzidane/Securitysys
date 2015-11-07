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
 * @author LOTHAR
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDpto", query = "SELECT d FROM Departamento d WHERE d.idDpto = :idDpto"),
    @NamedQuery(name = "Departamento.findByNombreDpto", query = "SELECT d FROM Departamento d WHERE d.nombreDpto = :nombreDpto"),
    @NamedQuery(name = "Departamento.findByFuncion", query = "SELECT d FROM Departamento d WHERE d.funcion = :funcion"),
    @NamedQuery(name = "Departamento.findByResponsable", query = "SELECT d FROM Departamento d WHERE d.responsable = :responsable"),
    @NamedQuery(name = "Departamento.findByEstado", query = "SELECT d FROM Departamento d WHERE d.estado = :estado")})
public class Departamento implements Serializable {
    @Size(max = 40)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private List<Reclamo> reclamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private List<Tiporeclamo> tiporeclamoList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    @GeneratedValue(generator="DepartamentoSeq") 
    @SequenceGenerator(name="DepartamentoSeq",sequenceName="id_dpto_departamento_seq_1", allocationSize=1) 
    private BigDecimal idDpto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_dpto")
    private String nombreDpto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "funcion")
    private String funcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "responsable")
    private String responsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private List<Funcionario> funcionarioList;

    public Departamento() {
    }

    public Departamento(BigDecimal idDpto) {
        this.idDpto = idDpto;
    }

    public Departamento(BigDecimal idDpto, String nombreDpto, String funcion, String responsable, String estado) {
        this.idDpto = idDpto;
        this.nombreDpto = nombreDpto;
        this.funcion = funcion;
        this.responsable = responsable;
        this.estado = estado;
    }

    public BigDecimal getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(BigDecimal idDpto) {
        this.idDpto = idDpto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }


    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDpto != null ? idDpto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDpto == null && other.idDpto != null) || (this.idDpto != null && !this.idDpto.equals(other.idDpto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Departamento[ idDpto=" + idDpto + " ]";
    }

    @XmlTransient
    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    @XmlTransient
    public List<Tiporeclamo> getTiporeclamoList() {
        return tiporeclamoList;
    }

    public void setTiporeclamoList(List<Tiporeclamo> tiporeclamoList) {
        this.tiporeclamoList = tiporeclamoList;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
