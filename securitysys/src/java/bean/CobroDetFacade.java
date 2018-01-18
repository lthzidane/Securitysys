/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.CobroDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cobro;
import entities.CtaACobrar;
import entities.CobroCheque;
import entities.CobroTarjeta;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class CobroDetFacade extends AbstractFacade<CobroDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobroDetFacade() {
        super(CobroDet.class);
    }

//    public boolean isCobroEmpty(CobroDet entity) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//        Root<CobroDet> cobroDet = cq.from(CobroDet.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroDet, entity), cb.isNotNull(cobroDet.get(CobroDet_.cobro)));
//        return em.createQuery(cq).getResultList().isEmpty();
//    }

    public Cobro findCobro(CobroDet entity) {
        return this.getMergedEntity(entity).getCobro();
    }

    public boolean isCtaACobrarEmpty(CobroDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CobroDet> cobroDet = cq.from(CobroDet.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroDet, entity), cb.isNotNull(cobroDet.get(CobroDet_.ctaACobrar)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CtaACobrar findCtaACobrar(CobroDet entity) {
        return this.getMergedEntity(entity).getCtaACobrar();
    }

//    public boolean isCobroChequeListEmpty(CobroDet entity) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//        Root<CobroDet> cobroDet = cq.from(CobroDet.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroDet, entity), cb.isNotEmpty(cobroDet.get(CobroDet_.cobroChequeList)));
//        return em.createQuery(cq).getResultList().isEmpty();
//    }

    public List<CobroCheque> findCobroChequeList(CobroDet entity) {
        CobroDet mergedEntity = this.getMergedEntity(entity);
        List<CobroCheque> cobroChequeList = mergedEntity.getCobroChequeList();
        cobroChequeList.size();
        return cobroChequeList;
    }

//    public boolean isCobroTarjetaListEmpty(CobroDet entity) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//        Root<CobroDet> cobroDet = cq.from(CobroDet.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroDet, entity), cb.isNotEmpty(cobroDet.get(CobroDet_.cobroTarjetaList)));
//        return em.createQuery(cq).getResultList().isEmpty();
//    }

    public List<CobroTarjeta> findCobroTarjetaList(CobroDet entity) {
        CobroDet mergedEntity = this.getMergedEntity(entity);
        List<CobroTarjeta> cobroTarjetaList = mergedEntity.getCobroTarjetaList();
        cobroTarjetaList.size();
        return cobroTarjetaList;
    }
    
}
