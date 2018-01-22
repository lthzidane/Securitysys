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
@Table(name = "nota_credi_debi_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaCrediDebiVenta.findAll", query = "SELECT n FROM NotaCrediDebiVenta n")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByIdNotaVenta", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.idNotaVenta = :idNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByNroComprobante", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.nroComprobante = :nroComprobante")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByFechaNotaVenta", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.fechaNotaVenta = :fechaNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByEstadoNotaVenta", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.estadoNotaVenta = :estadoNotaVenta")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByExentaNota", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.exentaNota = :exentaNota")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByGravada10Nota", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.gravada10Nota = :gravada10Nota")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByGravada5Nota", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.gravada5Nota = :gravada5Nota")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByIva10Nota", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.iva10Nota = :iva10Nota")
    , @NamedQuery(name = "NotaCrediDebiVenta.findByIva5Nota", query = "SELECT n FROM NotaCrediDebiVenta n WHERE n.iva5Nota = :iva5Nota")})
public class NotaCrediDebiVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_venta")
    private Integer idNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_comprobante")
    private int nroComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nota_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_nota_venta")
    private String estadoNotaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exenta_nota")
    private int exentaNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada10_nota")
    private int gravada10Nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gravada5_nota")
    private int gravada5Nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva10_nota")
    private int iva10Nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva5_nota")
    private int iva5Nota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notaCrediDebiVenta")
    private List<NotaCrediDebiVentaDet> notaCrediDebiVentaDetList;
    @JoinColumn(name = "id_motivo_nota", referencedColumnName = "id_motivo_nota")
    @ManyToOne(optional = false)
    private MotivoNotaDebi idMotivoNota;
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
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public NotaCrediDebiVenta() {
    }

    public NotaCrediDebiVenta(Integer idNotaVenta) {
        this.idNotaVenta = idNotaVenta;
    }

    public NotaCrediDebiVenta(Integer idNotaVenta, int nroComprobante, Date fechaNotaVenta, String estadoNotaVenta, int exentaNota, int gravada10Nota, int gravada5Nota, int iva10Nota, int iva5Nota) {
        this.idNotaVenta = idNotaVenta;
        this.nroComprobante = nroComprobante;
        this.fechaNotaVenta = fechaNotaVenta;
        this.estadoNotaVenta = estadoNotaVenta;
        this.exentaNota = exentaNota;
        this.gravada10Nota = gravada10Nota;
        this.gravada5Nota = gravada5Nota;
        this.iva10Nota = iva10Nota;
        this.iva5Nota = iva5Nota;
    }

    public Integer getIdNotaVenta() {
        return idNotaVenta;
    }

    public void setIdNotaVenta(Integer idNotaVenta) {
        this.idNotaVenta = idNotaVenta;
    }

    public int getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(int nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public Date getFechaNotaVenta() {
        return fechaNotaVenta;
    }

    public void setFechaNotaVenta(Date fechaNotaVenta) {
        this.fechaNotaVenta = fechaNotaVenta;
    }

    public String getEstadoNotaVenta() {
        return estadoNotaVenta;
    }

    public void setEstadoNotaVenta(String estadoNotaVenta) {
        this.estadoNotaVenta = estadoNotaVenta;
    }

    public int getExentaNota() {
        return exentaNota;
    }

    public void setExentaNota(int exentaNota) {
        this.exentaNota = exentaNota;
    }

    public int getGravada10Nota() {
        return gravada10Nota;
    }

    public void setGravada10Nota(int gravada10Nota) {
        this.gravada10Nota = gravada10Nota;
    }

    public int getGravada5Nota() {
        return gravada5Nota;
    }

    public void setGravada5Nota(int gravada5Nota) {
        this.gravada5Nota = gravada5Nota;
    }

    public int getIva10Nota() {
        return iva10Nota;
    }

    public void setIva10Nota(int iva10Nota) {
        this.iva10Nota = iva10Nota;
    }

    public int getIva5Nota() {
        return iva5Nota;
    }

    public void setIva5Nota(int iva5Nota) {
        this.iva5Nota = iva5Nota;
    }

    @XmlTransient
    public List<NotaCrediDebiVentaDet> getNotaCrediDebiVentaDetList() {
        return notaCrediDebiVentaDetList;
    }

    public void setNotaCrediDebiVentaDetList(List<NotaCrediDebiVentaDet> notaCrediDebiVentaDetList) {
        this.notaCrediDebiVentaDetList = notaCrediDebiVentaDetList;
    }

    public MotivoNotaDebi getIdMotivoNota() {
        return idMotivoNota;
    }

    public void setIdMotivoNota(MotivoNotaDebi idMotivoNota) {
        this.idMotivoNota = idMotivoNota;
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

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaVenta != null ? idNotaVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCrediDebiVenta)) {
            return false;
        }
        NotaCrediDebiVenta other = (NotaCrediDebiVenta) object;
        if ((this.idNotaVenta == null && other.idNotaVenta != null) || (this.idNotaVenta != null && !this.idNotaVenta.equals(other.idNotaVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotaCrediDebiVenta[ idNotaVenta=" + idNotaVenta + " ]";
    }
    
}
