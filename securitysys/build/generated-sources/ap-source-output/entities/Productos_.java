package entities;

import entities.Medidas;
import entities.OrdenCompraDet;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T10:12:50")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile SingularAttribute<Productos, BigDecimal> codProducto;
    public static volatile SingularAttribute<Productos, Medidas> idMedida;
    public static volatile ListAttribute<Productos, OrdenCompraDet> ordenCompraDetList;

}