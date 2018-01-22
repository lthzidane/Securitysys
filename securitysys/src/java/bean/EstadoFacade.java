/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CuentaCliente;
import entities.Contrato;
import entities.Presupuesto;
import entities.Reclamo;
import entities.Servicio;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }

    public boolean isCuentaClienteListEmpty(Estado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Estado> estado = cq.from(Estado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(estado, entity), cb.isNotEmpty(estado.get(Estado_.cuentaClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CuentaCliente> findCuentaClienteList(Estado entity) {
        Estado mergedEntity = this.getMergedEntity(entity);
        List<CuentaCliente> cuentaClienteList = mergedEntity.getCuentaClienteList();
        cuentaClienteList.size();
        return cuentaClienteList;
    }

    public boolean isContratoListEmpty(Estado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Estado> estado = cq.from(Estado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(estado, entity), cb.isNotEmpty(estado.get(Estado_.contratoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Contrato> findContratoList(Estado entity) {
        Estado mergedEntity = this.getMergedEntity(entity);
        List<Contrato> contratoList = mergedEntity.getContratoList();
        contratoList.size();
        return contratoList;
    }

    public boolean isPresupuestoListEmpty(Estado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Estado> estado = cq.from(Estado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(estado, entity), cb.isNotEmpty(estado.get(Estado_.presupuestoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Presupuesto> findPresupuestoList(Estado entity) {
        Estado mergedEntity = this.getMergedEntity(entity);
        List<Presupuesto> presupuestoList = mergedEntity.getPresupuestoList();
        presupuestoList.size();
        return presupuestoList;
    }

    public boolean isReclamoListEmpty(Estado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Estado> estado = cq.from(Estado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(estado, entity), cb.isNotEmpty(estado.get(Estado_.reclamoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Reclamo> findReclamoList(Estado entity) {
        Estado mergedEntity = this.getMergedEntity(entity);
        List<Reclamo> reclamoList = mergedEntity.getReclamoList();
        reclamoList.size();
        return reclamoList;
    }

    public boolean isServicioListEmpty(Estado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Estado> estado = cq.from(Estado.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(estado, entity), cb.isNotEmpty(estado.get(Estado_.servicioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Servicio> findServicioList(Estado entity) {
        Estado mergedEntity = this.getMergedEntity(entity);
        List<Servicio> servicioList = mergedEntity.getServicioList();
        servicioList.size();
        return servicioList;
    }
    
}
