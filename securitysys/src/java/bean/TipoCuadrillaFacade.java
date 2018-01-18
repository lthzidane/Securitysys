/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoCuadrilla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cuadrilla;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class TipoCuadrillaFacade extends AbstractFacade<TipoCuadrilla> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCuadrillaFacade() {
        super(TipoCuadrilla.class);
    }

    public boolean isCuadrillaListEmpty(TipoCuadrilla entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoCuadrilla> tipoCuadrilla = cq.from(TipoCuadrilla.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoCuadrilla, entity), cb.isNotEmpty(tipoCuadrilla.get(TipoCuadrilla_.cuadrillaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cuadrilla> findCuadrillaList(TipoCuadrilla entity) {
        TipoCuadrilla mergedEntity = this.getMergedEntity(entity);
        List<Cuadrilla> cuadrillaList = mergedEntity.getCuadrillaList();
        cuadrillaList.size();
        return cuadrillaList;
    }
    
}
