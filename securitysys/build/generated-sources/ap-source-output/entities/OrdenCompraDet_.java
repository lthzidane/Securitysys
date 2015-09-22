package entities;

import entities.OrdenCompraCab;
import entities.OrdenCompraDetPK;
import entities.Productos;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-21T22:25:04")
@StaticMetamodel(OrdenCompraDet.class)
public class OrdenCompraDet_ { 

    public static volatile SingularAttribute<OrdenCompraDet, Productos> codProducto;
    public static volatile SingularAttribute<OrdenCompraDet, OrdenCompraDetPK> ordenCompraDetPK;
    public static volatile SingularAttribute<OrdenCompraDet, OrdenCompraCab> ordenCompraCab;
    public static volatile SingularAttribute<OrdenCompraDet, BigInteger> cantidad;

}