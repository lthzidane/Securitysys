/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.CobroCheque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Banco;
import entities.CobroDet;

/**
 *
 * @author acer
 */
@Stateless
public class CobroChequeFacade extends AbstractFacade<CobroCheque> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobroChequeFacade() {
        super(CobroCheque.class);
    }

    public boolean isIdBancoEmpty(CobroCheque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CobroCheque> cobroCheque = cq.from(CobroCheque.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroCheque, entity), cb.isNotNull(cobroCheque.get(CobroCheque_.idBanco)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Banco findIdBanco(CobroCheque entity) {
        return this.getMergedEntity(entity).getIdBanco();
    }

    public boolean isCobroDetEmpty(CobroCheque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CobroCheque> cobroCheque = cq.from(CobroCheque.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroCheque, entity), cb.isNotNull(cobroCheque.get(CobroCheque_.cobroDet)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CobroDet findCobroDet(CobroCheque entity) {
        return this.getMergedEntity(entity).getCobroDet();
    }
    
}
