/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.NotaRemisionVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.NotaRemisionVentaDet;
import entities.MotivoNotaDebi;
import entities.Moviles;
import entities.Sucursal;
import entities.TipoComprobante;
import entities.Usuario;
import entities.Venta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class NotaRemisionVentaFacade extends AbstractFacade<NotaRemisionVenta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaRemisionVentaFacade() {
        super(NotaRemisionVenta.class);
    }

    public boolean isNotaRemisionVentaDetListEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotEmpty(notaRemisionVenta.get(NotaRemisionVenta_.notaRemisionVentaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVentaDet> findNotaRemisionVentaDetList(NotaRemisionVenta entity) {
        NotaRemisionVenta mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVentaDet> notaRemisionVentaDetList = mergedEntity.getNotaRemisionVentaDetList();
        notaRemisionVentaDetList.size();
        return notaRemisionVentaDetList;
    }

    public boolean isIdMotivoNotaEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotNull(notaRemisionVenta.get(NotaRemisionVenta_.idMotivoNota)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public MotivoNotaDebi findIdMotivoNota(NotaRemisionVenta entity) {
        return this.getMergedEntity(entity).getIdMotivoNota();
    }

    public boolean isIdMovilEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotNull(notaRemisionVenta.get(NotaRemisionVenta_.idMovil)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Moviles findIdMovil(NotaRemisionVenta entity) {
        return this.getMergedEntity(entity).getIdMovil();
    }

    public boolean isIdSucursalEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotNull(notaRemisionVenta.get(NotaRemisionVenta_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(NotaRemisionVenta entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdTipoComprobanteEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotNull(notaRemisionVenta.get(NotaRemisionVenta_.idTipoComprobante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoComprobante findIdTipoComprobante(NotaRemisionVenta entity) {
        return this.getMergedEntity(entity).getIdTipoComprobante();
    }

    public boolean isIdUsuarioEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotNull(notaRemisionVenta.get(NotaRemisionVenta_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(NotaRemisionVenta entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isIdVentaEmpty(NotaRemisionVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaRemisionVenta> notaRemisionVenta = cq.from(NotaRemisionVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaRemisionVenta, entity), cb.isNotNull(notaRemisionVenta.get(NotaRemisionVenta_.idVenta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Venta findIdVenta(NotaRemisionVenta entity) {
        return this.getMergedEntity(entity).getIdVenta();
    }
    
}
