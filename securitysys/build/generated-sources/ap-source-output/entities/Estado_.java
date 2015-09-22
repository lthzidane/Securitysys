package entities;

import entities.OrdenCompraCab;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-22T08:19:11")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, BigDecimal> idEstado;
    public static volatile SingularAttribute<Estado, String> estado;
    public static volatile ListAttribute<Estado, OrdenCompraCab> ordenCompraCabList;
    public static volatile SingularAttribute<Estado, String> modulo;

}