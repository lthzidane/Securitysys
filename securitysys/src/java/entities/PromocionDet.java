/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "promocion_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PromocionDet.findAll", query = "SELECT p FROM PromocionDet p"),
    @NamedQuery(name = "PromocionDet.findByIdPromocionCab", query = "SELECT p FROM PromocionDet p WHERE p.promocionDetPK.idPromocionCab = :idPromocionCab"),
    @NamedQuery(name = "PromocionDet.findByIdSecuencia", query = "SELECT p FROM PromocionDet p WHERE p.promocionDetPK.idSecuencia = :idSecuencia"),
    @NamedQuery(name = "PromocionDet.findByCostoPromo", query = "SELECT p FROM PromocionDet p WHERE p.costoPromo = :costoPromo")})
public class PromocionDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PromocionDetPK promocionDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_promo")
    private int costoPromo;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;

    @JoinColumns({
        @JoinColumn(name = "id_promocion_cab", referencedColumnName = "id_promocion", insertable = false, updatable = false),
        @JoinColumn(name = "id_presu_promocion_cab", referencedColumnName = "id_presu", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Promocion promocion;

    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;

    public PromocionDet() {
    }

    public PromocionDet(PromocionDetPK promocionDetPK) {
        this.promocionDetPK = promocionDetPK;
    }

    public PromocionDet(PromocionDetPK promocionDetPK, int costoPromo) {
        this.promocionDetPK = promocionDetPK;
        this.costoPromo = costoPromo;
    }

    public PromocionDet(int idPromocionCab, int idSecuencia) {
        this.promocionDetPK = new PromocionDetPK(idPromocionCab, idSecuencia);
    }

    public PromocionDetPK getPromocionDetPK() {
        return promocionDetPK;
    }

    public void setPromocionDetPK(PromocionDetPK promocionDetPK) {
        this.promocionDetPK = promocionDetPK;
    }

    public int getCostoPromo() {
        return costoPromo;
    }

    public void setCostoPromo(int costoPromo) {
        this.costoPromo = costoPromo;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promocionDetPK != null ? promocionDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromocionDet)) {
            return false;
        }
        PromocionDet other = (PromocionDet) object;
        if ((this.promocionDetPK == null && other.promocionDetPK != null) || (this.promocionDetPK != null && !this.promocionDetPK.equals(other.promocionDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PromocionDet[ promocionDetPK=" + promocionDetPK + " ]";
    }

}
