/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.VentaDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Descuento;
import entities.Equipo;
import entities.Promocion;
import entities.Venta;

/**
 *
 * @author expsee
 */
@Stateless
public class VentaDetFacade extends AbstractFacade<VentaDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaDetFacade() {
        super(VentaDet.class);
    }

    public boolean isIdDescuentoEmpty(VentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<VentaDet> ventaDet = cq.from(VentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ventaDet, entity), cb.isNotNull(ventaDet.get(VentaDet_.idDescuento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Descuento findIdDescuento(VentaDet entity) {
        return this.getMergedEntity(entity).getIdDescuento();
    }

    public boolean isIdEquipoEmpty(VentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<VentaDet> ventaDet = cq.from(VentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ventaDet, entity), cb.isNotNull(ventaDet.get(VentaDet_.idEquipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipo findIdEquipo(VentaDet entity) {
        return this.getMergedEntity(entity).getIdEquipo();
    }

    public boolean isIdPromocionEmpty(VentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<VentaDet> ventaDet = cq.from(VentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ventaDet, entity), cb.isNotNull(ventaDet.get(VentaDet_.idPromocion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Promocion findIdPromocion(VentaDet entity) {
        return this.getMergedEntity(entity).getIdPromocion();
    }

    public boolean isVentaEmpty(VentaDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<VentaDet> ventaDet = cq.from(VentaDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ventaDet, entity), cb.isNotNull(ventaDet.get(VentaDet_.venta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Venta findVenta(VentaDet entity) {
        return this.getMergedEntity(entity).getVenta();
    }
    
}
