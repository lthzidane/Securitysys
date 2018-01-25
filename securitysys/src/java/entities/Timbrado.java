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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author expsee
 */
@Entity
@Table(name = "timbrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timbrado.findAll", query = "SELECT t FROM Timbrado t")
    , @NamedQuery(name = "Timbrado.findByIdTimbrado", query = "SELECT t FROM Timbrado t WHERE t.idTimbrado = :idTimbrado")
    , @NamedQuery(name = "Timbrado.findByFechaDesde", query = "SELECT t FROM Timbrado t WHERE t.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "Timbrado.findByFechaHasta", query = "SELECT t FROM Timbrado t WHERE t.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "Timbrado.findByNroDesde", query = "SELECT t FROM Timbrado t WHERE t.nroDesde = :nroDesde")
    , @NamedQuery(name = "Timbrado.findByNroHasta", query = "SELECT t FROM Timbrado t WHERE t.nroHasta = :nroHasta")
    , @NamedQuery(name = "Timbrado.findByUltimoNro", query = "SELECT t FROM Timbrado t WHERE t.ultimoNro = :ultimoNro")
    , @NamedQuery(name = "Timbrado.findByNroTimbrado", query = "SELECT t FROM Timbrado t WHERE t.nroTimbrado = :nroTimbrado")})
public class Timbrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_timbrado")
    @GeneratedValue(generator = "TimbradoSeq")
    @SequenceGenerator(name = "TimbradoSeq", sequenceName = "timbrado_id_timbrado_seq", allocationSize = 1)
    private Integer idTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_desde")
    private int nroDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_hasta")
    private int nroHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultimo_nro")
    private int ultimoNro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_timbrado")
    private int nroTimbrado;
    @JoinColumn(name = "id_tipo_comprobante", referencedColumnName = "id_tipo_comprobante")
    @ManyToOne(optional = false)
    private TipoComprobante idTipoComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimbrado")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimbrado")
    private List<NotaCrediDebiVenta> notaCrediDebiVentaList;

    public Timbrado() {
    }

    public Timbrado(Integer idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public Timbrado(Integer idTimbrado, Date fechaDesde, Date fechaHasta, int nroDesde, int nroHasta, int ultimoNro, int nroTimbrado) {
        this.idTimbrado = idTimbrado;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.nroDesde = nroDesde;
        this.nroHasta = nroHasta;
        this.ultimoNro = ultimoNro;
        this.nroTimbrado = nroTimbrado;
    }

    public Integer getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(Integer idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getNroDesde() {
        return nroDesde;
    }

    public void setNroDesde(int nroDesde) {
        this.nroDesde = nroDesde;
    }

    public int getNroHasta() {
        return nroHasta;
    }

    public void setNroHasta(int nroHasta) {
        this.nroHasta = nroHasta;
    }

    public int getUltimoNro() {
        return ultimoNro;
    }

    public void setUltimoNro(int ultimoNro) {
        this.ultimoNro = ultimoNro;
    }

    public int getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(int nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public TipoComprobante getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(TipoComprobante idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<NotaCrediDebiVenta> getNotaCrediDebiVentaList() {
        return notaCrediDebiVentaList;
    }

    public void setNotaCrediDebiVentaList(List<NotaCrediDebiVenta> notaCrediDebiVentaList) {
        this.notaCrediDebiVentaList = notaCrediDebiVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTimbrado != null ? idTimbrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timbrado)) {
            return false;
        }
        Timbrado other = (Timbrado) object;
        if ((this.idTimbrado == null && other.idTimbrado != null) || (this.idTimbrado != null && !this.idTimbrado.equals(other.idTimbrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Timbrado[ idTimbrado=" + idTimbrado + " ]";
    }

}
