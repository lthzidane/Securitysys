/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.CobroTarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CobroDet;
import entities.Tarjeta;

/**
 *
 * @author expsee
 */
@Stateless
public class CobroTarjetaFacade extends AbstractFacade<CobroTarjeta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobroTarjetaFacade() {
        super(CobroTarjeta.class);
    }

    public boolean isCobroDetEmpty(CobroTarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CobroTarjeta> cobroTarjeta = cq.from(CobroTarjeta.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroTarjeta, entity), cb.isNotNull(cobroTarjeta.get(CobroTarjeta_.cobroDet)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public CobroDet findCobroDet(CobroTarjeta entity) {
        return this.getMergedEntity(entity).getCobroDet();
    }

    public boolean isIdTarjetaEmpty(CobroTarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CobroTarjeta> cobroTarjeta = cq.from(CobroTarjeta.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobroTarjeta, entity), cb.isNotNull(cobroTarjeta.get(CobroTarjeta_.idTarjeta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tarjeta findIdTarjeta(CobroTarjeta entity) {
        return this.getMergedEntity(entity).getIdTarjeta();
    }
    
}
