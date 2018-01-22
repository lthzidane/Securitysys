/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Servicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.SolicitudDet;
import entities.PromocionDet;
import entities.Contrato;
import entities.Descuento;
import entities.Estado;
import entities.Moneda;
import entities.Promocion;
import entities.SegmentoContrato;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }

    public boolean isSolicitudDetListEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotEmpty(servicio.get(Servicio_.solicitudDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SolicitudDet> findSolicitudDetList(Servicio entity) {
        Servicio mergedEntity = this.getMergedEntity(entity);
        List<SolicitudDet> solicitudDetList = mergedEntity.getSolicitudDetList();
        solicitudDetList.size();
        return solicitudDetList;
    }

    public boolean isPromocionDetListEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotEmpty(servicio.get(Servicio_.promocionDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PromocionDet> findPromocionDetList(Servicio entity) {
        Servicio mergedEntity = this.getMergedEntity(entity);
        List<PromocionDet> promocionDetList = mergedEntity.getPromocionDetList();
        promocionDetList.size();
        return promocionDetList;
    }

    public boolean isContratoListEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotEmpty(servicio.get(Servicio_.contratoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Contrato> findContratoList(Servicio entity) {
        Servicio mergedEntity = this.getMergedEntity(entity);
        List<Contrato> contratoList = mergedEntity.getContratoList();
        contratoList.size();
        return contratoList;
    }

    public boolean isIdDescuentoEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotNull(servicio.get(Servicio_.idDescuento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Descuento findIdDescuento(Servicio entity) {
        return this.getMergedEntity(entity).getIdDescuento();
    }

    public boolean isIdEstadoEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotNull(servicio.get(Servicio_.idEstado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Estado findIdEstado(Servicio entity) {
        return this.getMergedEntity(entity).getIdEstado();
    }

    public boolean isIdMonedaEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotNull(servicio.get(Servicio_.idMoneda)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Moneda findIdMoneda(Servicio entity) {
        return this.getMergedEntity(entity).getIdMoneda();
    }

    public boolean isIdPromocionEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotNull(servicio.get(Servicio_.idPromocion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Promocion findIdPromocion(Servicio entity) {
        return this.getMergedEntity(entity).getIdPromocion();
    }

    public boolean isSegmentoContratoListEmpty(Servicio entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Servicio> servicio = cq.from(Servicio.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servicio, entity), cb.isNotEmpty(servicio.get(Servicio_.segmentoContratoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SegmentoContrato> findSegmentoContratoList(Servicio entity) {
        Servicio mergedEntity = this.getMergedEntity(entity);
        List<SegmentoContrato> segmentoContratoList = mergedEntity.getSegmentoContratoList();
        segmentoContratoList.size();
        return segmentoContratoList;
    }
    
}
