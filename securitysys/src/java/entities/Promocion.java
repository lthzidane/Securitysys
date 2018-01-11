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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author sebas
 */
@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p"),
    @NamedQuery(name = "Promocion.findByIdPromocion", query = "SELECT p FROM Promocion p WHERE p.promocionPK.idPromocion = :idPromocion"),
    @NamedQuery(name = "Promocion.findByIdPresu", query = "SELECT p FROM Promocion p WHERE p.promocionPK.idPresu = :idPresu"),
    @NamedQuery(name = "Promocion.findByDescipcion", query = "SELECT p FROM Promocion p WHERE p.descipcion = :descipcion"),
    @NamedQuery(name = "Promocion.findByFechaIniPromo", query = "SELECT p FROM Promocion p WHERE p.fechaIniPromo = :fechaIniPromo"),
    @NamedQuery(name = "Promocion.findByFechaFinPromo", query = "SELECT p FROM Promocion p WHERE p.fechaFinPromo = :fechaFinPromo")})
public class Promocion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PromocionPK promocionPK;
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
    @JoinColumn(name = "id_presu", referencedColumnName = "id_presupuesto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Presupuesto presupuesto;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPromocion")
    private List<Servicio> servicioList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promocion")
    private List<PromocionDet> promocionDetList;

    public Promocion() {
    }

    public Promocion(PromocionPK promocionPK) {
        this.promocionPK = promocionPK;
    }

    public Promocion(PromocionPK promocionPK, String descipcion, Date fechaIniPromo, Date fechaFinPromo) {
        this.promocionPK = promocionPK;
        this.descipcion = descipcion;
        this.fechaIniPromo = fechaIniPromo;
        this.fechaFinPromo = fechaFinPromo;
    }

    public Promocion(int idPromocion, int idPresu) {
        this.promocionPK = new PromocionPK(idPromocion, idPresu);
    }

    public PromocionPK getPromocionPK() {
        return promocionPK;
    }

    public void setPromocionPK(PromocionPK promocionPK) {
        this.promocionPK = promocionPK;
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

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
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
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @XmlTransient
    public List<PromocionDet> getPromocionDetList() {
        return promocionDetList;
    }

    public void setPromocionDetList(List<PromocionDet> promocionDetList) {
        this.promocionDetList = promocionDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promocionPK != null ? promocionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.promocionPK == null && other.promocionPK != null) || (this.promocionPK != null && !this.promocionPK.equals(other.promocionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promocion[ promocionPK=" + promocionPK + " ]";
    }
    
}
