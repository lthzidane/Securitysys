/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.SerieComprobante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import entities.Sucursal;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class SerieComprobanteFacade extends AbstractFacade<SerieComprobante> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SerieComprobanteFacade() {
        super(SerieComprobante.class);
    }

    public boolean isVentaListEmpty(SerieComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SerieComprobante> serieComprobante = cq.from(SerieComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(serieComprobante, entity), cb.isNotEmpty(serieComprobante.get(SerieComprobante_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(SerieComprobante entity) {
        SerieComprobante mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }

    public boolean isNotaCrediDebiVentaListEmpty(SerieComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SerieComprobante> serieComprobante = cq.from(SerieComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(serieComprobante, entity), cb.isNotEmpty(serieComprobante.get(SerieComprobante_.notaCrediDebiVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVenta> findNotaCrediDebiVentaList(SerieComprobante entity) {
        SerieComprobante mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVenta> notaCrediDebiVentaList = mergedEntity.getNotaCrediDebiVentaList();
        notaCrediDebiVentaList.size();
        return notaCrediDebiVentaList;
    }

    public boolean isIdSucursalEmpty(SerieComprobante entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SerieComprobante> serieComprobante = cq.from(SerieComprobante.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(serieComprobante, entity), cb.isNotNull(serieComprobante.get(SerieComprobante_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(SerieComprobante entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }
    
}
