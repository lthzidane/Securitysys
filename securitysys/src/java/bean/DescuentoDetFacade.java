/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.DescuentoDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Descuento;

/**
 *
 * @author acer
 */
@Stateless
public class DescuentoDetFacade extends AbstractFacade<DescuentoDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DescuentoDetFacade() {
        super(DescuentoDet.class);
    }

    public boolean isDescuentoEmpty(DescuentoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DescuentoDet> descuentoDet = cq.from(DescuentoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(descuentoDet, entity), cb.isNotNull(descuentoDet.get(DescuentoDet_.descuento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Descuento findDescuento(DescuentoDet entity) {
        return this.getMergedEntity(entity).getDescuento();
    }
    
}
