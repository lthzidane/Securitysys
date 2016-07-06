/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "orden_trabajo_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoCab.findAll", query = "SELECT o FROM OrdenTrabajoCab o ORDER BY o.fechaOrden"),
    @NamedQuery(name = "OrdenTrabajoCab.findByNroOrden", query = "SELECT o FROM OrdenTrabajoCab o WHERE o.nroOrden = :nroOrden"),
    @NamedQuery(name = "OrdenTrabajoCab.findByFechaOrden", query = "SELECT o FROM OrdenTrabajoCab o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "OrdenTrabajoCab.findBetweenFechaOrden", query = "SELECT o FROM OrdenTrabajoCab o WHERE o.fechaOrden BETWEEN :startDate AND :endDate")})
public class OrdenTrabajoCab implements Serializable {

    @OneToMany(mappedBy = "nroOrden")
    private List<InstalacionCab> instalacionCabList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_orden")
    @GeneratedValue(generator = "OTCabSeq")
    @SequenceGenerator(name = "OTCabSeq", sequenceName = "nro_orden_orden_trabajo_cab_seq_1", allocationSize = 1)
    private BigDecimal nroOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroOrden")
    private List<OrdenTrabajoDet> ordenTrabajoDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;
    @JoinColumn(name = "id_estado_trab", referencedColumnName = "id_estado_trab")
    @ManyToOne
    private EstadoTrab idEstadoTrab;
    @JoinColumn(name = "id_reclamo", referencedColumnName = "id_reclamo")
    @ManyToOne
    private Reclamo idReclamo;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    @ManyToOne(optional = false)
    private Tecnicos idTecnico;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private TipoServicios idServicio;

    public OrdenTrabajoCab() {
    }

    public OrdenTrabajoCab(BigDecimal nroOrden) {
        this.nroOrden = nroOrden;
    }

    public OrdenTrabajoCab(BigDecimal nroOrden, Date fechaOrden) {
        this.nroOrden = nroOrden;
        this.fechaOrden = fechaOrden;
    }

    public BigDecimal getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(BigDecimal nroOrden) {
        this.nroOrden = nroOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @XmlTransient
    public List<OrdenTrabajoDet> getOrdenTrabajoDetList() {
        return ordenTrabajoDetList;
    }

    public void setOrdenTrabajoDetList(List<OrdenTrabajoDet> ordenTrabajoDetList) {
        this.ordenTrabajoDetList = ordenTrabajoDetList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoTrab getIdEstadoTrab() {
        return idEstadoTrab;
    }

    public void setIdEstadoTrab(EstadoTrab idEstadoTrab) {
        this.idEstadoTrab = idEstadoTrab;
    }

    public Reclamo getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Reclamo idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Tecnicos getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnicos idTecnico) {
        this.idTecnico = idTecnico;
    }

    public TipoServicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(TipoServicios idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroOrden != null ? nroOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoCab)) {
            return false;
        }
        OrdenTrabajoCab other = (OrdenTrabajoCab) object;
        if ((this.nroOrden == null && other.nroOrden != null) || (this.nroOrden != null && !this.nroOrden.equals(other.nroOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenTrabajoCab[ nroOrden=" + nroOrden + " ]";
    }

    @XmlTransient
    public List<InstalacionCab> getInstalacionCabList() {
        return instalacionCabList;
    }

    public void setInstalacionCabList(List<InstalacionCab> instalacionCabList) {
        this.instalacionCabList = instalacionCabList;
    }

}
