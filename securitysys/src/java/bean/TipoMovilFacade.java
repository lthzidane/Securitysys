/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoMovil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Moviles;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class TipoMovilFacade extends AbstractFacade<TipoMovil> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMovilFacade() {
        super(TipoMovil.class);
    }

    public boolean isMovilesListEmpty(TipoMovil entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoMovil> tipoMovil = cq.from(TipoMovil.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoMovil, entity), cb.isNotEmpty(tipoMovil.get(TipoMovil_.movilesList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Moviles> findMovilesList(TipoMovil entity) {
        TipoMovil mergedEntity = this.getMergedEntity(entity);
        List<Moviles> movilesList = mergedEntity.getMovilesList();
        movilesList.size();
        return movilesList;
    }
    
}
