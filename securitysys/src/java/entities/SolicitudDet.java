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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "solicitud_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudDet.findAll", query = "SELECT s FROM SolicitudDet s")
    , @NamedQuery(name = "SolicitudDet.findByIdSolicitudCab", query = "SELECT s FROM SolicitudDet s WHERE s.solicitudDetPK.idSolicitudCab = :idSolicitudCab")
    , @NamedQuery(name = "SolicitudDet.findByIdSecuencia", query = "SELECT s FROM SolicitudDet s WHERE s.solicitudDetPK.idSecuencia = :idSecuencia")
    , @NamedQuery(name = "SolicitudDet.findByDescripcion", query = "SELECT s FROM SolicitudDet s WHERE s.descripcion = :descripcion")})
public class SolicitudDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudDetPK solicitudDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")
    @ManyToOne(optional = false)
    private Descuento idDescuento;
    @JoinColumns({
        @JoinColumn(name = "id_promocion", referencedColumnName = "id_promocion", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "id_presu", referencedColumnName = "id_presu", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Promocion idPromocion;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_solicitud_cab", referencedColumnName = "id_solicitud", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitud solicitud;

    public SolicitudDet() {
    }

    public SolicitudDet(SolicitudDetPK solicitudDetPK) {
        this.solicitudDetPK = solicitudDetPK;
    }

    public SolicitudDet(SolicitudDetPK solicitudDetPK, String descripcion) {
        this.solicitudDetPK = solicitudDetPK;
        this.descripcion = descripcion;
    }

    public SolicitudDet(int idSolicitudCab, int idSecuencia) {
        this.solicitudDetPK = new SolicitudDetPK(idSolicitudCab, idSecuencia);
    }

    public SolicitudDetPK getSolicitudDetPK() {
        return solicitudDetPK;
    }

    public void setSolicitudDetPK(SolicitudDetPK solicitudDetPK) {
        this.solicitudDetPK = solicitudDetPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Descuento getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Descuento idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Promocion getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudDetPK != null ? solicitudDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudDet)) {
            return false;
        }
        SolicitudDet other = (SolicitudDet) object;
        if ((this.solicitudDetPK == null && other.solicitudDetPK != null) || (this.solicitudDetPK != null && !this.solicitudDetPK.equals(other.solicitudDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SolicitudDet[ solicitudDetPK=" + solicitudDetPK + " ]";
    }

}
