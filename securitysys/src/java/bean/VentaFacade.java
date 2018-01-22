/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Venta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CtaACobrar;
import entities.AperturaCierreCaja;
import entities.Cliente;
import entities.Presupuesto;
import entities.SerieComprobante;
import entities.Sucursal;
import entities.Timbrado;
import entities.TipoComprobante;
import entities.Usuario;
import entities.NotaCrediDebiVenta;
import entities.VentaDet;
import entities.NotaRemisionVenta;
import entities.LibroVenta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }

    public boolean isCtaACobrarListEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotEmpty(venta.get(Venta_.ctaACobrarList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CtaACobrar> findCtaACobrarList(Venta entity) {
        Venta mergedEntity = this.getMergedEntity(entity);
        List<CtaACobrar> ctaACobrarList = mergedEntity.getCtaACobrarList();
        ctaACobrarList.size();
        return ctaACobrarList;
    }

    public boolean isIdAperturaCierreEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idAperturaCierre)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public AperturaCierreCaja findIdAperturaCierre(Venta entity) {
        return this.getMergedEntity(entity).getIdAperturaCierre();
    }

    public boolean isIdClienteEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(Venta entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdPresupuestoEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idPresupuesto)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Presupuesto findIdPresupuesto(Venta entity) {
        return this.getMergedEntity(entity).getIdPresupuesto();
    }

    public boolean isIdSerieComprobanteEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idSerieComprobante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SerieComprobante findIdSerieComprobante(Venta entity) {
        return this.getMergedEntity(entity).getIdSerieComprobante();
    }

    public boolean isIdSucursalEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Venta entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdTimbradoEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idTimbrado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Timbrado findIdTimbrado(Venta entity) {
        return this.getMergedEntity(entity).getIdTimbrado();
    }

    public boolean isIdTipoComprobanteEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idTipoComprobante)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoComprobante findIdTipoComprobante(Venta entity) {
        return this.getMergedEntity(entity).getIdTipoComprobante();
    }

    public boolean isIdUsuarioEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotNull(venta.get(Venta_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(Venta entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isNotaCrediDebiVentaListEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotEmpty(venta.get(Venta_.notaCrediDebiVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaCrediDebiVenta> findNotaCrediDebiVentaList(Venta entity) {
        Venta mergedEntity = this.getMergedEntity(entity);
        List<NotaCrediDebiVenta> notaCrediDebiVentaList = mergedEntity.getNotaCrediDebiVentaList();
        notaCrediDebiVentaList.size();
        return notaCrediDebiVentaList;
    }

    public boolean isVentaDetListEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotEmpty(venta.get(Venta_.ventaDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<VentaDet> findVentaDetList(Venta entity) {
        Venta mergedEntity = this.getMergedEntity(entity);
        List<VentaDet> ventaDetList = mergedEntity.getVentaDetList();
        ventaDetList.size();
        return ventaDetList;
    }

    public boolean isNotaRemisionVentaListEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotEmpty(venta.get(Venta_.notaRemisionVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVenta> findNotaRemisionVentaList(Venta entity) {
        Venta mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVenta> notaRemisionVentaList = mergedEntity.getNotaRemisionVentaList();
        notaRemisionVentaList.size();
        return notaRemisionVentaList;
    }

    public boolean isLibroVentaListEmpty(Venta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Venta> venta = cq.from(Venta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(venta, entity), cb.isNotEmpty(venta.get(Venta_.libroVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<LibroVenta> findLibroVentaList(Venta entity) {
        Venta mergedEntity = this.getMergedEntity(entity);
        List<LibroVenta> libroVentaList = mergedEntity.getLibroVentaList();
        libroVentaList.size();
        return libroVentaList;
    }
    
}
