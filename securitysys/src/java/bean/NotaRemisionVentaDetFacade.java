/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.NotaRemisionVentaDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Equipo;
import entities.NotaRemisionVenta;

/**
 *
 * @author acer
 */
@Stateless
public class NotaRemisionVentaDetFacade extends AbstractFacade<NotaRemisionVentaDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaRemisionVentaDetFacade() {
        super(NotaRemisionVentaDet.class);
    }

    public boolean isIdEquipoEmpty(NotaRemisionVentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVentaDet> notaRemisionVentaDet = cq.from(NotaRemisionVentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVentaDet, entity), cb.isNotNull(notaRemisionVentaDet.get(NotaRemisionVentaDet_.idEquipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipo findIdEquipo(NotaRemisionVentaDet entity) {
        return this.getMergedEntity(entity).getIdEquipo();
    }

    public boolean isNotaRemisionVentaEmpty(NotaRemisionVentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVentaDet> notaRemisionVentaDet = cq.from(NotaRemisionVentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVentaDet, entity), cb.isNotNull(notaRemisionVentaDet.get(NotaRemisionVentaDet_.notaRemisionVenta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public NotaRemisionVenta findNotaRemisionVenta(NotaRemisionVentaDet entity) {
        return this.getMergedEntity(entity).getNotaRemisionVenta();
    }
    
}
