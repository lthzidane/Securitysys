/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Diagnostico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.DiagnosticoDet;
import entities.Presupuesto;
import entities.Reclamo;
import entities.Sucursal;
import entities.Usuario;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class DiagnosticoFacade extends AbstractFacade<Diagnostico> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticoFacade() {
        super(Diagnostico.class);
    }

    public boolean isDiagnosticoDetListEmpty(Diagnostico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Diagnostico> diagnostico = cq.from(Diagnostico.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnostico, entity), cb.isNotEmpty(diagnostico.get(Diagnostico_.diagnosticoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<DiagnosticoDet> findDiagnosticoDetList(Diagnostico entity) {
        Diagnostico mergedEntity = this.getMergedEntity(entity);
        List<DiagnosticoDet> diagnosticoDetList = mergedEntity.getDiagnosticoDetList();
        diagnosticoDetList.size();
        return diagnosticoDetList;
    }

    public boolean isPresupuestoListEmpty(Diagnostico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Diagnostico> diagnostico = cq.from(Diagnostico.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnostico, entity), cb.isNotEmpty(diagnostico.get(Diagnostico_.presupuestoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Presupuesto> findPresupuestoList(Diagnostico entity) {
        Diagnostico mergedEntity = this.getMergedEntity(entity);
        List<Presupuesto> presupuestoList = mergedEntity.getPresupuestoList();
        presupuestoList.size();
        return presupuestoList;
    }

    public boolean isIdReclamoEmpty(Diagnostico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Diagnostico> diagnostico = cq.from(Diagnostico.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnostico, entity), cb.isNotNull(diagnostico.get(Diagnostico_.idReclamo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Reclamo findIdReclamo(Diagnostico entity) {
        return this.getMergedEntity(entity).getIdReclamo();
    }

    public boolean isIdSucursalEmpty(Diagnostico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Diagnostico> diagnostico = cq.from(Diagnostico.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnostico, entity), cb.isNotNull(diagnostico.get(Diagnostico_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Diagnostico entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdUsuarioEmpty(Diagnostico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Diagnostico> diagnostico = cq.from(Diagnostico.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnostico, entity), cb.isNotNull(diagnostico.get(Diagnostico_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Diagnostico entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }
    
}
