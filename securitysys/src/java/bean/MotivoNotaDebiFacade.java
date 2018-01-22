/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.MotivoNotaDebi;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.NotaCrediDebiVenta;
import entities.NotaRemisionVenta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class MotivoNotaDebiFacade extends AbstractFacade<MotivoNotaDebi> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivoNotaDebiFacade() {
        super(MotivoNotaDebi.class);
    }

    public boolean isNotaCrediDebiVentaListEmpty(MotivoNotaDebi entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MotivoNotaDebi> motivoNotaDebi = cq.from(MotivoNotaDebi.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(motivoNotaDebi, entity), cb.isNotEmpty(motivoNotaDebi.get(MotivoNotaDebi_.notaCrediDebiVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVenta> findNotaCrediDebiVentaList(MotivoNotaDebi entity) {
        MotivoNotaDebi mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVenta> notaCrediDebiVentaList = mergedEntity.getNotaCrediDebiVentaList();
        notaCrediDebiVentaList.size();
        return notaCrediDebiVentaList;
    }

    public boolean isNotaRemisionVentaListEmpty(MotivoNotaDebi entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MotivoNotaDebi> motivoNotaDebi = cq.from(MotivoNotaDebi.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(motivoNotaDebi, entity), cb.isNotEmpty(motivoNotaDebi.get(MotivoNotaDebi_.notaRemisionVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVenta> findNotaRemisionVentaList(MotivoNotaDebi entity) {
        MotivoNotaDebi mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVenta> notaRemisionVentaList = mergedEntity.getNotaRemisionVentaList();
        notaRemisionVentaList.size();
        return notaRemisionVentaList;
    }
    
}
