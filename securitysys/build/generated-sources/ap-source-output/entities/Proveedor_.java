package entities;

import entities.OrdenCompraCab;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-22T08:19:11")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> telProv;
    public static volatile SingularAttribute<Proveedor, String> descriProv;
    public static volatile ListAttribute<Proveedor, OrdenCompraCab> ordenCompraCabList;
    public static volatile SingularAttribute<Proveedor, Integer> codProv;
    public static volatile SingularAttribute<Proveedor, String> rucProv;

}