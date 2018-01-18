/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Promocion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Presupuesto;
import entities.Sucursal;
import entities.Usuario;
import entities.SolicitudDet;
import entities.PromocionDet;
import entities.PresupuestoDet;
import entities.Servicio;
import entities.VentaDet;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class PromocionFacade extends AbstractFacade<Promocion> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromocionFacade() {
        super(Promocion.class);
    }

    public boolean isPresupuestoEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotNull(promocion.get(Promocion_.presupuesto)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Presupuesto findPresupuesto(Promocion entity) {
        return this.getMergedEntity(entity).getPresupuesto();
    }

    public boolean isIdSucursalEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotNull(promocion.get(Promocion_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Promocion entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdUsuarioEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotNull(promocion.get(Promocion_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Promocion entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isSolicitudDetListEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotEmpty(promocion.get(Promocion_.solicitudDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SolicitudDet> findSolicitudDetList(Promocion entity) {
        Promocion mergedEntity = this.getMergedEntity(entity);
        List<SolicitudDet> solicitudDetList = mergedEntity.getSolicitudDetList();
        solicitudDetList.size();
        return solicitudDetList;
    }

    public boolean isPromocionDetListEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotEmpty(promocion.get(Promocion_.promocionDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PromocionDet> findPromocionDetList(Promocion entity) {
        Promocion mergedEntity = this.getMergedEntity(entity);
        List<PromocionDet> promocionDetList = mergedEntity.getPromocionDetList();
        promocionDetList.size();
        return promocionDetList;
    }

    public boolean isPresupuestoDetListEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotEmpty(promocion.get(Promocion_.presupuestoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PresupuestoDet> findPresupuestoDetList(Promocion entity) {
        Promocion mergedEntity = this.getMergedEntity(entity);
        List<PresupuestoDet> presupuestoDetList = mergedEntity.getPresupuestoDetList();
        presupuestoDetList.size();
        return presupuestoDetList;
    }

    public boolean isServicioListEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotEmpty(promocion.get(Promocion_.servicioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Servicio> findServicioList(Promocion entity) {
        Promocion mergedEntity = this.getMergedEntity(entity);
        List<Servicio> servicioList = mergedEntity.getServicioList();
        servicioList.size();
        return servicioList;
    }

    public boolean isVentaDetListEmpty(Promocion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Promocion> promocion = cq.from(Promocion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(promocion, entity), cb.isNotEmpty(promocion.get(Promocion_.ventaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<VentaDet> findVentaDetList(Promocion entity) {
        Promocion mergedEntity = this.getMergedEntity(entity);
        List<VentaDet> ventaDetList = mergedEntity.getVentaDetList();
        ventaDetList.size();
        return ventaDetList;
    }
    
}
