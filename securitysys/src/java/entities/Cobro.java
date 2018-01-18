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
@Table(name = "cobro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobro.findAll", query = "SELECT c FROM Cobro c")
    , @NamedQuery(name = "Cobro.findByIdCobro", query = "SELECT c FROM Cobro c WHERE c.idCobro = :idCobro")
    , @NamedQuery(name = "Cobro.findByFechaCobro", query = "SELECT c FROM Cobro c WHERE c.fechaCobro = :fechaCobro")
    , @NamedQuery(name = "Cobro.findByNroRecibo", query = "SELECT c FROM Cobro c WHERE c.nroRecibo = :nroRecibo")
    , @NamedQuery(name = "Cobro.findByEfectivo", query = "SELECT c FROM Cobro c WHERE c.efectivo = :efectivo")
    , @NamedQuery(name = "Cobro.findByEstadoCobro", query = "SELECT c FROM Cobro c WHERE c.estadoCobro = :estadoCobro")})
public class Cobro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cobro")
    private Integer idCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cobro")
    @Temporal(TemporalType.DATE)
    private Date fechaCobro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nro_recibo")
    private String nroRecibo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "efectivo")
    private int efectivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_cobro")
    private String estadoCobro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobro")
    private List<CobroDet> cobroDetList;
    @JoinColumn(name = "id_apertura_cierre", referencedColumnName = "id_apertura_cierre")
    @ManyToOne(optional = false)
    private AperturaCierreCaja idAperturaCierre;
    @JoinColumn(name = "id_forma_cobro", referencedColumnName = "id_forma_cobro")
    @ManyToOne(optional = false)
    private FormaCobro idFormaCobro;

    public Cobro() {
    }

    public Cobro(Integer idCobro) {
        this.idCobro = idCobro;
    }

    public Cobro(Integer idCobro, Date fechaCobro, String nroRecibo, int efectivo, String estadoCobro) {
        this.idCobro = idCobro;
        this.fechaCobro = fechaCobro;
        this.nroRecibo = nroRecibo;
        this.efectivo = efectivo;
        this.estadoCobro = estadoCobro;
    }

    public Integer getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Integer idCobro) {
        this.idCobro = idCobro;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public String getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(String nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

    public String getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(String estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    @XmlTransient
    public List<CobroDet> getCobroDetList() {
        return cobroDetList;
    }

    public void setCobroDetList(List<CobroDet> cobroDetList) {
        this.cobroDetList = cobroDetList;
    }

    public AperturaCierreCaja getIdAperturaCierre() {
        return idAperturaCierre;
    }

    public void setIdAperturaCierre(AperturaCierreCaja idAperturaCierre) {
        this.idAperturaCierre = idAperturaCierre;
    }

    public FormaCobro getIdFormaCobro() {
        return idFormaCobro;
    }

    public void setIdFormaCobro(FormaCobro idFormaCobro) {
        this.idFormaCobro = idFormaCobro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobro != null ? idCobro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobro)) {
            return false;
        }
        Cobro other = (Cobro) object;
        if ((this.idCobro == null && other.idCobro != null) || (this.idCobro != null && !this.idCobro.equals(other.idCobro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cobro[ idCobro=" + idCobro + " ]";
    }
    
}
