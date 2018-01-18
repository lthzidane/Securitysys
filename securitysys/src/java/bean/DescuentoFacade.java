/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Descuento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.SolicitudDet;
import entities.DescuentoDet;
import entities.PresupuestoDet;
import entities.Servicio;
import entities.VentaDet;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class DescuentoFacade extends AbstractFacade<Descuento> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DescuentoFacade() {
        super(Descuento.class);
    }

    public boolean isSolicitudDetListEmpty(Descuento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Descuento> descuento = cq.from(Descuento.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(descuento, entity), cb.isNotEmpty(descuento.get(Descuento_.solicitudDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SolicitudDet> findSolicitudDetList(Descuento entity) {
        Descuento mergedEntity = this.getMergedEntity(entity);
        List<SolicitudDet> solicitudDetList = mergedEntity.getSolicitudDetList();
        solicitudDetList.size();
        return solicitudDetList;
    }

    public boolean isDescuentoDetListEmpty(Descuento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Descuento> descuento = cq.from(Descuento.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(descuento, entity), cb.isNotEmpty(descuento.get(Descuento_.descuentoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<DescuentoDet> findDescuentoDetList(Descuento entity) {
        Descuento mergedEntity = this.getMergedEntity(entity);
        List<DescuentoDet> descuentoDetList = mergedEntity.getDescuentoDetList();
        descuentoDetList.size();
        return descuentoDetList;
    }

    public boolean isPresupuestoDetListEmpty(Descuento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Descuento> descuento = cq.from(Descuento.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(descuento, entity), cb.isNotEmpty(descuento.get(Descuento_.presupuestoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PresupuestoDet> findPresupuestoDetList(Descuento entity) {
        Descuento mergedEntity = this.getMergedEntity(entity);
        List<PresupuestoDet> presupuestoDetList = mergedEntity.getPresupuestoDetList();
        presupuestoDetList.size();
        return presupuestoDetList;
    }

    public boolean isServicioListEmpty(Descuento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Descuento> descuento = cq.from(Descuento.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(descuento, entity), cb.isNotEmpty(descuento.get(Descuento_.servicioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Servicio> findServicioList(Descuento entity) {
        Descuento mergedEntity = this.getMergedEntity(entity);
        List<Servicio> servicioList = mergedEntity.getServicioList();
        servicioList.size();
        return servicioList;
    }

    public boolean isVentaDetListEmpty(Descuento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Descuento> descuento = cq.from(Descuento.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(descuento, entity), cb.isNotEmpty(descuento.get(Descuento_.ventaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<VentaDet> findVentaDetList(Descuento entity) {
        Descuento mergedEntity = this.getMergedEntity(entity);
        List<VentaDet> ventaDetList = mergedEntity.getVentaDetList();
        ventaDetList.size();
        return ventaDetList;
    }
    
}
