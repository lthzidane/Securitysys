/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author acer
 */
@Embeddable
public class CobroChequePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_cobro_cheque")
    private int idCobroCheque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cobro")
    private int idCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cta_a_cobrar")
    private int idCtaACobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_venta")
    private int idVenta;

    public CobroChequePK() {
    }

    public CobroChequePK(int idCobroCheque, int idCobro, int idCtaACobrar, int idVenta) {
        this.idCobroCheque = idCobroCheque;
        this.idCobro = idCobro;
        this.idCtaACobrar = idCtaACobrar;
        this.idVenta = idVenta;
    }

    public int getIdCobroCheque() {
        return idCobroCheque;
    }

    public void setIdCobroCheque(int idCobroCheque) {
        this.idCobroCheque = idCobroCheque;
    }

    public int getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(int idCobro) {
        this.idCobro = idCobro;
    }

    public int getIdCtaACobrar() {
        return idCtaACobrar;
    }

    public void setIdCtaACobrar(int idCtaACobrar) {
        this.idCtaACobrar = idCtaACobrar;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCobroCheque;
        hash += (int) idCobro;
        hash += (int) idCtaACobrar;
        hash += (int) idVenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobroChequePK)) {
            return false;
        }
        CobroChequePK other = (CobroChequePK) object;
        if (this.idCobroCheque != other.idCobroCheque) {
            return false;
        }
        if (this.idCobro != other.idCobro) {
            return false;
        }
        if (this.idCtaACobrar != other.idCtaACobrar) {
            return false;
        }
        if (this.idVenta != other.idVenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CobroChequePK[ idCobroCheque=" + idCobroCheque + ", idCobro=" + idCobro + ", idCtaACobrar=" + idCtaACobrar + ", idVenta=" + idVenta + " ]";
    }
    
}
