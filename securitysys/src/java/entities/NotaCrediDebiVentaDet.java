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
 * @author acer
 */
@Entity
@Table(name = "nota_credi_debi_venta_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaCrediDebiVentaDet.findAll", query = "SELECT n FROM NotaCrediDebiVentaDet n")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByIdNotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.notaCrediDebiVentaDetPK.idNotaVenta = :idNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByIdSecuencia", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.notaCrediDebiVentaDetPK.idSecuencia = :idSecuencia")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByPrecioNotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.precioNotaVenta = :precioNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByCantidadNotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.cantidadNotaVenta = :cantidadNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByExentaNotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.exentaNotaVenta = :exentaNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByGravada10NotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.gravada10NotaVenta = :gravada10NotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByGravada5NotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.gravada5NotaVenta = :gravada5NotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByIva10NotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.iva10NotaVenta = :iva10NotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVentaDet.findByIva5NotaVenta", query = "SELECT n FROM NotaCrediDebiVentaDet n WHERE n.iva5NotaVenta = :iva5NotaVenta")})
public class NotaCrediDebiVentaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotaCrediDebiVentaDetPK notaCrediDebiVentaDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_nota_venta")
    private int precioNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_nota_venta")
    private int cantidadNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exenta_nota_venta")
    private int exentaNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada10_nota_venta")
    private int gravada10NotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada5_nota_venta")
    private int gravada5NotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva10_nota_venta")
    private int iva10NotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva5_nota_venta")
    private int iva5NotaVenta;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_nota_venta", referencedColumnName = "id_nota_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NotaCrediDebiVenta notaCrediDebiVenta;

    public NotaCrediDebiVentaDet() {
    }

    public NotaCrediDebiVentaDet(NotaCrediDebiVentaDetPK notaCrediDebiVentaDetPK) {
        this.notaCrediDebiVentaDetPK = notaCrediDebiVentaDetPK;
    }

    public NotaCrediDebiVentaDet(NotaCrediDebiVentaDetPK notaCrediDebiVentaDetPK, int precioNotaVenta, int cantidadNotaVenta, int exentaNotaVenta, int gravada10NotaVenta, int gravada5NotaVenta, int iva10NotaVenta, int iva5NotaVenta) {
        this.notaCrediDebiVentaDetPK = notaCrediDebiVentaDetPK;
        this.precioNotaVenta = precioNotaVenta;
        this.cantidadNotaVenta = cantidadNotaVenta;
        this.exentaNotaVenta = exentaNotaVenta;
        this.gravada10NotaVenta = gravada10NotaVenta;
        this.gravada5NotaVenta = gravada5NotaVenta;
        this.iva10NotaVenta = iva10NotaVenta;
        this.iva5NotaVenta = iva5NotaVenta;
    }

    public NotaCrediDebiVentaDet(int idNotaVenta, int idSecuencia) {
        this.notaCrediDebiVentaDetPK = new NotaCrediDebiVentaDetPK(idNotaVenta, idSecuencia);
    }

    public NotaCrediDebiVentaDetPK getNotaCrediDebiVentaDetPK() {
        return notaCrediDebiVentaDetPK;
    }

    public void setNotaCrediDebiVentaDetPK(NotaCrediDebiVentaDetPK notaCrediDebiVentaDetPK) {
        this.notaCrediDebiVentaDetPK = notaCrediDebiVentaDetPK;
    }

    public int getPrecioNotaVenta() {
        return precioNotaVenta;
    }

    public void setPrecioNotaVenta(int precioNotaVenta) {
        this.precioNotaVenta = precioNotaVenta;
    }

    public int getCantidadNotaVenta() {
        return cantidadNotaVenta;
    }

    public void setCantidadNotaVenta(int cantidadNotaVenta) {
        this.cantidadNotaVenta = cantidadNotaVenta;
    }

    public int getExentaNotaVenta() {
        return exentaNotaVenta;
    }

    public void setExentaNotaVenta(int exentaNotaVenta) {
        this.exentaNotaVenta = exentaNotaVenta;
    }

    public int getGravada10NotaVenta() {
        return gravada10NotaVenta;
    }

    public void setGravada10NotaVenta(int gravada10NotaVenta) {
        this.gravada10NotaVenta = gravada10NotaVenta;
    }

    public int getGravada5NotaVenta() {
        return gravada5NotaVenta;
    }

    public void setGravada5NotaVenta(int gravada5NotaVenta) {
        this.gravada5NotaVenta = gravada5NotaVenta;
    }

    public int getIva10NotaVenta() {
        return iva10NotaVenta;
    }

    public void setIva10NotaVenta(int iva10NotaVenta) {
        this.iva10NotaVenta = iva10NotaVenta;
    }

    public int getIva5NotaVenta() {
        return iva5NotaVenta;
    }

    public void setIva5NotaVenta(int iva5NotaVenta) {
        this.iva5NotaVenta = iva5NotaVenta;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public NotaCrediDebiVenta getNotaCrediDebiVenta() {
        return notaCrediDebiVenta;
    }

    public void setNotaCrediDebiVenta(NotaCrediDebiVenta notaCrediDebiVenta) {
        this.notaCrediDebiVenta = notaCrediDebiVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notaCrediDebiVentaDetPK != null ? notaCrediDebiVentaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCrediDebiVentaDet)) {
            return false;
        }
        NotaCrediDebiVentaDet other = (NotaCrediDebiVentaDet) object;
        if ((this.notaCrediDebiVentaDetPK == null && other.notaCrediDebiVentaDetPK != null) || (this.notaCrediDebiVentaDetPK != null && !this.notaCrediDebiVentaDetPK.equals(other.notaCrediDebiVentaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotaCrediDebiVentaDet[ notaCrediDebiVentaDetPK=" + notaCrediDebiVentaDetPK + " ]";
    }
    
}
