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
 * @author acer
 */
@Entity
@Table(name = "presupuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p")
    , @NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.idPresupuesto = :idPresupuesto")
    , @NamedQuery(name = "Presupuesto.findByFecha", query = "SELECT p FROM Presupuesto p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Presupuesto.findByPlazo", query = "SELECT p FROM Presupuesto p WHERE p.plazo = :plazo")
    , @NamedQuery(name = "Presupuesto.findByValidez", query = "SELECT p FROM Presupuesto p WHERE p.validez = :validez")
    , @NamedQuery(name = "Presupuesto.findByExenta", query = "SELECT p FROM Presupuesto p WHERE p.exenta = :exenta")
    , @NamedQuery(name = "Presupuesto.findByGravada5", query = "SELECT p FROM Presupuesto p WHERE p.gravada5 = :gravada5")
    , @NamedQuery(name = "Presupuesto.findByGravada10", query = "SELECT p FROM Presupuesto p WHERE p.gravada10 = :gravada10")
    , @NamedQuery(name = "Presupuesto.findByIva5", query = "SELECT p FROM Presupuesto p WHERE p.iva5 = :iva5")
    , @NamedQuery(name = "Presupuesto.findByIva10", query = "SELECT p FROM Presupuesto p WHERE p.iva10 = :iva10")})
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presupuesto")
    private Integer idPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "plazo")
    private String plazo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "validez")
    private String validez;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exenta")
    private int exenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada5")
    private int gravada5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada10")
    private int gravada10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva5")
    private int iva5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva10")
    private int iva10;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "presupuesto")
    private Promocion promocion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuesto")
    private List<PresupuestoDet> presupuestoDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Diagnostico id;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuesto")
    private List<OrdenTrabajo> ordenTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuesto")
    private List<Venta> ventaList;

    public Presupuesto() {
    }

    public Presupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Presupuesto(Integer idPresupuesto, Date fecha, String plazo, String validez, int exenta, int gravada5, int gravada10, int iva5, int iva10) {
        this.idPresupuesto = idPresupuesto;
        this.fecha = fecha;
        this.plazo = plazo;
        this.validez = validez;
        this.exenta = exenta;
        this.gravada5 = gravada5;
        this.gravada10 = gravada10;
        this.iva5 = iva5;
        this.iva10 = iva10;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getValidez() {
        return validez;
    }

    public void setValidez(String validez) {
        this.validez = validez;
    }

    public int getExenta() {
        return exenta;
    }

    public void setExenta(int exenta) {
        this.exenta = exenta;
    }

    public int getGravada5() {
        return gravada5;
    }

    public void setGravada5(int gravada5) {
        this.gravada5 = gravada5;
    }

    public int getGravada10() {
        return gravada10;
    }

    public void setGravada10(int gravada10) {
        this.gravada10 = gravada10;
    }

    public int getIva5() {
        return iva5;
    }

    public void setIva5(int iva5) {
        this.iva5 = iva5;
    }

    public int getIva10() {
        return iva10;
    }

    public void setIva10(int iva10) {
        this.iva10 = iva10;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    @XmlTransient
    public List<PresupuestoDet> getPresupuestoDetList() {
        return presupuestoDetList;
    }

    public void setPresupuestoDetList(List<PresupuestoDet> presupuestoDetList) {
        this.presupuestoDetList = presupuestoDetList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Diagnostico getId() {
        return id;
    }

    public void setId(Diagnostico id) {
        this.id = id;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
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
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Presupuesto[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
