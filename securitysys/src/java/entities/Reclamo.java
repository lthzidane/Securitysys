/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamo.findAll", query = "SELECT r FROM Reclamo r"),
    @NamedQuery(name = "Reclamo.findByIdReclamo", query = "SELECT r FROM Reclamo r WHERE r.idReclamo = :idReclamo"),
    @NamedQuery(name = "Reclamo.findByDescripcion", query = "SELECT r FROM Reclamo r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reclamo.findByFechaIngreso", query = "SELECT r FROM Reclamo r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Reclamo.findByFechaSolucion", query = "SELECT r FROM Reclamo r WHERE r.fechaSolucion = :fechaSolucion"),
    @NamedQuery(name = "Reclamo.findByIdNivel", query = "SELECT r FROM Reclamo r WHERE r.idNivel = :idNivel"),
    @NamedQuery(name = "Reclamo.findBySolucion", query = "SELECT r FROM Reclamo r WHERE r.solucion = :solucion")})
public class Reclamo implements Serializable {
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto")
    @ManyToOne(optional = false)
    private Departamento idDpto;
    @JoinColumn(name = "id_estado_trab", referencedColumnName = "id_estado_trab")
    @ManyToOne(optional = false)
    private EstadoTrab idEstadoTrab;
    @JoinColumn(name = "id_subtipo", referencedColumnName = "id_subtipo")
    @ManyToOne(optional = false)
    private Subtipo idSubtipo;
    @JoinColumn(name = "id_tiporecla", referencedColumnName = "id_tiporecla")
    @ManyToOne(optional = false)
    private Tiporeclamo idTiporecla;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reclamo")
    @GeneratedValue(generator="ReclamoSeq") 
    @SequenceGenerator(name="ReclamoSeq",sequenceName="id_reclamo_reclamo_seq_1", allocationSize=1)
    private BigDecimal idReclamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_solucion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private BigInteger idNivel;
    @Size(max = 150)
    @Column(name = "solucion")
    private String solucion;

    public Reclamo() {
    }

    public Reclamo(BigDecimal idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Reclamo(BigDecimal idReclamo, String descripcion, Date fechaIngreso, BigInteger idNivel) {
        this.idReclamo = idReclamo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.idNivel = idNivel;
    }

    public BigDecimal getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(BigDecimal idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    public BigInteger getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(BigInteger idNivel) {
        this.idNivel = idNivel;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReclamo != null ? idReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamo)) {
            return false;
        }
        Reclamo other = (Reclamo) object;
        if ((this.idReclamo == null && other.idReclamo != null) || (this.idReclamo != null && !this.idReclamo.equals(other.idReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reclamo[ idReclamo=" + idReclamo + " ]";
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Departamento getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Departamento idDpto) {
        this.idDpto = idDpto;
    }

    public EstadoTrab getIdEstadoTrab() {
        return idEstadoTrab;
    }

    public void setIdEstadoTrab(EstadoTrab idEstadoTrab) {
        this.idEstadoTrab = idEstadoTrab;
    }

    public Subtipo getIdSubtipo() {
        return idSubtipo;
    }

    public void setIdSubtipo(Subtipo idSubtipo) {
        this.idSubtipo = idSubtipo;
    }

    public Tiporeclamo getIdTiporecla() {
        return idTiporecla;
    }

    public void setIdTiporecla(Tiporeclamo idTiporecla) {
        this.idTiporecla = idTiporecla;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
