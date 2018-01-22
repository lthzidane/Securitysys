/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CuentaCliente;
import entities.Contrato;
import entities.Ciudad;
import entities.Nacionalidad;
import entities.TipoDocumento;
import entities.Presupuesto;
import entities.OrdenTrabajo;
import entities.Reclamo;
import entities.Venta;
import entities.SegmentoContrato;
import entities.Solicitud;
import entities.LibroVenta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public boolean isCuentaClienteListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.cuentaClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CuentaCliente> findCuentaClienteList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<CuentaCliente> cuentaClienteList = mergedEntity.getCuentaClienteList();
        cuentaClienteList.size();
        return cuentaClienteList;
    }

    public boolean isContratoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.contratoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Contrato> findContratoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Contrato> contratoList = mergedEntity.getContratoList();
        contratoList.size();
        return contratoList;
    }

    public boolean isIdCiudadEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.idCiudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findIdCiudad(Cliente entity) {
        return this.getMergedEntity(entity).getIdCiudad();
    }

    public boolean isIdNacionalidadEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.idNacionalidad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Nacionalidad findIdNacionalidad(Cliente entity) {
        return this.getMergedEntity(entity).getIdNacionalidad();
    }

    public boolean isIdTipoDocumentoEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.idTipoDocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoDocumento findIdTipoDocumento(Cliente entity) {
        return this.getMergedEntity(entity).getIdTipoDocumento();
    }

    public boolean isPresupuestoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.presupuestoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Presupuesto> findPresupuestoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Presupuesto> presupuestoList = mergedEntity.getPresupuestoList();
        presupuestoList.size();
        return presupuestoList;
    }

    public boolean isOrdenTrabajoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isReclamoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.reclamoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Reclamo> findReclamoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Reclamo> reclamoList = mergedEntity.getReclamoList();
        reclamoList.size();
        return reclamoList;
    }

    public boolean isVentaListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }

    public boolean isSegmentoContratoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.segmentoContratoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SegmentoContrato> findSegmentoContratoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<SegmentoContrato> segmentoContratoList = mergedEntity.getSegmentoContratoList();
        segmentoContratoList.size();
        return segmentoContratoList;
    }

    public boolean isSolicitudListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.solicitudList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Solicitud> findSolicitudList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Solicitud> solicitudList = mergedEntity.getSolicitudList();
        solicitudList.size();
        return solicitudList;
    }

    public boolean isLibroVentaListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.libroVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<LibroVenta> findLibroVentaList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<LibroVenta> libroVentaList = mergedEntity.getLibroVentaList();
        libroVentaList.size();
        return libroVentaList;
    }
    
}
