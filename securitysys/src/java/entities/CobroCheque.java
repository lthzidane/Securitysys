/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "cobro_cheque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobroCheque.findAll", query = "SELECT c FROM CobroCheque c")
    , @NamedQuery(name = "CobroCheque.findByIdCobroCheque", query = "SELECT c FROM CobroCheque c WHERE c.cobroChequePK.idCobroCheque = :idCobroCheque")
    , @NamedQuery(name = "CobroCheque.findByIdCobro", query = "SELECT c FROM CobroCheque c WHERE c.cobroChequePK.idCobro = :idCobro")
    , @NamedQuery(name = "CobroCheque.findByIdCtaACobrar", query = "SELECT c FROM CobroCheque c WHERE c.cobroChequePK.idCtaACobrar = :idCtaACobrar")
    , @NamedQuery(name = "CobroCheque.findByIdVenta", query = "SELECT c FROM CobroCheque c WHERE c.cobroChequePK.idVenta = :idVenta")
    , @NamedQuery(name = "CobroCheque.findByFechaEmision", query = "SELECT c FROM CobroCheque c WHERE c.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "CobroCheque.findByFechaVencimiento", query = "SELECT c FROM CobroCheque c WHERE c.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "CobroCheque.findByTitularCheque", query = "SELECT c FROM CobroCheque c WHERE c.titularCheque = :titularCheque")
    , @NamedQuery(name = "CobroCheque.findByNroCheque", query = "SELECT c FROM CobroCheque c WHERE c.nroCheque = :nroCheque")
    , @NamedQuery(name = "CobroCheque.findByMontoCheque", query = "SELECT c FROM CobroCheque c WHERE c.montoCheque = :montoCheque")})
public class CobroCheque implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CobroChequePK cobroChequePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titular_cheque")
    private String titularCheque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nro_cheque")
    private String nroCheque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cheque")
    private int montoCheque;
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
    @ManyToOne(optional = false)
    private Banco idBanco;
    @JoinColumns({
        @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro", insertable = false, updatable = false)
        , @JoinColumn(name = "id_cta_a_cobrar", referencedColumnName = "id_cta_a_cobrar", insertable = false, updatable = false)
        , @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CobroDet cobroDet;

    public CobroCheque() {
    }

    public CobroCheque(CobroChequePK cobroChequePK) {
        this.cobroChequePK = cobroChequePK;
    }

    public CobroCheque(CobroChequePK cobroChequePK, Date fechaEmision, Date fechaVencimiento, String titularCheque, String nroCheque, int montoCheque) {
        this.cobroChequePK = cobroChequePK;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.titularCheque = titularCheque;
        this.nroCheque = nroCheque;
        this.montoCheque = montoCheque;
    }

    public CobroCheque(int idCobroCheque, int idCobro, int idCtaACobrar, int idVenta) {
        this.cobroChequePK = new CobroChequePK(idCobroCheque, idCobro, idCtaACobrar, idVenta);
    }

    public CobroChequePK getCobroChequePK() {
        return cobroChequePK;
    }

    public void setCobroChequePK(CobroChequePK cobroChequePK) {
        this.cobroChequePK = cobroChequePK;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTitularCheque() {
        return titularCheque;
    }

    public void setTitularCheque(String titularCheque) {
        this.titularCheque = titularCheque;
    }

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
        this.nroCheque = nroCheque;
    }

    public int getMontoCheque() {
        return montoCheque;
    }

    public void setMontoCheque(int montoCheque) {
        this.montoCheque = montoCheque;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public CobroDet getCobroDet() {
        return cobroDet;
    }

    public void setCobroDet(CobroDet cobroDet) {
        this.cobroDet = cobroDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobroChequePK != null ? cobroChequePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroCheque)) {
            return false;
        }
        CobroCheque other = (CobroCheque) object;
        if ((this.cobroChequePK == null && other.cobroChequePK != null) || (this.cobroChequePK != null && !this.cobroChequePK.equals(other.cobroChequePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CobroCheque[ cobroChequePK=" + cobroChequePK + " ]";
    }
    
}
