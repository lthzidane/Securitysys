/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LOTHAR
 */
@Entity
@Table(name = "instalacion_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstalacionDet.findAll", query = "SELECT i FROM InstalacionDet i"),
    @NamedQuery(name = "InstalacionDet.findByIdInstalacion", query = "SELECT i FROM InstalacionDet i WHERE i.instalacionDetPK.idInstalacion = :idInstalacion"),
    @NamedQuery(name = "InstalacionDet.findByNroLinea", query = "SELECT i FROM InstalacionDet i WHERE i.instalacionDetPK.nroLinea = :nroLinea"),
    @NamedQuery(name = "InstalacionDet.findByIdProductosKit", query = "SELECT i FROM InstalacionDet i WHERE i.idProductosKit = :idProductosKit"),
    @NamedQuery(name = "InstalacionDet.findByCodProducto", query = "SELECT i FROM InstalacionDet i WHERE i.codProducto = :codProducto")})
public class InstalacionDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InstalacionDetPK instalacionDetPK;
    @Column(name = "id_productos_kit")
    private BigInteger idProductosKit;
    @Column(name = "cod_producto")
    private BigInteger codProducto;

    public InstalacionDet() {
    }

    public InstalacionDet(InstalacionDetPK instalacionDetPK) {
        this.instalacionDetPK = instalacionDetPK;
    }

    public InstalacionDet(BigInteger idInstalacion, BigInteger nroLinea) {
        this.instalacionDetPK = new InstalacionDetPK(idInstalacion, nroLinea);
    }

    public InstalacionDetPK getInstalacionDetPK() {
        return instalacionDetPK;
    }

    public void setInstalacionDetPK(InstalacionDetPK instalacionDetPK) {
        this.instalacionDetPK = instalacionDetPK;
    }

    public BigInteger getIdProductosKit() {
        return idProductosKit;
    }

    public void setIdProductosKit(BigInteger idProductosKit) {
        this.idProductosKit = idProductosKit;
    }

    public BigInteger getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(BigInteger codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instalacionDetPK != null ? instalacionDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstalacionDet)) {
            return false;
        }
        InstalacionDet other = (InstalacionDet) object;
        if ((this.instalacionDetPK == null && other.instalacionDetPK != null) || (this.instalacionDetPK != null && !this.instalacionDetPK.equals(other.instalacionDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InstalacionDet[ instalacionDetPK=" + instalacionDetPK + " ]";
    }
    
}
