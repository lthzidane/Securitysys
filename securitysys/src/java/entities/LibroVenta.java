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
 * @author acer
 */
@Entity
@Table(name = "libro_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroVenta.findAll", query = "SELECT l FROM LibroVenta l")
    , @NamedQuery(name = "LibroVenta.findByIdLibroVenta", query = "SELECT l FROM LibroVenta l WHERE l.libroVentaPK.idLibroVenta = :idLibroVenta")
    , @NamedQuery(name = "LibroVenta.findByIdVenta", query = "SELECT l FROM LibroVenta l WHERE l.libroVentaPK.idVenta = :idVenta")
    , @NamedQuery(name = "LibroVenta.findByRucCliente", query = "SELECT l FROM LibroVenta l WHERE l.rucCliente = :rucCliente")
    , @NamedQuery(name = "LibroVenta.findByVentaExenta", query = "SELECT l FROM LibroVenta l WHERE l.ventaExenta = :ventaExenta")
    , @NamedQuery(name = "LibroVenta.findByVentaGravada10", query = "SELECT l FROM LibroVenta l WHERE l.ventaGravada10 = :ventaGravada10")
    , @NamedQuery(name = "LibroVenta.findByVentaGravada5", query = "SELECT l FROM LibroVenta l WHERE l.ventaGravada5 = :ventaGravada5")
    , @NamedQuery(name = "LibroVenta.findByIvaGravada10", query = "SELECT l FROM LibroVenta l WHERE l.ivaGravada10 = :ivaGravada10")
    , @NamedQuery(name = "LibroVenta.findByIvaGravada5", query = "SELECT l FROM LibroVenta l WHERE l.ivaGravada5 = :ivaGravada5")
    , @NamedQuery(name = "LibroVenta.findByEstadoLibroVenta", query = "SELECT l FROM LibroVenta l WHERE l.estadoLibroVenta = :estadoLibroVenta")
    , @NamedQuery(name = "LibroVenta.findByPeriodoVenta", query = "SELECT l FROM LibroVenta l WHERE l.periodoVenta = :periodoVenta")})
public class LibroVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroVentaPK libroVentaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ruc_cliente")
    private String rucCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_exenta")
    private int ventaExenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_gravada10")
    private int ventaGravada10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_gravada5")
    private int ventaGravada5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva_gravada10")
    private int ivaGravada10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva_gravada5")
    private int ivaGravada5;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_libro_venta")
    private String estadoLibroVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "periodo_venta")
    private String periodoVenta;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public LibroVenta() {
    }

    public LibroVenta(LibroVentaPK libroVentaPK) {
        this.libroVentaPK = libroVentaPK;
    }

    public LibroVenta(LibroVentaPK libroVentaPK, String rucCliente, int ventaExenta, int ventaGravada10, int ventaGravada5, int ivaGravada10, int ivaGravada5, String estadoLibroVenta, String periodoVenta) {
        this.libroVentaPK = libroVentaPK;
        this.rucCliente = rucCliente;
        this.ventaExenta = ventaExenta;
        this.ventaGravada10 = ventaGravada10;
        this.ventaGravada5 = ventaGravada5;
        this.ivaGravada10 = ivaGravada10;
        this.ivaGravada5 = ivaGravada5;
        this.estadoLibroVenta = estadoLibroVenta;
        this.periodoVenta = periodoVenta;
    }

    public LibroVenta(int idLibroVenta, int idVenta) {
        this.libroVentaPK = new LibroVentaPK(idLibroVenta, idVenta);
    }

    public LibroVentaPK getLibroVentaPK() {
        return libroVentaPK;
    }

    public void setLibroVentaPK(LibroVentaPK libroVentaPK) {
        this.libroVentaPK = libroVentaPK;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public int getVentaExenta() {
        return ventaExenta;
    }

    public void setVentaExenta(int ventaExenta) {
        this.ventaExenta = ventaExenta;
    }

    public int getVentaGravada10() {
        return ventaGravada10;
    }

    public void setVentaGravada10(int ventaGravada10) {
        this.ventaGravada10 = ventaGravada10;
    }

    public int getVentaGravada5() {
        return ventaGravada5;
    }

    public void setVentaGravada5(int ventaGravada5) {
        this.ventaGravada5 = ventaGravada5;
    }

    public int getIvaGravada10() {
        return ivaGravada10;
    }

    public void setIvaGravada10(int ivaGravada10) {
        this.ivaGravada10 = ivaGravada10;
    }

    public int getIvaGravada5() {
        return ivaGravada5;
    }

    public void setIvaGravada5(int ivaGravada5) {
        this.ivaGravada5 = ivaGravada5;
    }

    public String getEstadoLibroVenta() {
        return estadoLibroVenta;
    }

    public void setEstadoLibroVenta(String estadoLibroVenta) {
        this.estadoLibroVenta = estadoLibroVenta;
    }

    public String getPeriodoVenta() {
        return periodoVenta;
    }

    public void setPeriodoVenta(String periodoVenta) {
        this.periodoVenta = periodoVenta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libroVentaPK != null ? libroVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroVenta)) {
            return false;
        }
        LibroVenta other = (LibroVenta) object;
        if ((this.libroVentaPK == null && other.libroVentaPK != null) || (this.libroVentaPK != null && !this.libroVentaPK.equals(other.libroVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LibroVenta[ libroVentaPK=" + libroVentaPK + " ]";
    }
    
}
