/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdEstado", query = "SELECT e FROM Estado e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "Estado.findByModulo", query = "SELECT e FROM Estado e WHERE e.modulo = :modulo"),
    @NamedQuery(name = "Estado.findByEstado", query = "SELECT e FROM Estado e WHERE e.estado = :estado")})
public class Estado implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Tiporeclamo> tiporeclamoList;
    @OneToMany(mappedBy = "idEstado")
    private List<OrdenTrabajoCab> ordenTrabajoCabList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Cliente> clienteList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado")
    @GeneratedValue(generator="EstadoSeq") 
    @SequenceGenerator(name="EstadoSeq",sequenceName="id_estado_estado_seq_1", allocationSize=1) 

    
    private BigDecimal idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "modulo")
    private String modulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<OrdenCompraCab> ordenCompraCabList;

    public Estado() {
    }

    public Estado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public Estado(BigDecimal idEstado, String modulo, String estado) {
        this.idEstado = idEstado;
        this.modulo = modulo;
        this.estado = estado;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<OrdenCompraCab> getOrdenCompraCabList() {
        return ordenCompraCabList;
    }

    public void setOrdenCompraCabList(List<OrdenCompraCab> ordenCompraCabList) {
        this.ordenCompraCabList = ordenCompraCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estado[ idEstado=" + idEstado + " ]";
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Tiporeclamo> getTiporeclamoList() {
        return tiporeclamoList;
    }

    public void setTiporeclamoList(List<Tiporeclamo> tiporeclamoList) {
        this.tiporeclamoList = tiporeclamoList;
    }

    @XmlTransient
    public List<OrdenTrabajoCab> getOrdenTrabajoCabList() {
        return ordenTrabajoCabList;
    }

    public void setOrdenTrabajoCabList(List<OrdenTrabajoCab> ordenTrabajoCabList) {
        this.ordenTrabajoCabList = ordenTrabajoCabList;
    }
    
}
