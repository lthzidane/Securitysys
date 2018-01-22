/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.CuentaCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cliente;
import entities.Contrato;
import entities.Estado;
import entities.SegmentoContrato;
import entities.Sucursal;

/**
 *
 * @author expsee
 */
@Stateless
public class CuentaClienteFacade extends AbstractFacade<CuentaCliente> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaClienteFacade() {
        super(CuentaCliente.class);
    }

    public boolean isIdClienteEmpty(CuentaCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CuentaCliente> cuentaCliente = cq.from(CuentaCliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuentaCliente, entity), cb.isNotNull(cuentaCliente.get(CuentaCliente_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(CuentaCliente entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isContratoEmpty(CuentaCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CuentaCliente> cuentaCliente = cq.from(CuentaCliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuentaCliente, entity), cb.isNotNull(cuentaCliente.get(CuentaCliente_.contrato)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Contrato findContrato(CuentaCliente entity) {
        return this.getMergedEntity(entity).getContrato();
    }

    public boolean isIdEstadoEmpty(CuentaCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CuentaCliente> cuentaCliente = cq.from(CuentaCliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuentaCliente, entity), cb.isNotNull(cuentaCliente.get(CuentaCliente_.idEstado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Estado findIdEstado(CuentaCliente entity) {
        return this.getMergedEntity(entity).getIdEstado();
    }

    public boolean isIdSegmentoEmpty(CuentaCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CuentaCliente> cuentaCliente = cq.from(CuentaCliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuentaCliente, entity), cb.isNotNull(cuentaCliente.get(CuentaCliente_.idSegmento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public SegmentoContrato findIdSegmento(CuentaCliente entity) {
        return this.getMergedEntity(entity).getIdSegmento();
    }

    public boolean isIdSucursalEmpty(CuentaCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CuentaCliente> cuentaCliente = cq.from(CuentaCliente.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuentaCliente, entity), cb.isNotNull(cuentaCliente.get(CuentaCliente_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(CuentaCliente entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }
    
}
