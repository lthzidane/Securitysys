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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "presupuesto_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoCab.findAll", query = "SELECT p FROM PresupuestoCab p"),
    @NamedQuery(name = "PresupuestoCab.findByTipoPresupuesto", query = "SELECT p FROM PresupuestoCab p WHERE p.presupuestoCabPK.tipoPresupuesto = :tipoPresupuesto"),
    @NamedQuery(name = "PresupuestoCab.findBySerPresupuesto", query = "SELECT p FROM PresupuestoCab p WHERE p.presupuestoCabPK.serPresupuesto = :serPresupuesto"),
    @NamedQuery(name = "PresupuestoCab.findByNroPresupuesto", query = "SELECT p FROM PresupuestoCab p WHERE p.presupuestoCabPK.nroPresupuesto = :nroPresupuesto"),
    @NamedQuery(name = "PresupuestoCab.findByFecha", query = "SELECT p FROM PresupuestoCab p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PresupuestoCab.findByIdSucursal", query = "SELECT p FROM PresupuestoCab p WHERE p.idSucursal = :idSucursal"),
    @NamedQuery(name = "PresupuestoCab.findByFormaPago", query = "SELECT p FROM PresupuestoCab p WHERE p.formaPago = :formaPago"),
    @NamedQuery(name = "PresupuestoCab.findByPlazoEntrega", query = "SELECT p FROM PresupuestoCab p WHERE p.plazoEntrega = :plazoEntrega"),
    @NamedQuery(name = "PresupuestoCab.findByValidez", query = "SELECT p FROM PresupuestoCab p WHERE p.validez = :validez"),
    @NamedQuery(name = "PresupuestoCab.findByObservacion", query = "SELECT p FROM PresupuestoCab p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PresupuestoCab.findByTotal", query = "SELECT p FROM PresupuestoCab p WHERE p.total = :total"),
    @NamedQuery(name = "PresupuestoCab.findByDescuento", query = "SELECT p FROM PresupuestoCab p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "PresupuestoCab.findByBaseImponible", query = "SELECT p FROM PresupuestoCab p WHERE p.baseImponible = :baseImponible")})
public class PresupuestoCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoCabPK presupuestoCabPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "id_sucursal")
    private BigInteger idSucursal;
    @Size(max = 10)
    @Column(name = "forma_pago")
    private String formaPago;
    @Size(max = 3)
    @Column(name = "plazo_entrega")
    private String plazoEntrega;
    @Size(max = 3)
    @Column(name = "validez")
    private String validez;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "total")
    private BigInteger total;
    @Column(name = "descuento")
    private BigInteger descuento;
    @Column(name = "base_imponible")
    private BigInteger baseImponible;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestoCab")
    private List<PresupuestoDet> presupuestoDetList;

    public PresupuestoCab() {
    }

    public PresupuestoCab(PresupuestoCabPK presupuestoCabPK) {
        this.presupuestoCabPK = presupuestoCabPK;
    }

    public PresupuestoCab(PresupuestoCabPK presupuestoCabPK, Date fecha) {
        this.presupuestoCabPK = presupuestoCabPK;
        this.fecha = fecha;
    }

    public PresupuestoCab(String tipoPresupuesto, String serPresupuesto, BigInteger nroPresupuesto) {
        this.presupuestoCabPK = new PresupuestoCabPK(tipoPresupuesto, serPresupuesto, nroPresupuesto);
    }

    public PresupuestoCabPK getPresupuestoCabPK() {
        return presupuestoCabPK;
    }

    public void setPresupuestoCabPK(PresupuestoCabPK presupuestoCabPK) {
        this.presupuestoCabPK = presupuestoCabPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(BigInteger idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getPlazoEntrega() {
        return plazoEntrega;
    }

    public void setPlazoEntrega(String plazoEntrega) {
        this.plazoEntrega = plazoEntrega;
    }

    public String getValidez() {
        return validez;
    }

    public void setValidez(String validez) {
        this.validez = validez;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public BigInteger getDescuento() {
        return descuento;
    }

    public void setDescuento(BigInteger descuento) {
        this.descuento = descuento;
    }

    public BigInteger getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(BigInteger baseImponible) {
        this.baseImponible = baseImponible;
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

    @XmlTransient
    public List<PresupuestoDet> getPresupuestoDetList() {
        return presupuestoDetList;
    }

    public void setPresupuestoDetList(List<PresupuestoDet> presupuestoDetList) {
        this.presupuestoDetList = presupuestoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoCabPK != null ? presupuestoCabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoCab)) {
            return false;
        }
        PresupuestoCab other = (PresupuestoCab) object;
        if ((this.presupuestoCabPK == null && other.presupuestoCabPK != null) || (this.presupuestoCabPK != null && !this.presupuestoCabPK.equals(other.presupuestoCabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PresupuestoCab[ presupuestoCabPK=" + presupuestoCabPK + " ]";
    }
    
}
