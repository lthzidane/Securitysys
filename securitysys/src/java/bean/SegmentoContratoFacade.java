/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.SegmentoContrato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CuentaCliente;
import entities.Cliente;
import entities.Servicio;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class SegmentoContratoFacade extends AbstractFacade<SegmentoContrato> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegmentoContratoFacade() {
        super(SegmentoContrato.class);
    }

    public boolean isCuentaClienteListEmpty(SegmentoContrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SegmentoContrato> segmentoContrato = cq.from(SegmentoContrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(segmentoContrato, entity), cb.isNotEmpty(segmentoContrato.get(SegmentoContrato_.cuentaClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CuentaCliente> findCuentaClienteList(SegmentoContrato entity) {
        SegmentoContrato mergedEntity = this.getMergedEntity(entity);
        List<CuentaCliente> cuentaClienteList = mergedEntity.getCuentaClienteList();
        cuentaClienteList.size();
        return cuentaClienteList;
    }

    public boolean isIdClienteEmpty(SegmentoContrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SegmentoContrato> segmentoContrato = cq.from(SegmentoContrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(segmentoContrato, entity), cb.isNotNull(segmentoContrato.get(SegmentoContrato_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(SegmentoContrato entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdServicioEmpty(SegmentoContrato entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SegmentoContrato> segmentoContrato = cq.from(SegmentoContrato.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(segmentoContrato, entity), cb.isNotNull(segmentoContrato.get(SegmentoContrato_.idServicio)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Servicio findIdServicio(SegmentoContrato entity) {
        return this.getMergedEntity(entity).getIdServicio();
    }
    
}
