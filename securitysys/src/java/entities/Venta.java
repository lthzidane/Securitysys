/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import bean.DataConnect;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "Venta.findByNroComprobante", query = "SELECT v FROM Venta v WHERE v.nroComprobante = :nroComprobante")
    , @NamedQuery(name = "Venta.findByCantidadCuota", query = "SELECT v FROM Venta v WHERE v.cantidadCuota = :cantidadCuota")
    , @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "Venta.findByEstadoVenta", query = "SELECT v FROM Venta v WHERE v.estadoVenta = :estadoVenta")
    , @NamedQuery(name = "Venta.findByExenta", query = "SELECT v FROM Venta v WHERE v.exenta = :exenta")
    , @NamedQuery(name = "Venta.findByGravada5", query = "SELECT v FROM Venta v WHERE v.gravada5 = :gravada5")
    , @NamedQuery(name = "Venta.findByGravada10", query = "SELECT v FROM Venta v WHERE v.gravada10 = :gravada10")
    , @NamedQuery(name = "Venta.findByIva5", query = "SELECT v FROM Venta v WHERE v.iva5 = :iva5")
    , @NamedQuery(name = "Venta.findByIva10", query = "SELECT v FROM Venta v WHERE v.iva10 = :iva10")
    , @NamedQuery(name = "Venta.findBetweenfechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta BETWEEN :startDate AND :endDate")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_venta")
    @GeneratedValue(generator = "VentaSeq")
    @SequenceGenerator(name = "VentaSeq", sequenceName = "venta_id_venta_seq", allocationSize = 1)
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_comprobante")
    private int nroComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_cuota")
    private int cantidadCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado_venta")
    private String estadoVenta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<CtaACobrar> ctaACobrarList;
    @JoinColumn(name = "id_apertura_cierre", referencedColumnName = "id_apertura_cierre")
    @ManyToOne(optional = false)
    private AperturaCierreCaja idAperturaCierre;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto")
    @ManyToOne(optional = false)
    private Presupuesto idPresupuesto;
    @JoinColumn(name = "id_serie_comprobante", referencedColumnName = "id_serie_comprobante")
    @ManyToOne(optional = false)
    private SerieComprobante idSerieComprobante;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_timbrado", referencedColumnName = "id_timbrado")
    @ManyToOne(optional = false)
    private Timbrado idTimbrado;
    @JoinColumn(name = "id_tipo_comprobante", referencedColumnName = "id_tipo_comprobante")
    @ManyToOne(optional = false)
    private TipoComprobante idTipoComprobante;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<NotaCrediDebiVenta> notaCrediDebiVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<VentaDet> ventaDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<NotaRemisionVenta> notaRemisionVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<LibroVenta> libroVentaList;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, int nroComprobante, int cantidadCuota, Date fechaVenta, String estadoVenta, int exenta, int gravada5, int gravada10, int iva5, int iva10) {
        this.idVenta = idVenta;
        this.nroComprobante = nroComprobante;
        this.cantidadCuota = cantidadCuota;
        this.fechaVenta = fechaVenta;
        this.estadoVenta = estadoVenta;
        this.exenta = exenta;
        this.gravada5 = gravada5;
        this.gravada10 = gravada10;
        this.iva5 = iva5;
        this.iva10 = iva10;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getNroComprobante() {
        
        setNroComprobante(getNextValNroComprobante().intValue());
        
        return nroComprobante;
    }

    public void setNroComprobante(int nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public int getCantidadCuota() {
        return cantidadCuota;
    }

    public void setCantidadCuota(int cantidadCuota) {
        this.cantidadCuota = cantidadCuota;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
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

    @XmlTransient
    public List<CtaACobrar> getCtaACobrarList() {
        return ctaACobrarList;
    }

    public void setCtaACobrarList(List<CtaACobrar> ctaACobrarList) {
        this.ctaACobrarList = ctaACobrarList;
    }

    public AperturaCierreCaja getIdAperturaCierre() {
        return idAperturaCierre;
    }

    public void setIdAperturaCierre(AperturaCierreCaja idAperturaCierre) {
        this.idAperturaCierre = idAperturaCierre;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Presupuesto getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Presupuesto idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public SerieComprobante getIdSerieComprobante() {
        return idSerieComprobante;
    }

    public void setIdSerieComprobante(SerieComprobante idSerieComprobante) {
        this.idSerieComprobante = idSerieComprobante;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Timbrado getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(Timbrado idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public TipoComprobante getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(TipoComprobante idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<NotaCrediDebiVenta> getNotaCrediDebiVentaList() {
        return notaCrediDebiVentaList;
    }

    public void setNotaCrediDebiVentaList(List<NotaCrediDebiVenta> notaCrediDebiVentaList) {
        this.notaCrediDebiVentaList = notaCrediDebiVentaList;
    }

    @XmlTransient
    public List<VentaDet> getVentaDetList() {
        return ventaDetList;
    }

    public void setVentaDetList(List<VentaDet> ventaDetList) {
        this.ventaDetList = ventaDetList;
    }

    @XmlTransient
    public List<NotaRemisionVenta> getNotaRemisionVentaList() {
        return notaRemisionVentaList;
    }

    public void setNotaRemisionVentaList(List<NotaRemisionVenta> notaRemisionVentaList) {
        this.notaRemisionVentaList = notaRemisionVentaList;
    }

    @XmlTransient
    public List<LibroVenta> getLibroVentaList() {
        return libroVentaList;
    }

    public void setLibroVentaList(List<LibroVenta> libroVentaList) {
        this.libroVentaList = libroVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Venta[ idVenta=" + idVenta + " ]";
    }
    
    
    public BigInteger getNextValNroComprobante() {
        BigInteger nextVal = new BigInteger("0");
        try {
            Connection con = DataConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT nextval('nro_comprobante_id_nro_comprobante_seq')");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               BigDecimal uv =  rs.getBigDecimal("nextval");
               
               nextVal = uv.toBigInteger();
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener Secuencia de InstalacionDet -->" + ex.getMessage());
        }

        return nextVal;
    }
}
