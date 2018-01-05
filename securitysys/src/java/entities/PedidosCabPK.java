/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sebas
 */
@Embeddable
public class PedidosCabPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tipo_pedido")
    private String tipoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ser_pedido")
    private String serPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_pedido")
    private BigInteger nroPedido;

    public PedidosCabPK() {
    }

    public PedidosCabPK(String tipoPedido, String serPedido, BigInteger nroPedido) {
        this.tipoPedido = tipoPedido;
        this.serPedido = serPedido;
        this.nroPedido = nroPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getSerPedido() {
        return serPedido;
    }

    public void setSerPedido(String serPedido) {
        this.serPedido = serPedido;
    }

    public BigInteger getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(BigInteger nroPedido) {
        this.nroPedido = nroPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPedido != null ? tipoPedido.hashCode() : 0);
        hash += (serPedido != null ? serPedido.hashCode() : 0);
        hash += (nroPedido != null ? nroPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosCabPK)) {
            return false;
        }
        PedidosCabPK other = (PedidosCabPK) object;
        if ((this.tipoPedido == null && other.tipoPedido != null) || (this.tipoPedido != null && !this.tipoPedido.equals(other.tipoPedido))) {
            return false;
        }
        if ((this.serPedido == null && other.serPedido != null) || (this.serPedido != null && !this.serPedido.equals(other.serPedido))) {
            return false;
        }
        if ((this.nroPedido == null && other.nroPedido != null) || (this.nroPedido != null && !this.nroPedido.equals(other.nroPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PedidosCabPK[ tipoPedido=" + tipoPedido + ", serPedido=" + serPedido + ", nroPedido=" + nroPedido + " ]";
    }
    
}
