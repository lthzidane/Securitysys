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
 * @author Acer
 */
@Entity
@Table(name = "tipo_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicios.findAll", query = "SELECT t FROM TipoServicios t"),
    @NamedQuery(name = "TipoServicios.findByIdServicio", query = "SELECT t FROM TipoServicios t WHERE t.idServicio = :idServicio"),
    @NamedQuery(name = "TipoServicios.findByDescripcion", query = "SELECT t FROM TipoServicios t WHERE t.descripcion = :descripcion")})
public class TipoServicios implements Serializable {
    @OneToMany(mappedBy = "idServicio")
    private List<InstalacionCab> instalacionCabList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<OrdenTrabajoCab> ordenTrabajoCabList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio")
    @GeneratedValue(generator="TipoServSeq") 
    @SequenceGenerator(name="TipoServSeq",sequenceName="id_tipo_servicios_seq", allocationSize=1) 
    private BigDecimal idServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoServicios() {
    }

    public TipoServicios(BigDecimal idServicio) {
        this.idServicio = idServicio;
    }

    public TipoServicios(BigDecimal idServicio, String descripcion) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(BigDecimal idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicios)) {
            return false;
        }
        TipoServicios other = (TipoServicios) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoServicios[ idServicio=" + idServicio + " ]";
    }

    @XmlTransient
    public List<OrdenTrabajoCab> getOrdenTrabajoCabList() {
        return ordenTrabajoCabList;
    }

    public void setOrdenTrabajoCabList(List<OrdenTrabajoCab> ordenTrabajoCabList) {
        this.ordenTrabajoCabList = ordenTrabajoCabList;
    }

    @XmlTransient
    public List<InstalacionCab> getInstalacionCabList() {
        return instalacionCabList;
    }

    public void setInstalacionCabList(List<InstalacionCab> instalacionCabList) {
        this.instalacionCabList = instalacionCabList;
    }
    
}
