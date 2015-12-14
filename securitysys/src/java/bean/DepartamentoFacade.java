/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Departamento;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    @Override
     public List<Departamento> findAll() {
        try {
            return (List<Departamento>) em.createNamedQuery("Departamento.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
     
    public Departamento findByIdDpto(Integer idDpto) {
        try {
            return (Departamento) em.createNamedQuery("Departamento.findByIdDpto").setParameter("idDpto", idDpto).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }     
     
}
