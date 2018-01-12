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
@Table(name = "descuento_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescuentoDet.findAll", query = "SELECT d FROM DescuentoDet d"),
    @NamedQuery(name = "DescuentoDet.findByIdDescuentoCab", query = "SELECT d FROM DescuentoDet d WHERE d.descuentoDetPK.idDescuentoCab = :idDescuentoCab"),
    @NamedQuery(name = "DescuentoDet.findByIdSecuencia", query = "SELECT d FROM DescuentoDet d WHERE d.descuentoDetPK.idSecuencia = :idSecuencia"),
    @NamedQuery(name = "DescuentoDet.findByPorcentajeDesc", query = "SELECT d FROM DescuentoDet d WHERE d.porcentajeDesc = :porcentajeDesc")})
public class DescuentoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DescuentoDetPK descuentoDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje_desc")
    private int porcentajeDesc;
    @JoinColumn(name = "id_descuento_cab", referencedColumnName = "id_descuento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Descuento descuento;

    public DescuentoDet() {
    }

    public DescuentoDet(DescuentoDetPK descuentoDetPK) {
        this.descuentoDetPK = descuentoDetPK;
    }

    public DescuentoDet(DescuentoDetPK descuentoDetPK, int porcentajeDesc) {
        this.descuentoDetPK = descuentoDetPK;
        this.porcentajeDesc = porcentajeDesc;
    }

    public DescuentoDet(int idDescuentoCab, int idSecuencia) {
        this.descuentoDetPK = new DescuentoDetPK(idDescuentoCab, idSecuencia);
    }

    public DescuentoDetPK getDescuentoDetPK() {
        return descuentoDetPK;
    }

    public void setDescuentoDetPK(DescuentoDetPK descuentoDetPK) {
        this.descuentoDetPK = descuentoDetPK;
    }

    public int getPorcentajeDesc() {
        return porcentajeDesc;
    }

    public void setPorcentajeDesc(int porcentajeDesc) {
        this.porcentajeDesc = porcentajeDesc;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descuentoDetPK != null ? descuentoDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescuentoDet)) {
            return false;
        }
        DescuentoDet other = (DescuentoDet) object;
        if ((this.descuentoDetPK == null && other.descuentoDetPK != null) || (this.descuentoDetPK != null && !this.descuentoDetPK.equals(other.descuentoDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DescuentoDet[ descuentoDetPK=" + descuentoDetPK + " ]";
    }
    
}
