/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
 * @author acer
 */
@Entity
@Table(name = "arqueo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arqueo.findAll", query = "SELECT a FROM Arqueo a")
    , @NamedQuery(name = "Arqueo.findByIdArqueo", query = "SELECT a FROM Arqueo a WHERE a.arqueoPK.idArqueo = :idArqueo")
    , @NamedQuery(name = "Arqueo.findByIdValor", query = "SELECT a FROM Arqueo a WHERE a.arqueoPK.idValor = :idValor")
    , @NamedQuery(name = "Arqueo.findByIdAperturaCierre", query = "SELECT a FROM Arqueo a WHERE a.arqueoPK.idAperturaCierre = :idAperturaCierre")
    , @NamedQuery(name = "Arqueo.findByCantidadValor", query = "SELECT a FROM Arqueo a WHERE a.cantidadValor = :cantidadValor")
    , @NamedQuery(name = "Arqueo.findByFechaArqueo", query = "SELECT a FROM Arqueo a WHERE a.fechaArqueo = :fechaArqueo")
    , @NamedQuery(name = "Arqueo.findByHoraArqueo", query = "SELECT a FROM Arqueo a WHERE a.horaArqueo = :horaArqueo")
    , @NamedQuery(name = "Arqueo.findByEstadoArqueo", query = "SELECT a FROM Arqueo a WHERE a.estadoArqueo = :estadoArqueo")})
public class Arqueo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArqueoPK arqueoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_valor")
    private int cantidadValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_arqueo")
    @Temporal(TemporalType.DATE)
    private Date fechaArqueo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_arqueo")
    @Temporal(TemporalType.TIME)
    private Date horaArqueo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "estado_arqueo")
    private String estadoArqueo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arqueo")
    private List<Recaudacion> recaudacionList;
    @JoinColumn(name = "id_apertura_cierre", referencedColumnName = "id_apertura_cierre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AperturaCierreCaja aperturaCierreCaja;
    @JoinColumn(name = "id_valor", referencedColumnName = "id_valor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Valor valor;

    public Arqueo() {
    }

    public Arqueo(ArqueoPK arqueoPK) {
        this.arqueoPK = arqueoPK;
    }

    public Arqueo(ArqueoPK arqueoPK, int cantidadValor, Date fechaArqueo, Date horaArqueo, String estadoArqueo) {
        this.arqueoPK = arqueoPK;
        this.cantidadValor = cantidadValor;
        this.fechaArqueo = fechaArqueo;
        this.horaArqueo = horaArqueo;
        this.estadoArqueo = estadoArqueo;
    }

    public Arqueo(int idArqueo, int idValor, int idAperturaCierre) {
        this.arqueoPK = new ArqueoPK(idArqueo, idValor, idAperturaCierre);
    }

    public ArqueoPK getArqueoPK() {
        return arqueoPK;
    }

    public void setArqueoPK(ArqueoPK arqueoPK) {
        this.arqueoPK = arqueoPK;
    }

    public int getCantidadValor() {
        return cantidadValor;
    }

    public void setCantidadValor(int cantidadValor) {
        this.cantidadValor = cantidadValor;
    }

    public Date getFechaArqueo() {
        return fechaArqueo;
    }

    public void setFechaArqueo(Date fechaArqueo) {
        this.fechaArqueo = fechaArqueo;
    }

    public Date getHoraArqueo() {
        return horaArqueo;
    }

    public void setHoraArqueo(Date horaArqueo) {
        this.horaArqueo = horaArqueo;
    }

    public String getEstadoArqueo() {
        return estadoArqueo;
    }

    public void setEstadoArqueo(String estadoArqueo) {
        this.estadoArqueo = estadoArqueo;
    }

    @XmlTransient
    public List<Recaudacion> getRecaudacionList() {
        return recaudacionList;
    }

    public void setRecaudacionList(List<Recaudacion> recaudacionList) {
        this.recaudacionList = recaudacionList;
    }

    public AperturaCierreCaja getAperturaCierreCaja() {
        return aperturaCierreCaja;
    }

    public void setAperturaCierreCaja(AperturaCierreCaja aperturaCierreCaja) {
        this.aperturaCierreCaja = aperturaCierreCaja;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arqueoPK != null ? arqueoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arqueo)) {
            return false;
        }
        Arqueo other = (Arqueo) object;
        if ((this.arqueoPK == null && other.arqueoPK != null) || (this.arqueoPK != null && !this.arqueoPK.equals(other.arqueoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Arqueo[ arqueoPK=" + arqueoPK + " ]";
    }
    
}
