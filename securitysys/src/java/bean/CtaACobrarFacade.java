/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.CtaACobrar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CobroDet;
import entities.Venta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class CtaACobrarFacade extends AbstractFacade<CtaACobrar> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CtaACobrarFacade() {
        super(CtaACobrar.class);
    }

    public boolean isCobroDetListEmpty(CtaACobrar entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CtaACobrar> ctaACobrar = cq.from(CtaACobrar.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ctaACobrar, entity), cb.isNotEmpty(ctaACobrar.get(CtaACobrar_.cobroDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CobroDet> findCobroDetList(CtaACobrar entity) {
        CtaACobrar mergedEntity = this.getMergedEntity(entity);
        List<CobroDet> cobroDetList = mergedEntity.getCobroDetList();
        cobroDetList.size();
        return cobroDetList;
    }

    public boolean isVentaEmpty(CtaACobrar entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CtaACobrar> ctaACobrar = cq.from(CtaACobrar.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ctaACobrar, entity), cb.isNotNull(ctaACobrar.get(CtaACobrar_.venta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Venta findVenta(CtaACobrar entity) {
        return this.getMergedEntity(entity).getVenta();
    }
    
}
