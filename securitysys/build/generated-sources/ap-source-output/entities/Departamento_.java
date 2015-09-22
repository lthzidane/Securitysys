package entities;

import entities.Funcionario;
import entities.Usuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-22T08:19:11")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, BigInteger> estado;
    public static volatile ListAttribute<Departamento, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Departamento, String> responsable;
    public static volatile ListAttribute<Departamento, Usuario> usuarioList;
    public static volatile SingularAttribute<Departamento, String> nombreDpto;
    public static volatile SingularAttribute<Departamento, String> funcion;
    public static volatile SingularAttribute<Departamento, BigDecimal> idDpto;

}