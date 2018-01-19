/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d")
    , @NamedQuery(name = "Diagnostico.findById", query = "SELECT d FROM Diagnostico d WHERE d.id = :id")
    , @NamedQuery(name = "Diagnostico.findByFechaDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.fechaDiagnostico = :fechaDiagnostico")
    , @NamedQuery(name = "Diagnostico.findByEstadoDiag", query = "SELECT d FROM Diagnostico d WHERE d.estadoDiag = :estadoDiag")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_diagnostico")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_diag")
    private String estadoDiag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagnostico")
    private List<DiagnosticoDet> diagnosticoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiagnostico")
    private List<Presupuesto> presupuestoList;
    @JoinColumn(name = "id_reclamo", referencedColumnName = "id_reclamo")
    @ManyToOne(optional = false)
    private Reclamo idReclamo;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Diagnostico() {
    }

    public Diagnostico(Integer id) {
        this.id = id;
    }

    public Diagnostico(Integer id, Date fechaDiagnostico, String estadoDiag) {
        this.id = id;
        this.fechaDiagnostico = fechaDiagnostico;
        this.estadoDiag = estadoDiag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getEstadoDiag() {
        return estadoDiag;
    }

    public void setEstadoDiag(String estadoDiag) {
        this.estadoDiag = estadoDiag;
    }

    @XmlTransient
    public List<DiagnosticoDet> getDiagnosticoDetList() {
        return diagnosticoDetList;
    }

    public void setDiagnosticoDetList(List<DiagnosticoDet> diagnosticoDetList) {
        this.diagnosticoDetList = diagnosticoDetList;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    public Reclamo getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Reclamo idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Diagnostico[ id=" + id + " ]";
    }
    
}
