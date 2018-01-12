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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "nota_remision_venta_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaRemisionVentaDet.findAll", query = "SELECT n FROM NotaRemisionVentaDet n"),
    @NamedQuery(name = "NotaRemisionVentaDet.findByIdRemision", query = "SELECT n FROM NotaRemisionVentaDet n WHERE n.notaRemisionVentaDetPK.idRemision = :idRemision"),
    @NamedQuery(name = "NotaRemisionVentaDet.findByIdSecuencia", query = "SELECT n FROM NotaRemisionVentaDet n WHERE n.notaRemisionVentaDetPK.idSecuencia = :idSecuencia"),
    @NamedQuery(name = "NotaRemisionVentaDet.findByCantidadRemision", query = "SELECT n FROM NotaRemisionVentaDet n WHERE n.cantidadRemision = :cantidadRemision")})
public class NotaRemisionVentaDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotaRemisionVentaDetPK notaRemisionVentaDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_remision")
    private int cantidadRemision;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_remision", referencedColumnName = "id_remision", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotaRemisionVenta notaRemisionVenta;

    public NotaRemisionVentaDet() {
    }

    public NotaRemisionVentaDet(NotaRemisionVentaDetPK notaRemisionVentaDetPK) {
        this.notaRemisionVentaDetPK = notaRemisionVentaDetPK;
    }

    public NotaRemisionVentaDet(NotaRemisionVentaDetPK notaRemisionVentaDetPK, int cantidadRemision) {
        this.notaRemisionVentaDetPK = notaRemisionVentaDetPK;
        this.cantidadRemision = cantidadRemision;
    }

    public NotaRemisionVentaDet(int idRemision, int idSecuencia) {
        this.notaRemisionVentaDetPK = new NotaRemisionVentaDetPK(idRemision, idSecuencia);
    }

    public NotaRemisionVentaDetPK getNotaRemisionVentaDetPK() {
        return notaRemisionVentaDetPK;
    }

    public void setNotaRemisionVentaDetPK(NotaRemisionVentaDetPK notaRemisionVentaDetPK) {
        this.notaRemisionVentaDetPK = notaRemisionVentaDetPK;
    }

    public int getCantidadRemision() {
        return cantidadRemision;
    }

    public void setCantidadRemision(int cantidadRemision) {
        this.cantidadRemision = cantidadRemision;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public NotaRemisionVenta getNotaRemisionVenta() {
        return notaRemisionVenta;
    }

    public void setNotaRemisionVenta(NotaRemisionVenta notaRemisionVenta) {
        this.notaRemisionVenta = notaRemisionVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notaRemisionVentaDetPK != null ? notaRemisionVentaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaRemisionVentaDet)) {
            return false;
        }
        NotaRemisionVentaDet other = (NotaRemisionVentaDet) object;
        if ((this.notaRemisionVentaDetPK == null && other.notaRemisionVentaDetPK != null) || (this.notaRemisionVentaDetPK != null && !this.notaRemisionVentaDetPK.equals(other.notaRemisionVentaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotaRemisionVentaDet[ notaRemisionVentaDetPK=" + notaRemisionVentaDetPK + " ]";
    }
    
}
