package entities;

import entities.Productos;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T10:12:50")
@StaticMetamodel(Medidas.class)
public class Medidas_ { 

    public static volatile SingularAttribute<Medidas, String> descMedida;
    public static volatile ListAttribute<Medidas, Productos> productosList;
    public static volatile SingularAttribute<Medidas, BigDecimal> idMedida;

}