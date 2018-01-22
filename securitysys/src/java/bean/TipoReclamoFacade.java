/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoReclamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Reclamo;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class TipoReclamoFacade extends AbstractFacade<TipoReclamo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReclamoFacade() {
        super(TipoReclamo.class);
    }

    public boolean isReclamoListEmpty(TipoReclamo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoReclamo> tipoReclamo = cq.from(TipoReclamo.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoReclamo, entity), cb.isNotEmpty(tipoReclamo.get(TipoReclamo_.reclamoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Reclamo> findReclamoList(TipoReclamo entity) {
        TipoReclamo mergedEntity = this.getMergedEntity(entity);
        List<Reclamo> reclamoList = mergedEntity.getReclamoList();
        reclamoList.size();
        return reclamoList;
    }
    
}
