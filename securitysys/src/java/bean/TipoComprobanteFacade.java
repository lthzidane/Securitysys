/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoComprobante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Timbrado;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import entities.NotaRemisionVenta;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class TipoComprobanteFacade extends AbstractFacade<TipoComprobante> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoComprobanteFacade() {
        super(TipoComprobante.class);
    }

    public boolean isTimbradoListEmpty(TipoComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoComprobante> tipoComprobante = cq.from(TipoComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoComprobante, entity), cb.isNotEmpty(tipoComprobante.get(TipoComprobante_.timbradoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Timbrado> findTimbradoList(TipoComprobante entity) {
        TipoComprobante mergedEntity = this.getMergedEntity(entity);
        List<Timbrado> timbradoList = mergedEntity.getTimbradoList();
        timbradoList.size();
        return timbradoList;
    }

    public boolean isVentaListEmpty(TipoComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoComprobante> tipoComprobante = cq.from(TipoComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoComprobante, entity), cb.isNotEmpty(tipoComprobante.get(TipoComprobante_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(TipoComprobante entity) {
        TipoComprobante mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }

    public boolean isNotaCrediDebiVentaListEmpty(TipoComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoComprobante> tipoComprobante = cq.from(TipoComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoComprobante, entity), cb.isNotEmpty(tipoComprobante.get(TipoComprobante_.notaCrediDebiVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVenta> findNotaCrediDebiVentaList(TipoComprobante entity) {
        TipoComprobante mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVenta> notaCrediDebiVentaList = mergedEntity.getNotaCrediDebiVentaList();
        notaCrediDebiVentaList.size();
        return notaCrediDebiVentaList;
    }

    public boolean isNotaRemisionVentaListEmpty(TipoComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoComprobante> tipoComprobante = cq.from(TipoComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoComprobante, entity), cb.isNotEmpty(tipoComprobante.get(TipoComprobante_.notaRemisionVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVenta> findNotaRemisionVentaList(TipoComprobante entity) {
        TipoComprobante mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVenta> notaRemisionVentaList = mergedEntity.getNotaRemisionVentaList();
        notaRemisionVentaList.size();
        return notaRemisionVentaList;
    }
    
}
