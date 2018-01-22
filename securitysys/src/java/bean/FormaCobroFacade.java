/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.FormaCobro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cobro;
import entities.Recaudacion;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class FormaCobroFacade extends AbstractFacade<FormaCobro> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaCobroFacade() {
        super(FormaCobro.class);
    }

    public boolean isCobroListEmpty(FormaCobro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FormaCobro> formaCobro = cq.from(FormaCobro.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(formaCobro, entity), cb.isNotEmpty(formaCobro.get(FormaCobro_.cobroList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cobro> findCobroList(FormaCobro entity) {
        FormaCobro mergedEntity = this.getMergedEntity(entity);
        List<Cobro> cobroList = mergedEntity.getCobroList();
        cobroList.size();
        return cobroList;
    }

    public boolean isRecaudacionListEmpty(FormaCobro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FormaCobro> formaCobro = cq.from(FormaCobro.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(formaCobro, entity), cb.isNotEmpty(formaCobro.get(FormaCobro_.recaudacionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Recaudacion> findRecaudacionList(FormaCobro entity) {
        FormaCobro mergedEntity = this.getMergedEntity(entity);
        List<Recaudacion> recaudacionList = mergedEntity.getRecaudacionList();
        recaudacionList.size();
        return recaudacionList;
    }
    
}
