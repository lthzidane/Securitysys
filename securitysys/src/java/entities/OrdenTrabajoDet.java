/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "orden_trabajo_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoDet.findAll", query = "SELECT o FROM OrdenTrabajoDet o"),
    @NamedQuery(name = "OrdenTrabajoDet.findByNroSecuencia", query = "SELECT o FROM OrdenTrabajoDet o WHERE o.nroSecuencia = :nroSecuencia"),
    @NamedQuery(name = "OrdenTrabajoDet.findByNroOrden", query = "SELECT o FROM OrdenTrabajoDet o WHERE o.nroOrden.nroOrden = :nroOrden"),
    @NamedQuery(name = "OrdenTrabajoDet.findByDetalle", query = "SELECT o FROM OrdenTrabajoDet o WHERE o.detalle = :detalle")})
public class OrdenTrabajoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_secuencia")
    @GeneratedValue(generator="OTDetSeq") 
    @SequenceGenerator(name="OTDetSeq",sequenceName="nro_secuencia_orden_trabajo_det_seq_1", allocationSize=1) 
    private BigDecimal nroSecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "nro_orden", referencedColumnName = "nro_orden")
    @ManyToOne(optional = false)
    private OrdenTrabajoCab nroOrden;

    public OrdenTrabajoDet() {
    }

    public OrdenTrabajoDet(BigDecimal nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public OrdenTrabajoDet(BigDecimal nroSecuencia, String detalle) {
        this.nroSecuencia = nroSecuencia;
        this.detalle = detalle;
    }

    public BigDecimal getNroSecuencia() {
        return nroSecuencia;
    }

    public void setNroSecuencia(BigDecimal nroSecuencia) {
        this.nroSecuencia = nroSecuencia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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
        hash += (nroSecuencia != null ? nroSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoDet)) {
            return false;
        }
        OrdenTrabajoDet other = (OrdenTrabajoDet) object;
        if ((this.nroSecuencia == null && other.nroSecuencia != null) || (this.nroSecuencia != null && !this.nroSecuencia.equals(other.nroSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenTrabajoDet[ nroSecuencia=" + nroSecuencia + " ]";
    }
    
}
