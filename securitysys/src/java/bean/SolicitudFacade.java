/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Solicitud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.SolicitudDet;
import entities.OrdenTrabajo;
import entities.Cliente;
import entities.Sucursal;
import entities.Usuario;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class SolicitudFacade extends AbstractFacade<Solicitud> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudFacade() {
        super(Solicitud.class);
    }

    public boolean isSolicitudDetListEmpty(Solicitud entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Solicitud> solicitud = cq.from(Solicitud.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitud, entity), cb.isNotEmpty(solicitud.get(Solicitud_.solicitudDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SolicitudDet> findSolicitudDetList(Solicitud entity) {
        Solicitud mergedEntity = this.getMergedEntity(entity);
        List<SolicitudDet> solicitudDetList = mergedEntity.getSolicitudDetList();
        solicitudDetList.size();
        return solicitudDetList;
    }

    public boolean isOrdenTrabajoListEmpty(Solicitud entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Solicitud> solicitud = cq.from(Solicitud.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitud, entity), cb.isNotEmpty(solicitud.get(Solicitud_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Solicitud entity) {
        Solicitud mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isIdClienteEmpty(Solicitud entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Solicitud> solicitud = cq.from(Solicitud.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitud, entity), cb.isNotNull(solicitud.get(Solicitud_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(Solicitud entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdSucursalEmpty(Solicitud entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Solicitud> solicitud = cq.from(Solicitud.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitud, entity), cb.isNotNull(solicitud.get(Solicitud_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Solicitud entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdUsuarioEmpty(Solicitud entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Solicitud> solicitud = cq.from(Solicitud.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(solicitud, entity), cb.isNotNull(solicitud.get(Solicitud_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Solicitud entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }
    
}
