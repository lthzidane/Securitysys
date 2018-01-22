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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "apertura_cierre_caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AperturaCierreCaja.findAll", query = "SELECT a FROM AperturaCierreCaja a")
    , @NamedQuery(name = "AperturaCierreCaja.findByIdAperturaCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.idAperturaCierre = :idAperturaCierre")
    , @NamedQuery(name = "AperturaCierreCaja.findByFechaApertura", query = "SELECT a FROM AperturaCierreCaja a WHERE a.fechaApertura = :fechaApertura")
    , @NamedQuery(name = "AperturaCierreCaja.findByHoraApertura", query = "SELECT a FROM AperturaCierreCaja a WHERE a.horaApertura = :horaApertura")
    , @NamedQuery(name = "AperturaCierreCaja.findByFechaCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.fechaCierre = :fechaCierre")
    , @NamedQuery(name = "AperturaCierreCaja.findByHoraCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.horaCierre = :horaCierre")
    , @NamedQuery(name = "AperturaCierreCaja.findByMontoApertura", query = "SELECT a FROM AperturaCierreCaja a WHERE a.montoApertura = :montoApertura")})
public class AperturaCierreCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_apertura_cierre")
    private Integer idAperturaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_apertura")
    @Temporal(TemporalType.TIME)
    private Date horaApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_cierre")
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_apertura")
    private int montoApertura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaCierre")
    private List<Cobro> cobroList;
    @JoinColumn(name = "id_caja", referencedColumnName = "id_caja")
    @ManyToOne(optional = false)
    private Caja idCaja;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaCierre")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aperturaCierreCaja")
    private List<Arqueo> arqueoList;

    public AperturaCierreCaja() {
    }

    public AperturaCierreCaja(Integer idAperturaCierre) {
        this.idAperturaCierre = idAperturaCierre;
    }

    public AperturaCierreCaja(Integer idAperturaCierre, Date fechaApertura, Date horaApertura, Date fechaCierre, Date horaCierre, int montoApertura) {
        this.idAperturaCierre = idAperturaCierre;
        this.fechaApertura = fechaApertura;
        this.horaApertura = horaApertura;
        this.fechaCierre = fechaCierre;
        this.horaCierre = horaCierre;
        this.montoApertura = montoApertura;
    }

    public Integer getIdAperturaCierre() {
        return idAperturaCierre;
    }

    public void setIdAperturaCierre(Integer idAperturaCierre) {
        this.idAperturaCierre = idAperturaCierre;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getMontoApertura() {
        return montoApertura;
    }

    public void setMontoApertura(int montoApertura) {
        this.montoApertura = montoApertura;
    }

    @XmlTransient
    public List<Cobro> getCobroList() {
        return cobroList;
    }

    public void setCobroList(List<Cobro> cobroList) {
        this.cobroList = cobroList;
    }

    public Caja getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Caja idCaja) {
        this.idCaja = idCaja;
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
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Arqueo> getArqueoList() {
        return arqueoList;
    }

    public void setArqueoList(List<Arqueo> arqueoList) {
        this.arqueoList = arqueoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAperturaCierre != null ? idAperturaCierre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AperturaCierreCaja)) {
            return false;
        }
        AperturaCierreCaja other = (AperturaCierreCaja) object;
        if ((this.idAperturaCierre == null && other.idAperturaCierre != null) || (this.idAperturaCierre != null && !this.idAperturaCierre.equals(other.idAperturaCierre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AperturaCierreCaja[ idAperturaCierre=" + idAperturaCierre + " ]";
    }
    
}
