package entities;

import entities.Departamento;
import entities.OrdenCompraCab;
import entities.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T10:12:50")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, Usuario> idUsuario;
    public static volatile ListAttribute<Funcionario, OrdenCompraCab> ordenCompraCabList;
    public static volatile SingularAttribute<Funcionario, BigDecimal> idFuncionario;
    public static volatile SingularAttribute<Funcionario, Departamento> idDpto;
    public static volatile SingularAttribute<Funcionario, String> nombre;

}