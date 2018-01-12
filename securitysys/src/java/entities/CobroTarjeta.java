/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "cobro_tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobroTarjeta.findAll", query = "SELECT c FROM CobroTarjeta c"),
    @NamedQuery(name = "CobroTarjeta.findByIdCobroTarjeta", query = "SELECT c FROM CobroTarjeta c WHERE c.cobroTarjetaPK.idCobroTarjeta = :idCobroTarjeta"),
    @NamedQuery(name = "CobroTarjeta.findByIdCobro", query = "SELECT c FROM CobroTarjeta c WHERE c.cobroTarjetaPK.idCobro = :idCobro"),
    @NamedQuery(name = "CobroTarjeta.findByIdCtaACobrar", query = "SELECT c FROM CobroTarjeta c WHERE c.cobroTarjetaPK.idCtaACobrar = :idCtaACobrar"),
    @NamedQuery(name = "CobroTarjeta.findByIdVenta", query = "SELECT c FROM CobroTarjeta c WHERE c.cobroTarjetaPK.idVenta = :idVenta"),
    @NamedQuery(name = "CobroTarjeta.findByMontoCobroTarjeta", query = "SELECT c FROM CobroTarjeta c WHERE c.montoCobroTarjeta = :montoCobroTarjeta"),
    @NamedQuery(name = "CobroTarjeta.findByCuotaTarjeta", query = "SELECT c FROM CobroTarjeta c WHERE c.cuotaTarjeta = :cuotaTarjeta"),
    @NamedQuery(name = "CobroTarjeta.findByCodAutorizacion", query = "SELECT c FROM CobroTarjeta c WHERE c.codAutorizacion = :codAutorizacion"),
    @NamedQuery(name = "CobroTarjeta.findByVaucherNro", query = "SELECT c FROM CobroTarjeta c WHERE c.vaucherNro = :vaucherNro")})
public class CobroTarjeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CobroTarjetaPK cobroTarjetaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cobro_tarjeta")
    private int montoCobroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuota_tarjeta")
    private int cuotaTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_autorizacion")
    private int codAutorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vaucher_nro")
    private int vaucherNro;
    @JoinColumns({
        @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro", insertable = false, updatable = false),
        @JoinColumn(name = "id_cta_a_cobrar", referencedColumnName = "id_cta_a_cobrar", insertable = false, updatable = false),
        @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CobroDet cobroDet;
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta")
    @ManyToOne(optional = false)
    private Tarjeta idTarjeta;

    public CobroTarjeta() {
    }

    public CobroTarjeta(CobroTarjetaPK cobroTarjetaPK) {
        this.cobroTarjetaPK = cobroTarjetaPK;
    }

    public CobroTarjeta(CobroTarjetaPK cobroTarjetaPK, int montoCobroTarjeta, int cuotaTarjeta, int codAutorizacion, int vaucherNro) {
        this.cobroTarjetaPK = cobroTarjetaPK;
        this.montoCobroTarjeta = montoCobroTarjeta;
        this.cuotaTarjeta = cuotaTarjeta;
        this.codAutorizacion = codAutorizacion;
        this.vaucherNro = vaucherNro;
    }

    public CobroTarjeta(int idCobroTarjeta, int idCobro, int idCtaACobrar, int idVenta) {
        this.cobroTarjetaPK = new CobroTarjetaPK(idCobroTarjeta, idCobro, idCtaACobrar, idVenta);
    }

    public CobroTarjetaPK getCobroTarjetaPK() {
        return cobroTarjetaPK;
    }

    public void setCobroTarjetaPK(CobroTarjetaPK cobroTarjetaPK) {
        this.cobroTarjetaPK = cobroTarjetaPK;
    }

    public int getMontoCobroTarjeta() {
        return montoCobroTarjeta;
    }

    public void setMontoCobroTarjeta(int montoCobroTarjeta) {
        this.montoCobroTarjeta = montoCobroTarjeta;
    }

    public int getCuotaTarjeta() {
        return cuotaTarjeta;
    }

    public void setCuotaTarjeta(int cuotaTarjeta) {
        this.cuotaTarjeta = cuotaTarjeta;
    }

    public int getCodAutorizacion() {
        return codAutorizacion;
    }

    public void setCodAutorizacion(int codAutorizacion) {
        this.codAutorizacion = codAutorizacion;
    }

    public int getVaucherNro() {
        return vaucherNro;
    }

    public void setVaucherNro(int vaucherNro) {
        this.vaucherNro = vaucherNro;
    }

    public CobroDet getCobroDet() {
        return cobroDet;
    }

    public void setCobroDet(CobroDet cobroDet) {
        this.cobroDet = cobroDet;
    }

    public Tarjeta getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjeta idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobroTarjetaPK != null ? cobroTarjetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroTarjeta)) {
            return false;
        }
        CobroTarjeta other = (CobroTarjeta) object;
        if ((this.cobroTarjetaPK == null && other.cobroTarjetaPK != null) || (this.cobroTarjetaPK != null && !this.cobroTarjetaPK.equals(other.cobroTarjetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CobroTarjeta[ cobroTarjetaPK=" + cobroTarjetaPK + " ]";
    }
    
}
