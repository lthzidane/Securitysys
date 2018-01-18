/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.AperturaCierreCaja;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cobro;
import entities.Caja;
import entities.Sucursal;
import entities.Usuario;
import entities.Venta;
import entities.Arqueo;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class AperturaCierreCajaFacade extends AbstractFacade<AperturaCierreCaja> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AperturaCierreCajaFacade() {
        super(AperturaCierreCaja.class);
    }

    public boolean isCobroListEmpty(AperturaCierreCaja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AperturaCierreCaja> aperturaCierreCaja = cq.from(AperturaCierreCaja.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aperturaCierreCaja, entity), cb.isNotEmpty(aperturaCierreCaja.get(AperturaCierreCajacobroList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cobro> findCobroList(AperturaCierreCaja entity) {
        AperturaCierreCaja mergedEntity = this.getMergedEntity(entity);
        List<Cobro> cobroList = mergedEntity.getCobroList();
        cobroList.size();
        return cobroList;
    }

    public boolean isIdCajaEmpty(AperturaCierreCaja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AperturaCierreCaja> aperturaCierreCaja = cq.from(AperturaCierreCaja.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aperturaCierreCaja, entity), cb.isNotNull(aperturaCierreCaja.get(AperturaCierreCaja.idCaja)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Caja findIdCaja(AperturaCierreCaja entity) {
        return this.getMergedEntity(entity).getIdCaja();
    }

    public boolean isIdSucursalEmpty(AperturaCierreCaja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AperturaCierreCaja> aperturaCierreCaja = cq.from(AperturaCierreCaja.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aperturaCierreCaja, entity), cb.isNotNull(aperturaCierreCaja.get(AperturaCierreCaja.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(AperturaCierreCaja entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }

    public boolean isIdUsuarioEmpty(AperturaCierreCaja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AperturaCierreCaja> aperturaCierreCaja = cq.from(AperturaCierreCaja.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aperturaCierreCaja, entity), cb.isNotNull(aperturaCierreCaja.get(AperturaCierreCaja_.idUsuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findIdUsuario(AperturaCierreCaja entity) {
        return this.getMergedEntity(entity).getIdUsuario();
    }

    public boolean isVentaListEmpty(AperturaCierreCaja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AperturaCierreCaja> aperturaCierreCaja = cq.from(AperturaCierreCaja.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aperturaCierreCaja, entity), cb.isNotEmpty(aperturaCierreCaja.get(AperturaCierreCaja_.ventaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Venta> findVentaList(AperturaCierreCaja entity) {
        AperturaCierreCaja mergedEntity = this.getMergedEntity(entity);
        List<Venta> ventaList = mergedEntity.getVentaList();
        ventaList.size();
        return ventaList;
    }

    public boolean isArqueoListEmpty(AperturaCierreCaja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AperturaCierreCaja> aperturaCierreCaja = cq.from(AperturaCierreCaja.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aperturaCierreCaja, entity), cb.isNotEmpty(aperturaCierreCaja.get(AperturaCierreCaja_.arqueoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Arqueo> findArqueoList(AperturaCierreCaja entity) {
        AperturaCierreCaja mergedEntity = this.getMergedEntity(entity);
        List<Arqueo> arqueoList = mergedEntity.getArqueoList();
        arqueoList.size();
        return arqueoList;
    }
    
}
