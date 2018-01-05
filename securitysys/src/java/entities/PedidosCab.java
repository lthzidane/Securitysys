/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "pedidos_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosCab.findAll", query = "SELECT p FROM PedidosCab p"),
    @NamedQuery(name = "PedidosCab.findByTipoPedido", query = "SELECT p FROM PedidosCab p WHERE p.pedidosCabPK.tipoPedido = :tipoPedido"),
    @NamedQuery(name = "PedidosCab.findBySerPedido", query = "SELECT p FROM PedidosCab p WHERE p.pedidosCabPK.serPedido = :serPedido"),
    @NamedQuery(name = "PedidosCab.findByNroPedido", query = "SELECT p FROM PedidosCab p WHERE p.pedidosCabPK.nroPedido = :nroPedido"),
    @NamedQuery(name = "PedidosCab.findByFecha", query = "SELECT p FROM PedidosCab p WHERE p.fecha = :fecha")})
public class PedidosCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidosCabPK pedidosCabPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidosCab")
    private List<VentasCab> ventasCabList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "nro_orden", referencedColumnName = "nro_orden")
    @ManyToOne(optional = false)
    private OrdenTrabajoCab nroOrden;

    public PedidosCab() {
    }

    public PedidosCab(PedidosCabPK pedidosCabPK) {
        this.pedidosCabPK = pedidosCabPK;
    }

    public PedidosCab(PedidosCabPK pedidosCabPK, Date fecha) {
        this.pedidosCabPK = pedidosCabPK;
        this.fecha = fecha;
    }

    public PedidosCab(String tipoPedido, String serPedido, BigInteger nroPedido) {
        this.pedidosCabPK = new PedidosCabPK(tipoPedido, serPedido, nroPedido);
    }

    public PedidosCabPK getPedidosCabPK() {
        return pedidosCabPK;
    }

    public void setPedidosCabPK(PedidosCabPK pedidosCabPK) {
        this.pedidosCabPK = pedidosCabPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<VentasCab> getVentasCabList() {
        return ventasCabList;
    }

    public void setVentasCabList(List<VentasCab> ventasCabList) {
        this.ventasCabList = ventasCabList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public OrdenTrabajoCab getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(OrdenTrabajoCab nroOrden) {
        this.nroOrden = nroOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidosCabPK != null ? pedidosCabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosCab)) {
            return false;
        }
        PedidosCab other = (PedidosCab) object;
        if ((this.pedidosCabPK == null && other.pedidosCabPK != null) || (this.pedidosCabPK != null && !this.pedidosCabPK.equals(other.pedidosCabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PedidosCab[ pedidosCabPK=" + pedidosCabPK + " ]";
    }
    
}
