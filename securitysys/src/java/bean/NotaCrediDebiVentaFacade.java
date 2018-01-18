/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.NotaCrediDebiVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.NotaCrediDebiVentaDet;
import entities.MotivoNotaDebi;
import entities.SerieComprobante;
import entities.Sucursal;
import entities.Timbrado;
import entities.TipoComprobante;
import entities.Usuario;
import entities.Venta;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class NotaCrediDebiVentaFacade extends AbstractFacade<NotaCrediDebiVenta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaCrediDebiVentaFacade() {
        super(NotaCrediDebiVenta.class);
    }

    public boolean isNotaCrediDebiVentaDetListEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotEmpty(notaCrediDebiVenta.get(NotaCrediDebiVenta_.notaCrediDebiVentaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVentaDet> findNotaCrediDebiVentaDetList(NotaCrediDebiVenta entity) {
        NotaCrediDebiVenta mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVentaDet> notaCrediDebiVentaDetList = mergedEntity.getNotaCrediDebiVentaDetList();
        notaCrediDebiVentaDetList.size();
        return notaCrediDebiVentaDetList;
    }

    public boolean isIdMotivoNotaEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idMotivoNota)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public MotivoNotaDebi findIdMotivoNota(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdMotivoNota();
    }

    public boolean isIdSerieComprobanteEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idSerieComprobante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SerieComprobante findIdSerieComprobante(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdSerieComprobante();
    }

    public boolean isIdSucursalEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdTimbradoEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idTimbrado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Timbrado findIdTimbrado(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdTimbrado();
    }

    public boolean isIdTipoComprobanteEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idTipoComprobante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoComprobante findIdTipoComprobante(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdTipoComprobante();
    }

    public boolean isIdUsuarioEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isIdVentaEmpty(NotaCrediDebiVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<NotaCrediDebiVenta> notaCrediDebiVenta = cq.from(NotaCrediDebiVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(notaCrediDebiVenta, entity), cb.isNotNull(notaCrediDebiVenta.get(NotaCrediDebiVenta_.idVenta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Venta findIdVenta(NotaCrediDebiVenta entity) {
        return this.getMergedEntity(entity).getIdVenta();
    }
    
}
