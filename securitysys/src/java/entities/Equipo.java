/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo")
    , @NamedQuery(name = "Equipo.findByDescripcion", query = "SELECT e FROM Equipo e WHERE e.descripcion = :descripcion")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<PromocionDet> promocionDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<NotaCrediDebiVentaDet> notaCrediDebiVentaDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<DiagnosticoDet> diagnosticoDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<NotaRemisionVentaDet> notaRemisionVentaDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<VentaDet> ventaDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<InstalacionDet> instalacionDetList;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String descripcion) {
        this.idEquipo = idEquipo;
        this.descripcion = descripcion.toUpperCase();
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    @XmlTransient
    public List<PromocionDet> getPromocionDetList() {
        return promocionDetList;
    }

    public void setPromocionDetList(List<PromocionDet> promocionDetList) {
        this.promocionDetList = promocionDetList;
    }

    @XmlTransient
    public List<NotaCrediDebiVentaDet> getNotaCrediDebiVentaDetList() {
        return notaCrediDebiVentaDetList;
    }

    public void setNotaCrediDebiVentaDetList(List<NotaCrediDebiVentaDet> notaCrediDebiVentaDetList) {
        this.notaCrediDebiVentaDetList = notaCrediDebiVentaDetList;
    }

    @XmlTransient
    public List<DiagnosticoDet> getDiagnosticoDetList() {
        return diagnosticoDetList;
    }

    public void setDiagnosticoDetList(List<DiagnosticoDet> diagnosticoDetList) {
        this.diagnosticoDetList = diagnosticoDetList;
    }

    @XmlTransient
    public List<NotaRemisionVentaDet> getNotaRemisionVentaDetList() {
        return notaRemisionVentaDetList;
    }

    public void setNotaRemisionVentaDetList(List<NotaRemisionVentaDet> notaRemisionVentaDetList) {
        this.notaRemisionVentaDetList = notaRemisionVentaDetList;
    }

    @XmlTransient
    public List<VentaDet> getVentaDetList() {
        return ventaDetList;
    }

    public void setVentaDetList(List<VentaDet> ventaDetList) {
        this.ventaDetList = ventaDetList;
    }

    @XmlTransient
    public List<InstalacionDet> getInstalacionDetList() {
        return instalacionDetList;
    }

    public void setInstalacionDetList(List<InstalacionDet> instalacionDetList) {
        this.instalacionDetList = instalacionDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
