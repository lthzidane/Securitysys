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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "cta_a_cobrar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtaACobrar.findAll", query = "SELECT c FROM CtaACobrar c")
    , @NamedQuery(name = "CtaACobrar.findByIdCtaACobrar", query = "SELECT c FROM CtaACobrar c WHERE c.ctaACobrarPK.idCtaACobrar = :idCtaACobrar")
    , @NamedQuery(name = "CtaACobrar.findByIdVenta", query = "SELECT c FROM CtaACobrar c WHERE c.ctaACobrarPK.idVenta = :idVenta")
    , @NamedQuery(name = "CtaACobrar.findByNroCuota", query = "SELECT c FROM CtaACobrar c WHERE c.nroCuota = :nroCuota")
    , @NamedQuery(name = "CtaACobrar.findByMontoACobrar", query = "SELECT c FROM CtaACobrar c WHERE c.montoACobrar = :montoACobrar")
    , @NamedQuery(name = "CtaACobrar.findBySaldoACobrar", query = "SELECT c FROM CtaACobrar c WHERE c.saldoACobrar = :saldoACobrar")
    , @NamedQuery(name = "CtaACobrar.findByVencimientoACobrar", query = "SELECT c FROM CtaACobrar c WHERE c.vencimientoACobrar = :vencimientoACobrar")
    , @NamedQuery(name = "CtaACobrar.findByEstadoACobrar", query = "SELECT c FROM CtaACobrar c WHERE c.estadoACobrar = :estadoACobrar")})
public class CtaACobrar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CtaACobrarPK ctaACobrarPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_cuota")
    private int nroCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_a_cobrar")
    private int montoACobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_a_cobrar")
    private int saldoACobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vencimiento_a_cobrar")
    @Temporal(TemporalType.DATE)
    private Date vencimientoACobrar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_a_cobrar")
    private String estadoACobrar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctaACobrar")
    private List<CobroDet> cobroDetList;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public CtaACobrar() {
    }

    public CtaACobrar(CtaACobrarPK ctaACobrarPK) {
        this.ctaACobrarPK = ctaACobrarPK;
    }

    public CtaACobrar(CtaACobrarPK ctaACobrarPK, int nroCuota, int montoACobrar, int saldoACobrar, Date vencimientoACobrar, String estadoACobrar) {
        this.ctaACobrarPK = ctaACobrarPK;
        this.nroCuota = nroCuota;
        this.montoACobrar = montoACobrar;
        this.saldoACobrar = saldoACobrar;
        this.vencimientoACobrar = vencimientoACobrar;
        this.estadoACobrar = estadoACobrar;
    }

    public CtaACobrar(int idCtaACobrar, int idVenta) {
        this.ctaACobrarPK = new CtaACobrarPK(idCtaACobrar, idVenta);
    }

    public CtaACobrarPK getCtaACobrarPK() {
        return ctaACobrarPK;
    }

    public void setCtaACobrarPK(CtaACobrarPK ctaACobrarPK) {
        this.ctaACobrarPK = ctaACobrarPK;
    }

    public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public int getMontoACobrar() {
        return montoACobrar;
    }

    public void setMontoACobrar(int montoACobrar) {
        this.montoACobrar = montoACobrar;
    }

    public int getSaldoACobrar() {
        return saldoACobrar;
    }

    public void setSaldoACobrar(int saldoACobrar) {
        this.saldoACobrar = saldoACobrar;
    }

    public Date getVencimientoACobrar() {
        return vencimientoACobrar;
    }

    public void setVencimientoACobrar(Date vencimientoACobrar) {
        this.vencimientoACobrar = vencimientoACobrar;
    }

    public String getEstadoACobrar() {
        return estadoACobrar;
    }

    public void setEstadoACobrar(String estadoACobrar) {
        this.estadoACobrar = estadoACobrar;
    }

    @XmlTransient
    public List<CobroDet> getCobroDetList() {
        return cobroDetList;
    }

    public void setCobroDetList(List<CobroDet> cobroDetList) {
        this.cobroDetList = cobroDetList;
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
        hash += (ctaACobrarPK != null ? ctaACobrarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtaACobrar)) {
            return false;
        }
        CtaACobrar other = (CtaACobrar) object;
        if ((this.ctaACobrarPK == null && other.ctaACobrarPK != null) || (this.ctaACobrarPK != null && !this.ctaACobrarPK.equals(other.ctaACobrarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CtaACobrar[ ctaACobrarPK=" + ctaACobrarPK + " ]";
    }
    
}
