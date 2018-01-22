/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.SolicitudDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Descuento;
import entities.Promocion;
import entities.Servicio;
import entities.Solicitud;

/**
 *
 * @author expsee
 */
@Stateless
public class SolicitudDetFacade extends AbstractFacade<SolicitudDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudDetFacade() {
        super(SolicitudDet.class);
    }

    public boolean isIdDescuentoEmpty(SolicitudDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudDet> solicitudDet = cq.from(SolicitudDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudDet, entity), cb.isNotNull(solicitudDet.get(SolicitudDet_.idDescuento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Descuento findIdDescuento(SolicitudDet entity) {
        return this.getMergedEntity(entity).getIdDescuento();
    }

    public boolean isIdPromocionEmpty(SolicitudDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudDet> solicitudDet = cq.from(SolicitudDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudDet, entity), cb.isNotNull(solicitudDet.get(SolicitudDet_.idPromocion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Promocion findIdPromocion(SolicitudDet entity) {
        return this.getMergedEntity(entity).getIdPromocion();
    }

    public boolean isIdServicioEmpty(SolicitudDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudDet> solicitudDet = cq.from(SolicitudDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudDet, entity), cb.isNotNull(solicitudDet.get(SolicitudDet_.idServicio)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Servicio findIdServicio(SolicitudDet entity) {
        return this.getMergedEntity(entity).getIdServicio();
    }

    public boolean isSolicitudEmpty(SolicitudDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudDet> solicitudDet = cq.from(SolicitudDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitudDet, entity), cb.isNotNull(solicitudDet.get(SolicitudDet_.solicitud)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Solicitud findSolicitud(SolicitudDet entity) {
        return this.getMergedEntity(entity).getSolicitud();
    }
    
}
