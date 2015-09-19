/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "orden_compra_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompraCab.findAll", query = "SELECT o FROM OrdenCompraCab o"),
    @NamedQuery(name = "OrdenCompraCab.findByTipoOrdenCompra", query = "SELECT o FROM OrdenCompraCab o WHERE o.ordenCompraCabPK.tipoOrdenCompra = :tipoOrdenCompra"),
    @NamedQuery(name = "OrdenCompraCab.findBySerOrdenCompra", query = "SELECT o FROM OrdenCompraCab o WHERE o.ordenCompraCabPK.serOrdenCompra = :serOrdenCompra"),
    @NamedQuery(name = "OrdenCompraCab.findByNroOrdenCompra", query = "SELECT o FROM OrdenCompraCab o WHERE o.ordenCompraCabPK.nroOrdenCompra = :nroOrdenCompra"),
    @NamedQuery(name = "OrdenCompraCab.findByFecha", query = "SELECT o FROM OrdenCompraCab o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "OrdenCompraCab.findByFechaRecepcion", query = "SELECT o FROM OrdenCompraCab o WHERE o.fechaRecepcion = :fechaRecepcion")})
public class OrdenCompraCab implements Serializable {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenCompraCab")
    private OrdenCompraDet ordenCompraDet;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenCompraCabPK ordenCompraCabPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "cod_prov", referencedColumnName = "cod_prov")
    @ManyToOne
    private Proveedor codProv;

    public OrdenCompraCab() {
    }

    public OrdenCompraCab(OrdenCompraCabPK ordenCompraCabPK) {
        this.ordenCompraCabPK = ordenCompraCabPK;
    }

    public OrdenCompraCab(OrdenCompraCabPK ordenCompraCabPK, Date fecha) {
        this.ordenCompraCabPK = ordenCompraCabPK;
        this.fecha = fecha;
    }

    public OrdenCompraCab(String tipoOrdenCompra, String serOrdenCompra, BigInteger nroOrdenCompra) {
        this.ordenCompraCabPK = new OrdenCompraCabPK(tipoOrdenCompra, serOrdenCompra, nroOrdenCompra);
    }

    public OrdenCompraCabPK getOrdenCompraCabPK() {
        return ordenCompraCabPK;
    }

    public void setOrdenCompraCabPK(OrdenCompraCabPK ordenCompraCabPK) {
        this.ordenCompraCabPK = ordenCompraCabPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
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

    public Proveedor getCodProv() {
        return codProv;
    }

    public void setCodProv(Proveedor codProv) {
        this.codProv = codProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenCompraCabPK != null ? ordenCompraCabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraCab)) {
            return false;
        }
        OrdenCompraCab other = (OrdenCompraCab) object;
        if ((this.ordenCompraCabPK == null && other.ordenCompraCabPK != null) || (this.ordenCompraCabPK != null && !this.ordenCompraCabPK.equals(other.ordenCompraCabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenCompraCab[ ordenCompraCabPK=" + ordenCompraCabPK + " ]";
    }

    public OrdenCompraDet getOrdenCompraDet() {
        return ordenCompraDet;
    }

    public void setOrdenCompraDet(OrdenCompraDet ordenCompraDet) {
        this.ordenCompraDet = ordenCompraDet;
    }
    
}
