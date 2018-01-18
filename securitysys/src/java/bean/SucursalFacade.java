/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Sucursal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Promocion;
import entities.CuentaCliente;
import entities.AperturaCierreCaja;
import entities.Contrato;
import entities.Presupuesto;
import entities.OrdenTrabajo;
import entities.Reclamo;
import entities.Venta;
import entities.NotaCrediDebiVenta;
import entities.SerieComprobante;
import entities.NotaRemisionVenta;
import entities.Diagnostico;
import entities.Solicitud;
import entities.Ciudad;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class SucursalFacade extends AbstractFacade<Sucursal> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalFacade() {
        super(Sucursal.class);
    }

    public boolean isPromocionListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.promocionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Promocion> findPromocionList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Promocion> promocionList = mergedEntity.getPromocionList();
        promocionList.size();
        return promocionList;
    }

    public boolean isCuentaClienteListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.cuentaClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CuentaCliente> findCuentaClienteList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<CuentaCliente> cuentaClienteList = mergedEntity.getCuentaClienteList();
        cuentaClienteList.size();
        return cuentaClienteList;
    }

    public boolean isAperturaCierreCajaListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.aperturaCierreCajaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<AperturaCierreCaja> findAperturaCierreCajaList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<AperturaCierreCaja> aperturaCierreCajaList = mergedEntity.getAperturaCierreCajaList();
        aperturaCierreCajaList.size();
        return aperturaCierreCajaList;
    }

    public boolean isContratoListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.contratoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Contrato> findContratoList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Contrato> contratoList = mergedEntity.getContratoList();
        contratoList.size();
        return contratoList;
    }

    public boolean isPresupuestoListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.presupuestoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Presupuesto> findPresupuestoList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Presupuesto> presupuestoList = mergedEntity.getPresupuestoList();
        presupuestoList.size();
        return presupuestoList;
    }

    public boolean isOrdenTrabajoListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isReclamoListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.reclamoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Reclamo> findReclamoList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Reclamo> reclamoList = mergedEntity.getReclamoList();
        reclamoList.size();
        return reclamoList;
    }

    public boolean isVentaListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }

    public boolean isNotaCrediDebiVentaListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.notaCrediDebiVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVenta> findNotaCrediDebiVentaList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVenta> notaCrediDebiVentaList = mergedEntity.getNotaCrediDebiVentaList();
        notaCrediDebiVentaList.size();
        return notaCrediDebiVentaList;
    }

    public boolean isSerieComprobanteListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.serieComprobanteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<SerieComprobante> findSerieComprobanteList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<SerieComprobante> serieComprobanteList = mergedEntity.getSerieComprobanteList();
        serieComprobanteList.size();
        return serieComprobanteList;
    }

    public boolean isNotaRemisionVentaListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.notaRemisionVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVenta> findNotaRemisionVentaList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVenta> notaRemisionVentaList = mergedEntity.getNotaRemisionVentaList();
        notaRemisionVentaList.size();
        return notaRemisionVentaList;
    }

    public boolean isDiagnosticoListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.diagnosticoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Diagnostico> findDiagnosticoList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Diagnostico> diagnosticoList = mergedEntity.getDiagnosticoList();
        diagnosticoList.size();
        return diagnosticoList;
    }

    public boolean isSolicitudListEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotEmpty(sucursal.get(Sucursal_.solicitudList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Solicitud> findSolicitudList(Sucursal entity) {
        Sucursal mergedEntity = this.getMergedEntity(entity);
        List<Solicitud> solicitudList = mergedEntity.getSolicitudList();
        solicitudList.size();
        return solicitudList;
    }

    public boolean isIdCiudadEmpty(Sucursal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Sucursal> sucursal = cq.from(Sucursal.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(sucursal, entity), cb.isNotNull(sucursal.get(Sucursal_.idCiudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findIdCiudad(Sucursal entity) {
        return this.getMergedEntity(entity).getIdCiudad();
    }
    
}
