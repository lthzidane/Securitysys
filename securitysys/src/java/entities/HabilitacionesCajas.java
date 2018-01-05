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
 * @author sebas
 */
@Entity
@Table(name = "habilitaciones_cajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HabilitacionesCajas.findAll", query = "SELECT h FROM HabilitacionesCajas h"),
    @NamedQuery(name = "HabilitacionesCajas.findByIdHabilitacion", query = "SELECT h FROM HabilitacionesCajas h WHERE h.idHabilitacion = :idHabilitacion"),
    @NamedQuery(name = "HabilitacionesCajas.findByFecha", query = "SELECT h FROM HabilitacionesCajas h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HabilitacionesCajas.findByFechaCierre", query = "SELECT h FROM HabilitacionesCajas h WHERE h.fechaCierre = :fechaCierre")})
public class HabilitacionesCajas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_habilitacion")
    private BigDecimal idHabilitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHabilitacion")
    private List<VentasCab> ventasCabList;
    @JoinColumn(name = "id_caja", referencedColumnName = "id_caja")
    @ManyToOne(optional = false)
    private Cajas idCaja;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private Estado idEstado;

    public HabilitacionesCajas() {
    }

    public HabilitacionesCajas(BigDecimal idHabilitacion) {
        this.idHabilitacion = idHabilitacion;
    }

    public HabilitacionesCajas(BigDecimal idHabilitacion, Date fecha) {
        this.idHabilitacion = idHabilitacion;
        this.fecha = fecha;
    }

    public BigDecimal getIdHabilitacion() {
        return idHabilitacion;
    }

    public void setIdHabilitacion(BigDecimal idHabilitacion) {
        this.idHabilitacion = idHabilitacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @XmlTransient
    public List<VentasCab> getVentasCabList() {
        return ventasCabList;
    }

    public void setVentasCabList(List<VentasCab> ventasCabList) {
        this.ventasCabList = ventasCabList;
    }

    public Cajas getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Cajas idCaja) {
        this.idCaja = idCaja;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabilitacion != null ? idHabilitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabilitacionesCajas)) {
            return false;
        }
        HabilitacionesCajas other = (HabilitacionesCajas) object;
        if ((this.idHabilitacion == null && other.idHabilitacion != null) || (this.idHabilitacion != null && !this.idHabilitacion.equals(other.idHabilitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HabilitacionesCajas[ idHabilitacion=" + idHabilitacion + " ]";
    }
    
}
