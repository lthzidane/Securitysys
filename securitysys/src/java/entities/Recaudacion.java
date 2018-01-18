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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "recaudacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recaudacion.findAll", query = "SELECT r FROM Recaudacion r")
    , @NamedQuery(name = "Recaudacion.findByIdRecaudacion", query = "SELECT r FROM Recaudacion r WHERE r.recaudacionPK.idRecaudacion = :idRecaudacion")
    , @NamedQuery(name = "Recaudacion.findByIdFormaCobro", query = "SELECT r FROM Recaudacion r WHERE r.recaudacionPK.idFormaCobro = :idFormaCobro")
    , @NamedQuery(name = "Recaudacion.findByFechaRecaudacion", query = "SELECT r FROM Recaudacion r WHERE r.fechaRecaudacion = :fechaRecaudacion")
    , @NamedQuery(name = "Recaudacion.findByMontoRecaudacion", query = "SELECT r FROM Recaudacion r WHERE r.montoRecaudacion = :montoRecaudacion")})
public class Recaudacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecaudacionPK recaudacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recaudacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecaudacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_recaudacion")
    private int montoRecaudacion;
    @JoinColumns({
        @JoinColumn(name = "id_arqueo", referencedColumnName = "id_arqueo")
        , @JoinColumn(name = "id_valor", referencedColumnName = "id_valor")
        , @JoinColumn(name = "id_apertura_cierre", referencedColumnName = "id_apertura_cierre")})
    @ManyToOne(optional = false)
    private Arqueo arqueo;
    @JoinColumn(name = "id_forma_cobro", referencedColumnName = "id_forma_cobro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FormaCobro formaCobro;

    public Recaudacion() {
    }

    public Recaudacion(RecaudacionPK recaudacionPK) {
        this.recaudacionPK = recaudacionPK;
    }

    public Recaudacion(RecaudacionPK recaudacionPK, Date fechaRecaudacion, int montoRecaudacion) {
        this.recaudacionPK = recaudacionPK;
        this.fechaRecaudacion = fechaRecaudacion;
        this.montoRecaudacion = montoRecaudacion;
    }

    public Recaudacion(int idRecaudacion, int idFormaCobro) {
        this.recaudacionPK = new RecaudacionPK(idRecaudacion, idFormaCobro);
    }

    public RecaudacionPK getRecaudacionPK() {
        return recaudacionPK;
    }

    public void setRecaudacionPK(RecaudacionPK recaudacionPK) {
        this.recaudacionPK = recaudacionPK;
    }

    public Date getFechaRecaudacion() {
        return fechaRecaudacion;
    }

    public void setFechaRecaudacion(Date fechaRecaudacion) {
        this.fechaRecaudacion = fechaRecaudacion;
    }

    public int getMontoRecaudacion() {
        return montoRecaudacion;
    }

    public void setMontoRecaudacion(int montoRecaudacion) {
        this.montoRecaudacion = montoRecaudacion;
    }

    public Arqueo getArqueo() {
        return arqueo;
    }

    public void setArqueo(Arqueo arqueo) {
        this.arqueo = arqueo;
    }

    public FormaCobro getFormaCobro() {
        return formaCobro;
    }

    public void setFormaCobro(FormaCobro formaCobro) {
        this.formaCobro = formaCobro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recaudacionPK != null ? recaudacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recaudacion)) {
            return false;
        }
        Recaudacion other = (Recaudacion) object;
        if ((this.recaudacionPK == null && other.recaudacionPK != null) || (this.recaudacionPK != null && !this.recaudacionPK.equals(other.recaudacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Recaudacion[ recaudacionPK=" + recaudacionPK + " ]";
    }
    
}
