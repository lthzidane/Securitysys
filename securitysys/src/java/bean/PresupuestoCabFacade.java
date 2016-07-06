/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.PresupuestoCab;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author expsee
 */
@Stateless
public class PresupuestoCabFacade extends AbstractFacade<PresupuestoCab> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoCabFacade() {
        super(PresupuestoCab.class);
    }
    
    @Override
     public List<PresupuestoCab> findAll() {
        try {
            return (List<PresupuestoCab>) em.createNamedQuery("PresupuestoCab.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
    public PresupuestoCab findByNroPresupuesto(Integer nroPresupuesto) {
        try {
            return (PresupuestoCab) em.createNamedQuery("PresupuestoCab.findByNroPresupuesto").setParameter("nroPresupuesto", nroPresupuesto).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
