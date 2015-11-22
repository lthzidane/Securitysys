/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.OrdenTrabajoCab;
import entities.OrdenTrabajoDet;
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
public class OrdenTrabajoDetFacade extends AbstractFacade<OrdenTrabajoDet> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenTrabajoDetFacade() {
        super(OrdenTrabajoDet.class);
    }
 
    public List<OrdenTrabajoDet> findByNroOrden(Integer nroOrden) {
        try {
            return (List<OrdenTrabajoDet>) em.createNamedQuery("OrdenTrabajoDet.findByNroOrden").setParameter("nroOrden", nroOrden).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
