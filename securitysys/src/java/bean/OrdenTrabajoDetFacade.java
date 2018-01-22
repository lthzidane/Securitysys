/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.OrdenTrabajoDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.OrdenTrabajo;
import java.util.List;

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

    public boolean isOrdenTrabajoEmpty(OrdenTrabajoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajoDet> ordenTrabajoDet = cq.from(OrdenTrabajoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajoDet, entity), cb.isNotNull(ordenTrabajoDet.get(OrdenTrabajoDet_.ordenTrabajo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public OrdenTrabajo findOrdenTrabajo(OrdenTrabajoDet entity) {
        return this.getMergedEntity(entity).getOrdenTrabajo();
    }

    List<OrdenTrabajoDet> findByNroOrden(int intValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
