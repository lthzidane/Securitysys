/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.PresupuestoDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Descuento;
import entities.Presupuesto;
import entities.Promocion;

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

    public boolean isIdDescuentoEmpty(PresupuestoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PresupuestoDet> presupuestoDet = cq.from(PresupuestoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuestoDet, entity), cb.isNotNull(presupuestoDet.get(PresupuestoDet_.idDescuento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Descuento findIdDescuento(PresupuestoDet entity) {
        return this.getMergedEntity(entity).getIdDescuento();
    }

    public boolean isPresupuestoEmpty(PresupuestoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PresupuestoDet> presupuestoDet = cq.from(PresupuestoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuestoDet, entity), cb.isNotNull(presupuestoDet.get(PresupuestoDet_.presupuesto)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Presupuesto findPresupuesto(PresupuestoDet entity) {
        return this.getMergedEntity(entity).getPresupuesto();
    }

    public boolean isIdPromocionEmpty(PresupuestoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PresupuestoDet> presupuestoDet = cq.from(PresupuestoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuestoDet, entity), cb.isNotNull(presupuestoDet.get(PresupuestoDet_.idPromocion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Promocion findIdPromocion(PresupuestoDet entity) {
        return this.getMergedEntity(entity).getIdPromocion();
    }
    
}
