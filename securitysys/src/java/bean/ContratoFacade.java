/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Contrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CuentaCliente;
import entities.Cliente;
import entities.Estado;
import entities.Servicio;
import entities.Sucursal;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class ContratoFacade extends AbstractFacade<Contrato> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratoFacade() {
        super(Contrato.class);
    }

    public boolean isCuentaClienteListEmpty(Contrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Contrato> contrato = cq.from(Contrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(contrato, entity), cb.isNotEmpty(contrato.get(Contrato_.cuentaClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CuentaCliente> findCuentaClienteList(Contrato entity) {
        Contrato mergedEntity = this.getMergedEntity(entity);
        List<CuentaCliente> cuentaClienteList = mergedEntity.getCuentaClienteList();
        cuentaClienteList.size();
        return cuentaClienteList;
    }

    public boolean isClienteEmpty(Contrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Contrato> contrato = cq.from(Contrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(contrato, entity), cb.isNotNull(contrato.get(Contrato_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(Contrato entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isIdEstadoEmpty(Contrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Contrato> contrato = cq.from(Contrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(contrato, entity), cb.isNotNull(contrato.get(Contrato_.idEstado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Estado findIdEstado(Contrato entity) {
        return this.getMergedEntity(entity).getIdEstado();
    }

    public boolean isIdServicioEmpty(Contrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Contrato> contrato = cq.from(Contrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(contrato, entity), cb.isNotNull(contrato.get(Contrato_.idServicio)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Servicio findIdServicio(Contrato entity) {
        return this.getMergedEntity(entity).getIdServicio();
    }

    public boolean isIdSucursalEmpty(Contrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Contrato> contrato = cq.from(Contrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(contrato, entity), cb.isNotNull(contrato.get(Contrato_.idSucursal)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Sucursal findIdSucursal(Contrato entity) {
        return this.getMergedEntity(entity).getIdSucursal();
    }
    
}
