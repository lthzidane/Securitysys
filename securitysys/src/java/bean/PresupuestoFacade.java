/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Presupuesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Promocion;
import entities.PresupuestoDet;
import entities.Cliente;
import entities.Diagnostico;
import entities.Estado;
import entities.Sucursal;
import entities.Usuario;
import entities.OrdenTrabajo;
import entities.Venta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class PresupuestoFacade extends AbstractFacade<Presupuesto> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoFacade() {
        super(Presupuesto.class);
    }

    public boolean isPromocionEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotNull(presupuesto.get(Presupuesto_.promocion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Promocion findPromocion(Presupuesto entity) {
        return this.getMergedEntity(entity).getPromocion();
    }

    public boolean isPresupuestoDetListEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotEmpty(presupuesto.get(Presupuesto_.presupuestoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PresupuestoDet> findPresupuestoDetList(Presupuesto entity) {
        Presupuesto mergedEntity = this.getMergedEntity(entity);
        List<PresupuestoDet> presupuestoDetList = mergedEntity.getPresupuestoDetList();
        presupuestoDetList.size();
        return presupuestoDetList;
    }

    public boolean isIdClienteEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotNull(presupuesto.get(Presupuesto_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(Presupuesto entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotNull(presupuesto.get(Presupuesto_.id)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Diagnostico findId(Presupuesto entity) {
        return this.getMergedEntity(entity).getId();
    }

    public boolean isIdEstadoEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotNull(presupuesto.get(Presupuesto_.idEstado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Estado findIdEstado(Presupuesto entity) {
        return this.getMergedEntity(entity).getIdEstado();
    }

    public boolean isIdSucursalEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotNull(presupuesto.get(Presupuesto_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Presupuesto entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdUsuarioEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotNull(presupuesto.get(Presupuesto_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Presupuesto entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isOrdenTrabajoListEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotEmpty(presupuesto.get(Presupuesto_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Presupuesto entity) {
        Presupuesto mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isVentaListEmpty(Presupuesto entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Presupuesto> presupuesto = cq.from(Presupuesto.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(presupuesto, entity), cb.isNotEmpty(presupuesto.get(Presupuesto_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(Presupuesto entity) {
        Presupuesto mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }
    
}
