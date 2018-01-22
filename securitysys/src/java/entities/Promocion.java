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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p")
    , @NamedQuery(name = "Promocion.findByIdPromocion", query = "SELECT p FROM Promocion p WHERE p.idPromocion = :idPromocion")
    , @NamedQuery(name = "Promocion.findByDescipcion", query = "SELECT p FROM Promocion p WHERE p.descipcion = :descipcion")
    , @NamedQuery(name = "Promocion.findByFechaIniPromo", query = "SELECT p FROM Promocion p WHERE p.fechaIniPromo = :fechaIniPromo")
    , @NamedQuery(name = "Promocion.findByFechaFinPromo", query = "SELECT p FROM Promocion p WHERE p.fechaFinPromo = :fechaFinPromo")})
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_promocion")
    private Integer idPromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descipcion")
    private String descipcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini_promo")
    @Temporal(TemporalType.DATE)
    private Date fechaIniPromo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_promo")
    @Temporal(TemporalType.DATE)
    private Date fechaFinPromo;
    @JoinColumn(name = "id_presu", referencedColumnName = "id_presupuesto")
    @OneToOne(optional = false)
    private Presupuesto idPresu;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromocion")
    private List<SolicitudDet> solicitudDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocion")
    private List<PromocionDet> promocionDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromocion")
    private List<PresupuestoDet> presupuestoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromocion")
    private List<Servicio> servicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromocion")
    private List<VentaDet> ventaDetList;

    public Promocion() {
    }

    public Promocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Promocion(Integer idPromocion, String descipcion, Date fechaIniPromo, Date fechaFinPromo) {
        this.idPromocion = idPromocion;
        this.descipcion = descipcion;
        this.fechaIniPromo = fechaIniPromo;
        this.fechaFinPromo = fechaFinPromo;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public Date getFechaIniPromo() {
        return fechaIniPromo;
    }

    public void setFechaIniPromo(Date fechaIniPromo) {
        this.fechaIniPromo = fechaIniPromo;
    }

    public Date getFechaFinPromo() {
        return fechaFinPromo;
    }

    public void setFechaFinPromo(Date fechaFinPromo) {
        this.fechaFinPromo = fechaFinPromo;
    }

    public Presupuesto getIdPresu() {
        return idPresu;
    }

    public void setIdPresu(Presupuesto idPresu) {
        this.idPresu = idPresu;
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

    @XmlTransient
    public List<SolicitudDet> getSolicitudDetList() {
        return solicitudDetList;
    }

    public void setSolicitudDetList(List<SolicitudDet> solicitudDetList) {
        this.solicitudDetList = solicitudDetList;
    }

    @XmlTransient
    public List<PromocionDet> getPromocionDetList() {
        return promocionDetList;
    }

    public void setPromocionDetList(List<PromocionDet> promocionDetList) {
        this.promocionDetList = promocionDetList;
    }

    @XmlTransient
    public List<PresupuestoDet> getPresupuestoDetList() {
        return presupuestoDetList;
    }

    public void setPresupuestoDetList(List<PresupuestoDet> presupuestoDetList) {
        this.presupuestoDetList = presupuestoDetList;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @XmlTransient
    public List<VentaDet> getVentaDetList() {
        return ventaDetList;
    }

    public void setVentaDetList(List<VentaDet> ventaDetList) {
        this.ventaDetList = ventaDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromocion != null ? idPromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idPromocion == null && other.idPromocion != null) || (this.idPromocion != null && !this.idPromocion.equals(other.idPromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promocion[ idPromocion=" + idPromocion + " ]";
    }
    
}
