/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.OrdenTrabajo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.InstalacionCab;
import entities.OrdenTrabajoDet;
import entities.Cliente;
import entities.Cuadrilla;
import entities.Itinerario;
import entities.Presupuesto;
import entities.Reclamo;
import entities.Solicitud;
import entities.Sucursal;
import entities.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class OrdenTrabajoFacade extends AbstractFacade<OrdenTrabajo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenTrabajoFacade() {
        super(OrdenTrabajo.class);
    }

    public boolean isInstalacionCabListEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotEmpty(ordenTrabajo.get(OrdenTrabajo_.instalacionCabList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<InstalacionCab> findInstalacionCabList(OrdenTrabajo entity) {
        OrdenTrabajo mergedEntity = this.getMergedEntity(entity);
        List<InstalacionCab> instalacionCabList = mergedEntity.getInstalacionCabList();
        instalacionCabList.size();
        return instalacionCabList;
    }

    public boolean isOrdenTrabajoDetListEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotEmpty(ordenTrabajo.get(OrdenTrabajo_.ordenTrabajoDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajoDet> findOrdenTrabajoDetList(OrdenTrabajo entity) {
        OrdenTrabajo mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajoDet> ordenTrabajoDetList = mergedEntity.getOrdenTrabajoDetList();
        ordenTrabajoDetList.size();
        return ordenTrabajoDetList;
    }

    public boolean isIdClienteEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdCuadrillaEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idCuadrilla)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cuadrilla findIdCuadrilla(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdCuadrilla();
    }

    public boolean isIdItinerarioEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idItinerario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Itinerario findIdItinerario(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdItinerario();
    }

    public boolean isIdPresupuestoEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idPresupuesto)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Presupuesto findIdPresupuesto(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdPresupuesto();
    }

    public boolean isIdReclamoEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idReclamo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Reclamo findIdReclamo(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdReclamo();
    }

    public boolean isIdSolicitudEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idSolicitud)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Solicitud findIdSolicitud(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdSolicitud();
    }

    public boolean isIdSucursalEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdUsuarioEmpty(OrdenTrabajo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdenTrabajo> ordenTrabajo = cq.from(OrdenTrabajo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ordenTrabajo, entity), cb.isNotNull(ordenTrabajo.get(OrdenTrabajo_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(OrdenTrabajo entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    OrdenTrabajo findByNroOrden(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Iterable<OrdenTrabajo> findBetweenFechaOrden(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
