/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "cobro_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobroDet.findAll", query = "SELECT c FROM CobroDet c"),
    @NamedQuery(name = "CobroDet.findByIdCobro", query = "SELECT c FROM CobroDet c WHERE c.cobroDetPK.idCobro = :idCobro"),
    @NamedQuery(name = "CobroDet.findByIdCtaACobrar", query = "SELECT c FROM CobroDet c WHERE c.cobroDetPK.idCtaACobrar = :idCtaACobrar"),
    @NamedQuery(name = "CobroDet.findByIdVenta", query = "SELECT c FROM CobroDet c WHERE c.cobroDetPK.idVenta = :idVenta"),
    @NamedQuery(name = "CobroDet.findByMontoCobroDet", query = "SELECT c FROM CobroDet c WHERE c.montoCobroDet = :montoCobroDet")})
public class CobroDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CobroDetPK cobroDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cobro_det")
    private int montoCobroDet;
    @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cobro cobro;
    @JoinColumns({
        @JoinColumn(name = "id_cta_a_cobrar", referencedColumnName = "id_cta_a_cobrar", insertable = false, updatable = false),
        @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CtaACobrar ctaACobrar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobroDet")
    private List<CobroCheque> cobroChequeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobroDet")
    private List<CobroTarjeta> cobroTarjetaList;

    public CobroDet() {
    }

    public CobroDet(CobroDetPK cobroDetPK) {
        this.cobroDetPK = cobroDetPK;
    }

    public CobroDet(CobroDetPK cobroDetPK, int montoCobroDet) {
        this.cobroDetPK = cobroDetPK;
        this.montoCobroDet = montoCobroDet;
    }

    public CobroDet(int idCobro, int idCtaACobrar, int idVenta) {
        this.cobroDetPK = new CobroDetPK(idCobro, idCtaACobrar, idVenta);
    }

    public CobroDetPK getCobroDetPK() {
        return cobroDetPK;
    }

    public void setCobroDetPK(CobroDetPK cobroDetPK) {
        this.cobroDetPK = cobroDetPK;
    }

    public int getMontoCobroDet() {
        return montoCobroDet;
    }

    public void setMontoCobroDet(int montoCobroDet) {
        this.montoCobroDet = montoCobroDet;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }

    public CtaACobrar getCtaACobrar() {
        return ctaACobrar;
    }

    public void setCtaACobrar(CtaACobrar ctaACobrar) {
        this.ctaACobrar = ctaACobrar;
    }

    @XmlTransient
    public List<CobroCheque> getCobroChequeList() {
        return cobroChequeList;
    }

    public void setCobroChequeList(List<CobroCheque> cobroChequeList) {
        this.cobroChequeList = cobroChequeList;
    }

    @XmlTransient
    public List<CobroTarjeta> getCobroTarjetaList() {
        return cobroTarjetaList;
    }

    public void setCobroTarjetaList(List<CobroTarjeta> cobroTarjetaList) {
        this.cobroTarjetaList = cobroTarjetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobroDetPK != null ? cobroDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroDet)) {
            return false;
        }
        CobroDet other = (CobroDet) object;
        if ((this.cobroDetPK == null && other.cobroDetPK != null) || (this.cobroDetPK != null && !this.cobroDetPK.equals(other.cobroDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CobroDet[ cobroDetPK=" + cobroDetPK + " ]";
    }
    
}
