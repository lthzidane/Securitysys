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
 * @author acer
 */
@Entity
@Table(name = "nota_remision_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotaRemisionVenta.findAll", query = "SELECT n FROM NotaRemisionVenta n")
    , @NamedQuery(name = "NotaRemisionVenta.findByIdRemision", query = "SELECT n FROM NotaRemisionVenta n WHERE n.idRemision = :idRemision")
    , @NamedQuery(name = "NotaRemisionVenta.findByFechaSalida", query = "SELECT n FROM NotaRemisionVenta n WHERE n.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "NotaRemisionVenta.findByFechaLlegada", query = "SELECT n FROM NotaRemisionVenta n WHERE n.fechaLlegada = :fechaLlegada")
    , @NamedQuery(name = "NotaRemisionVenta.findByPuntoSalida", query = "SELECT n FROM NotaRemisionVenta n WHERE n.puntoSalida = :puntoSalida")
    , @NamedQuery(name = "NotaRemisionVenta.findByPuntoLlegada", query = "SELECT n FROM NotaRemisionVenta n WHERE n.puntoLlegada = :puntoLlegada")
    , @NamedQuery(name = "NotaRemisionVenta.findByEstadoRemision", query = "SELECT n FROM NotaRemisionVenta n WHERE n.estadoRemision = :estadoRemision")})
public class NotaRemisionVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_remision")
    private Integer idRemision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "punto_salida")
    private String puntoSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "punto_llegada")
    private String puntoLlegada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_remision")
    private String estadoRemision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notaRemisionVenta")
    private List<NotaRemisionVentaDet> notaRemisionVentaDetList;
    @JoinColumn(name = "id_motivo_nota", referencedColumnName = "id_motivo_nota")
    @ManyToOne(optional = false)
    private MotivoNotaDebi idMotivoNota;
    @JoinColumn(name = "id_movil", referencedColumnName = "id_movil")
    @ManyToOne(optional = false)
    private Moviles idMovil;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_tipo_comprobante", referencedColumnName = "id_tipo_comprobante")
    @ManyToOne(optional = false)
    private TipoComprobante idTipoComprobante;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public NotaRemisionVenta() {
    }

    public NotaRemisionVenta(Integer idRemision) {
        this.idRemision = idRemision;
    }

    public NotaRemisionVenta(Integer idRemision, Date fechaSalida, Date fechaLlegada, String puntoSalida, String puntoLlegada, String estadoRemision) {
        this.idRemision = idRemision;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.puntoSalida = puntoSalida;
        this.puntoLlegada = puntoLlegada;
        this.estadoRemision = estadoRemision;
    }

    public Integer getIdRemision() {
        return idRemision;
    }

    public void setIdRemision(Integer idRemision) {
        this.idRemision = idRemision;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getPuntoSalida() {
        return puntoSalida;
    }

    public void setPuntoSalida(String puntoSalida) {
        this.puntoSalida = puntoSalida;
    }

    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(String puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public String getEstadoRemision() {
        return estadoRemision;
    }

    public void setEstadoRemision(String estadoRemision) {
        this.estadoRemision = estadoRemision;
    }

    @XmlTransient
    public List<NotaRemisionVentaDet> getNotaRemisionVentaDetList() {
        return notaRemisionVentaDetList;
    }

    public void setNotaRemisionVentaDetList(List<NotaRemisionVentaDet> notaRemisionVentaDetList) {
        this.notaRemisionVentaDetList = notaRemisionVentaDetList;
    }

    public MotivoNotaDebi getIdMotivoNota() {
        return idMotivoNota;
    }

    public void setIdMotivoNota(MotivoNotaDebi idMotivoNota) {
        this.idMotivoNota = idMotivoNota;
    }

    public Moviles getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(Moviles idMovil) {
        this.idMovil = idMovil;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
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
        hash += (idRemision != null ? idRemision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaRemisionVenta)) {
            return false;
        }
        NotaRemisionVenta other = (NotaRemisionVenta) object;
        if ((this.idRemision == null && other.idRemision != null) || (this.idRemision != null && !this.idRemision.equals(other.idRemision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NotaRemisionVenta[ idRemision=" + idRemision + " ]";
    }
    
}
