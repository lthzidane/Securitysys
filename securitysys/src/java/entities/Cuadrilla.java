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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "cuadrilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuadrilla.findAll", query = "SELECT c FROM Cuadrilla c"),
    @NamedQuery(name = "Cuadrilla.findByIdCuadrilla", query = "SELECT c FROM Cuadrilla c WHERE c.idCuadrilla = :idCuadrilla")})
public class Cuadrilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuadrilla")
    private Integer idCuadrilla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuadrilla")
    private List<OrdenTrabajo> ordenTrabajoList;
    @JoinColumn(name = "id_movil", referencedColumnName = "id_movil")
    @ManyToOne(optional = false)
    private Moviles idMovil;
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    @ManyToOne(optional = false)
    private Tecnico idTecnico;
    @JoinColumn(name = "id_tipo_cuadrilla", referencedColumnName = "id_tipo_cuadrilla")
    @ManyToOne(optional = false)
    private TipoCuadrilla idTipoCuadrilla;
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    @ManyToOne(optional = false)
    private Zona idZona;

    public Cuadrilla() {
    }

    public Cuadrilla(Integer idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public Integer getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(Integer idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    @XmlTransient
    public List<OrdenTrabajo> getOrdenTrabajoList() {
        return ordenTrabajoList;
    }

    public void setOrdenTrabajoList(List<OrdenTrabajo> ordenTrabajoList) {
        this.ordenTrabajoList = ordenTrabajoList;
    }

    public Moviles getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(Moviles idMovil) {
        this.idMovil = idMovil;
    }

    public Tecnico getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public TipoCuadrilla getIdTipoCuadrilla() {
        return idTipoCuadrilla;
    }

    public void setIdTipoCuadrilla(TipoCuadrilla idTipoCuadrilla) {
        this.idTipoCuadrilla = idTipoCuadrilla;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuadrilla != null ? idCuadrilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadrilla)) {
            return false;
        }
        Cuadrilla other = (Cuadrilla) object;
        if ((this.idCuadrilla == null && other.idCuadrilla != null) || (this.idCuadrilla != null && !this.idCuadrilla.equals(other.idCuadrilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cuadrilla[ idCuadrilla=" + idCuadrilla + " ]";
    }
    
}
