package entities;

import entities.Departamento;
import entities.Funcionario;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T10:12:50")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, BigInteger> estado;
    public static volatile ListAttribute<Usuario, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<Usuario, Departamento> idDpto;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> contrasenha;

}