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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "orden_trabajo_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoDet.findAll", query = "SELECT o FROM OrdenTrabajoDet o"),
    @NamedQuery(name = "OrdenTrabajoDet.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajoDet o WHERE o.ordenTrabajoDetPK.idOrdenTrabajo = :idOrdenTrabajo"),
    @NamedQuery(name = "OrdenTrabajoDet.findByIdSecuencia", query = "SELECT o FROM OrdenTrabajoDet o WHERE o.ordenTrabajoDetPK.idSecuencia = :idSecuencia"),
    @NamedQuery(name = "OrdenTrabajoDet.findByDetalle", query = "SELECT o FROM OrdenTrabajoDet o WHERE o.detalle = :detalle")})
public class OrdenTrabajoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenTrabajoDetPK ordenTrabajoDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_ot", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajo;

    public OrdenTrabajoDet() {
    }

    public OrdenTrabajoDet(OrdenTrabajoDetPK ordenTrabajoDetPK) {
        this.ordenTrabajoDetPK = ordenTrabajoDetPK;
    }

    public OrdenTrabajoDet(OrdenTrabajoDetPK ordenTrabajoDetPK, String detalle) {
        this.ordenTrabajoDetPK = ordenTrabajoDetPK;
        this.detalle = detalle;
    }

    public OrdenTrabajoDet(int idOrdenTrabajo, int idSecuencia) {
        this.ordenTrabajoDetPK = new OrdenTrabajoDetPK(idOrdenTrabajo, idSecuencia);
    }

    public OrdenTrabajoDetPK getOrdenTrabajoDetPK() {
        return ordenTrabajoDetPK;
    }

    public void setOrdenTrabajoDetPK(OrdenTrabajoDetPK ordenTrabajoDetPK) {
        this.ordenTrabajoDetPK = ordenTrabajoDetPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenTrabajoDetPK != null ? ordenTrabajoDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoDet)) {
            return false;
        }
        OrdenTrabajoDet other = (OrdenTrabajoDet) object;
        if ((this.ordenTrabajoDetPK == null && other.ordenTrabajoDetPK != null) || (this.ordenTrabajoDetPK != null && !this.ordenTrabajoDetPK.equals(other.ordenTrabajoDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenTrabajoDet[ ordenTrabajoDetPK=" + ordenTrabajoDetPK + " ]";
    }
    
}
