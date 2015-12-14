/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cliente;
import entities.Departamento;
import entities.Funcionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class FuncionarioFacade extends AbstractFacade<Funcionario> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioFacade() {
        super(Funcionario.class);
    }
    
     public List<Funcionario> findAll() {
        try {
            return (List<Funcionario>) em.createNamedQuery("Funcionario.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }    

    public Funcionario findByIdFuncionario(Integer idFuncionario) {
        try {
            return (Funcionario) em.createNamedQuery("Funcionario.findByIdFuncionario").setParameter("idFuncionario", idFuncionario).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }   
}
