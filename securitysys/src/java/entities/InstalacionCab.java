/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "instalacion_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstalacionCab.findAll", query = "SELECT i FROM InstalacionCab i ORDER BY i.fechainstalacion"),
    @NamedQuery(name = "InstalacionCab.findByDescripcion", query = "SELECT i FROM InstalacionCab i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "InstalacionCab.findByTipoInstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.tipoInstalacion = :tipoInstalacion"),
    @NamedQuery(name = "InstalacionCab.findByFechainstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.fechainstalacion = :fechainstalacion"),
    @NamedQuery(name = "InstalacionCab.findByFechaFinInstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.fechaFinInstalacion = :fechaFinInstalacion"),
    @NamedQuery(name = "InstalacionCab.findByIdInstalacion", query = "SELECT i FROM InstalacionCab i WHERE i.idInstalacion = :idInstalacion")})
public class InstalacionCab implements Serializable {
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "id_estado_trab", referencedColumnName = "id_estado_trab")
    @ManyToOne
    private EstadoTrab idEstadoTrab;
    @JoinColumn(name = "id_movil", referencedColumnName = "id_movil")
    @ManyToOne
    private Moviles idMovil;
    @JoinColumn(name = "nro_orden", referencedColumnName = "nro_orden")
    @ManyToOne
    private OrdenTrabajoCab nroOrden;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    @ManyToOne
    private Tecnicos idTecnico;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne
    private TipoServicios idServicio;
    private static final long serialVersionUID = 1L;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "tipo_instalacion")
    private String tipoInstalacion;
    @Column(name = "fecha_instalacion")
    @Temporal(TemporalType.DATE)
    private Date fechainstalacion;
    @Column(name = "fecha_fin_instalacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinInstalacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_instalacion")
    @GeneratedValue(generator="InstalCabSeq") 
    @SequenceGenerator(name="InstalCabSeq",sequenceName="id_instalacion_seq", allocationSize=1) 
    private BigDecimal idInstalacion;

    public InstalacionCab() {
    }

    public InstalacionCab(BigDecimal idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    public Date getFechainstalacion() {
        return fechainstalacion;
    }

    public void setFechainstalacion(Date fechainstalacion) {
        this.fechainstalacion = fechainstalacion;
    }

    public Date getFechaFinInstalacion() {
        return fechaFinInstalacion;
    }

    public void setFechaFinInstalacion(Date fechaFinInstalacion) {
        this.fechaFinInstalacion = fechaFinInstalacion;
    }

    public BigDecimal getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(BigDecimal idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalacion != null ? idInstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionCab)) {
            return false;
        }
        InstalacionCab other = (InstalacionCab) object;
        if ((this.idInstalacion == null && other.idInstalacion != null) || (this.idInstalacion != null && !this.idInstalacion.equals(other.idInstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InstalacionCab[ idInstalacion=" + idInstalacion + " ]";
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public EstadoTrab getIdEstadoTrab() {
        return idEstadoTrab;
    }

    public void setIdEstadoTrab(EstadoTrab idEstadoTrab) {
        this.idEstadoTrab = idEstadoTrab;
    }

    public Moviles getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(Moviles idMovil) {
        this.idMovil = idMovil;
    }

    public OrdenTrabajoCab getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(OrdenTrabajoCab nroOrden) {
        this.nroOrden = nroOrden;
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
    
}
