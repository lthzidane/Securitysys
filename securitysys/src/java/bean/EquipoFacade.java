/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Equipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.PromocionDet;
import entities.NotaCrediDebiVentaDet;
import entities.DiagnosticoDet;
import entities.NotaRemisionVentaDet;
import entities.VentaDet;
import entities.InstalacionDet;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class EquipoFacade extends AbstractFacade<Equipo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipoFacade() {
        super(Equipo.class);
    }

    public boolean isPromocionDetListEmpty(Equipo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipo> equipo = cq.from(Equipo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipo, entity), cb.isNotEmpty(equipo.get(Equipo_.promocionDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PromocionDet> findPromocionDetList(Equipo entity) {
        Equipo mergedEntity = this.getMergedEntity(entity);
        List<PromocionDet> promocionDetList = mergedEntity.getPromocionDetList();
        promocionDetList.size();
        return promocionDetList;
    }

    public boolean isNotaCrediDebiVentaDetListEmpty(Equipo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipo> equipo = cq.from(Equipo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipo, entity), cb.isNotEmpty(equipo.get(Equipo_.notaCrediDebiVentaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVentaDet> findNotaCrediDebiVentaDetList(Equipo entity) {
        Equipo mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVentaDet> notaCrediDebiVentaDetList = mergedEntity.getNotaCrediDebiVentaDetList();
        notaCrediDebiVentaDetList.size();
        return notaCrediDebiVentaDetList;
    }

    public boolean isDiagnosticoDetListEmpty(Equipo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipo> equipo = cq.from(Equipo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipo, entity), cb.isNotEmpty(equipo.get(Equipo_.diagnosticoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<DiagnosticoDet> findDiagnosticoDetList(Equipo entity) {
        Equipo mergedEntity = this.getMergedEntity(entity);
        List<DiagnosticoDet> diagnosticoDetList = mergedEntity.getDiagnosticoDetList();
        diagnosticoDetList.size();
        return diagnosticoDetList;
    }

    public boolean isNotaRemisionVentaDetListEmpty(Equipo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipo> equipo = cq.from(Equipo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipo, entity), cb.isNotEmpty(equipo.get(Equipo_.notaRemisionVentaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVentaDet> findNotaRemisionVentaDetList(Equipo entity) {
        Equipo mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVentaDet> notaRemisionVentaDetList = mergedEntity.getNotaRemisionVentaDetList();
        notaRemisionVentaDetList.size();
        return notaRemisionVentaDetList;
    }

    public boolean isVentaDetListEmpty(Equipo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipo> equipo = cq.from(Equipo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipo, entity), cb.isNotEmpty(equipo.get(Equipo_.ventaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<VentaDet> findVentaDetList(Equipo entity) {
        Equipo mergedEntity = this.getMergedEntity(entity);
        List<VentaDet> ventaDetList = mergedEntity.getVentaDetList();
        ventaDetList.size();
        return ventaDetList;
    }

    public boolean isInstalacionDetListEmpty(Equipo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipo> equipo = cq.from(Equipo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipo, entity), cb.isNotEmpty(equipo.get(Equipo_.instalacionDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<InstalacionDet> findInstalacionDetList(Equipo entity) {
        Equipo mergedEntity = this.getMergedEntity(entity);
        List<InstalacionDet> instalacionDetList = mergedEntity.getInstalacionDetList();
        instalacionDetList.size();
        return instalacionDetList;
    }
    
}
