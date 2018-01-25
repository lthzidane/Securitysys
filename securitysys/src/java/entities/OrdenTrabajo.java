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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "orden_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findByIdOt", query = "SELECT o FROM OrdenTrabajo o WHERE o.idOt = :idOt")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaOrden", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaOrden = :fechaOrden")
    , @NamedQuery(name = "OrdenTrabajo.findByIdEstado", query = "SELECT o FROM OrdenTrabajo o WHERE o.idEstado = :idEstado"),
    @NamedQuery(name = "OrdenTrabajo.findBetweenFechaOrden", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaOrden BETWEEN :startDate AND :endDate")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ot")
    private Integer idOt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado")
    private int idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOt")
    private List<InstalacionCab> instalacionCabList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private List<OrdenTrabajoDet> ordenTrabajoDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_cuadrilla", referencedColumnName = "id_cuadrilla")
    @ManyToOne(optional = false)
    private Cuadrilla idCuadrilla;
    @JoinColumn(name = "id_itinerario", referencedColumnName = "id_itinerario")
    @ManyToOne(optional = false)
    private Itinerario idItinerario;
    @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto")
    @ManyToOne(optional = false)
    private Presupuesto idPresupuesto;
    @JoinColumn(name = "id_reclamo", referencedColumnName = "id_reclamo")
    @ManyToOne(optional = false)
    private Reclamo idReclamo;
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    @ManyToOne(optional = false)
    private Solicitud idSolicitud;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer idOt) {
        this.idOt = idOt;
    }

    public OrdenTrabajo(Integer idOt, Date fechaOrden, int idEstado) {
        this.idOt = idOt;
        this.fechaOrden = fechaOrden;
        this.idEstado = idEstado;
    }

    public Integer getIdOt() {
        return idOt;
    }

    public void setIdOt(Integer idOt) {
        this.idOt = idOt;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<InstalacionCab> getInstalacionCabList() {
        return instalacionCabList;
    }

    public void setInstalacionCabList(List<InstalacionCab> instalacionCabList) {
        this.instalacionCabList = instalacionCabList;
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

    public Cuadrilla getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(Cuadrilla idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public Itinerario getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(Itinerario idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Presupuesto getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Presupuesto idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Reclamo getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Reclamo idReclamo) {
        this.idReclamo = idReclamo;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
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
        hash += (idOt != null ? idOt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.idOt == null && other.idOt != null) || (this.idOt != null && !this.idOt.equals(other.idOt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenTrabajo[ idOt=" + idOt + " ]";
    }
    
}
