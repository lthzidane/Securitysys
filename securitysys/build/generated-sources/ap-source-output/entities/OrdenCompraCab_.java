package entities;

import entities.Estado;
import entities.Funcionario;
import entities.OrdenCompraCabPK;
import entities.OrdenCompraDet;
import entities.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T10:12:50")
@StaticMetamodel(OrdenCompraCab.class)
public class OrdenCompraCab_ { 

    public static volatile SingularAttribute<OrdenCompraCab, Date> fecha;
    public static volatile SingularAttribute<OrdenCompraCab, Estado> idEstado;
    public static volatile SingularAttribute<OrdenCompraCab, OrdenCompraCabPK> ordenCompraCabPK;
    public static volatile SingularAttribute<OrdenCompraCab, Proveedor> codProv;
    public static volatile SingularAttribute<OrdenCompraCab, Funcionario> idFuncionario;
    public static volatile SingularAttribute<OrdenCompraCab, OrdenCompraDet> ordenCompraDet;
    public static volatile SingularAttribute<OrdenCompraCab, Date> fechaRecepcion;

}