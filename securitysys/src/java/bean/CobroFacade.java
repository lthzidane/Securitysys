/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cobro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CobroDet;
import entities.AperturaCierreCaja;
import entities.FormaCobro;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class CobroFacade extends AbstractFacade<Cobro> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobroFacade() {
        super(Cobro.class);
    }

    public boolean isCobroDetListEmpty(Cobro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cobro> cobro = cq.from(Cobro.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobro, entity), cb.isNotEmpty(cobro.get(Cobro_.cobroDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CobroDet> findCobroDetList(Cobro entity) {
        Cobro mergedEntity = this.getMergedEntity(entity);
        List<CobroDet> cobroDetList = mergedEntity.getCobroDetList();
        cobroDetList.size();
        return cobroDetList;
    }

    public boolean isIdAperturaCierreEmpty(Cobro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cobro> cobro = cq.from(Cobro.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobro, entity), cb.isNotNull(cobro.get(Cobro_.idAperturaCierre)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public AperturaCierreCaja findIdAperturaCierre(Cobro entity) {
        return this.getMergedEntity(entity).getIdAperturaCierre();
    }

    public boolean isIdFormaCobroEmpty(Cobro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cobro> cobro = cq.from(Cobro.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cobro, entity), cb.isNotNull(cobro.get(Cobro_.idFormaCobro)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public FormaCobro findIdFormaCobro(Cobro entity) {
        return this.getMergedEntity(entity).getIdFormaCobro();
    }
    
}
