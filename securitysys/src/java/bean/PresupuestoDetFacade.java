/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.PresupuestoDet;
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
public class PresupuestoDetFacade extends AbstractFacade<PresupuestoDet> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoDetFacade() {
        super(PresupuestoDet.class);
    }
 
    public List<PresupuestoDet> findByNroSecuencia(Integer nroSecuencia) {
        try {
            return (List<PresupuestoDet>) em.createNamedQuery("PresupuestoDet.findByNroSecuencia").setParameter("nroSecuencia", nroSecuencia).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
