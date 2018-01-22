/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Timbrado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.TipoComprobante;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class TimbradoFacade extends AbstractFacade<Timbrado> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimbradoFacade() {
        super(Timbrado.class);
    }

    public boolean isIdTipoComprobanteEmpty(Timbrado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Timbrado> timbrado = cq.from(Timbrado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(timbrado, entity), cb.isNotNull(timbrado.get(Timbrado_.idTipoComprobante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoComprobante findIdTipoComprobante(Timbrado entity) {
        return this.getMergedEntity(entity).getIdTipoComprobante();
    }

    public boolean isVentaListEmpty(Timbrado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Timbrado> timbrado = cq.from(Timbrado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(timbrado, entity), cb.isNotEmpty(timbrado.get(Timbrado_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(Timbrado entity) {
        Timbrado mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }

    public boolean isNotaCrediDebiVentaListEmpty(Timbrado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Timbrado> timbrado = cq.from(Timbrado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(timbrado, entity), cb.isNotEmpty(timbrado.get(Timbrado_.notaCrediDebiVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVenta> findNotaCrediDebiVentaList(Timbrado entity) {
        Timbrado mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVenta> notaCrediDebiVentaList = mergedEntity.getNotaCrediDebiVentaList();
        notaCrediDebiVentaList.size();
        return notaCrediDebiVentaList;
    }
    
}
