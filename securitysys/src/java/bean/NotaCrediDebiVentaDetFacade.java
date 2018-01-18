/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.NotaCrediDebiVentaDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Equipo;
import entities.NotaCrediDebiVenta;

/**
 *
 * @author acer
 */
@Stateless
public class NotaCrediDebiVentaDetFacade extends AbstractFacade<NotaCrediDebiVentaDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaCrediDebiVentaDetFacade() {
        super(NotaCrediDebiVentaDet.class);
    }

    public boolean isIdEquipoEmpty(NotaCrediDebiVentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVentaDet> notaCrediDebiVentaDet = cq.from(NotaCrediDebiVentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVentaDet, entity), cb.isNotNull(notaCrediDebiVentaDet.get(NotaCrediDebiVentaDet_.idEquipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipo findIdEquipo(NotaCrediDebiVentaDet entity) {
        return this.getMergedEntity(entity).getIdEquipo();
    }

    public boolean isNotaCrediDebiVentaEmpty(NotaCrediDebiVentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVentaDet> notaCrediDebiVentaDet = cq.from(NotaCrediDebiVentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVentaDet, entity), cb.isNotNull(notaCrediDebiVentaDet.get(NotaCrediDebiVentaDet_.notaCrediDebiVenta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public NotaCrediDebiVenta findNotaCrediDebiVenta(NotaCrediDebiVentaDet entity) {
        return this.getMergedEntity(entity).getNotaCrediDebiVenta();
    }
    
}
