/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.PromocionDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Equipo;
import entities.Promocion;
import entities.Servicio;

/**
 *
 * @author expsee
 */
@Stateless
public class PromocionDetFacade extends AbstractFacade<PromocionDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromocionDetFacade() {
        super(PromocionDet.class);
    }

    public boolean isIdEquipoEmpty(PromocionDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PromocionDet> promocionDet = cq.from(PromocionDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocionDet, entity), cb.isNotNull(promocionDet.get(PromocionDet_.idEquipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipo findIdEquipo(PromocionDet entity) {
        return this.getMergedEntity(entity).getIdEquipo();
    }

    public boolean isPromocionEmpty(PromocionDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PromocionDet> promocionDet = cq.from(PromocionDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocionDet, entity), cb.isNotNull(promocionDet.get(PromocionDet_.promocion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Promocion findPromocion(PromocionDet entity) {
        return this.getMergedEntity(entity).getPromocion();
    }

    public boolean isIdServicioEmpty(PromocionDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PromocionDet> promocionDet = cq.from(PromocionDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocionDet, entity), cb.isNotNull(promocionDet.get(PromocionDet_.idServicio)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Servicio findIdServicio(PromocionDet entity) {
        return this.getMergedEntity(entity).getIdServicio();
    }
    
}
