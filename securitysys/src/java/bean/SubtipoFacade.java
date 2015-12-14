/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Subtipo;
import entities.Tiporeclamo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LOTHAR
 */
@Stateless
public class SubtipoFacade extends AbstractFacade<Subtipo> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubtipoFacade() {
        super(Subtipo.class);
    }

    @Override
     public List<Subtipo> findAll() {
        try {
            return (List<Subtipo>) em.createNamedQuery("Subtipo.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }    
    
}
