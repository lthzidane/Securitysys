/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Marca;
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
public class MarcaFacade extends AbstractFacade<Marca> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaFacade() {
        super(Marca.class);
    }

    public boolean isMovilesListEmpty(Marca entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Marca> marca = cq.from(Marca.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marca, entity), cb.isNotEmpty(marca.get(Marca_.movilesList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Moviles> findMovilesList(Marca entity) {
        Marca mergedEntity = this.getMergedEntity(entity);
        List<Moviles> movilesList = mergedEntity.getMovilesList();
        movilesList.size();
        return movilesList;
    }
    
}
