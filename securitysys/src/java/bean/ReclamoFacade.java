/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Reclamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.OrdenTrabajo;
import entities.Cliente;
import entities.Departamento;
import entities.Estado;
import entities.Sucursal;
import entities.TipoReclamo;
import entities.Usuario;
import entities.Diagnostico;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author expsee
 */
@Stateless
public class ReclamoFacade extends AbstractFacade<Reclamo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamoFacade() {
        super(Reclamo.class);
    }

    public boolean isOrdenTrabajoListEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotEmpty(reclamo.get(Reclamo_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Reclamo entity) {
        Reclamo mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isIdClienteEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotNull(reclamo.get(Reclamo_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(Reclamo entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdDepartamentoEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotNull(reclamo.get(Reclamo_.idDepartamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamento findIdDepartamento(Reclamo entity) {
        return this.getMergedEntity(entity).getIdDepartamento();
    }

    public boolean isIdEstadoEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotNull(reclamo.get(Reclamo_.idEstado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Estado findIdEstado(Reclamo entity) {
        return this.getMergedEntity(entity).getIdEstado();
    }

    public boolean isIdSucursalEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotNull(reclamo.get(Reclamo_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Reclamo entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdTipoReclamoEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotNull(reclamo.get(Reclamo_.idTipoReclamo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoReclamo findIdTipoReclamo(Reclamo entity) {
        return this.getMergedEntity(entity).getIdTipoReclamo();
    }

    public boolean isIdUsuarioEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotNull(reclamo.get(Reclamo_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Reclamo entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isDiagnosticoListEmpty(Reclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reclamo> reclamo = cq.from(Reclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reclamo, entity), cb.isNotEmpty(reclamo.get(Reclamo_.diagnosticoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Diagnostico> findDiagnosticoList(Reclamo entity) {
        Reclamo mergedEntity = this.getMergedEntity(entity);
        List<Diagnostico> diagnosticoList = mergedEntity.getDiagnosticoList();
        diagnosticoList.size();
        return diagnosticoList;
    }

      public Reclamo findByIdReclamo(Integer idReclamo) {
        try {
            return (Reclamo) em.createNamedQuery("Reclamo.findByIdReclamo").setParameter("idReclamo", idReclamo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Reclamo> findBetweenfechaAlta(Date startDate, Date endDate) {
        try {
            return (List<Reclamo>) em.createNamedQuery("Reclamo.findBetweenfechaAlta")
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Reclamo> findAll() {
        try {
            return (List<Reclamo>) em.createNamedQuery("Reclamo.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
