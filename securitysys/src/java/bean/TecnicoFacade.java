/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Tecnico;
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
public class TecnicoFacade extends AbstractFacade<Tecnico> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnicoFacade() {
        super(Tecnico.class);
    }

    public boolean isCuadrillaListEmpty(Tecnico entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tecnico> tecnico = cq.from(Tecnico.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tecnico, entity), cb.isNotEmpty(tecnico.get(Tecnico_.cuadrillaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cuadrilla> findCuadrillaList(Tecnico entity) {
        Tecnico mergedEntity = this.getMergedEntity(entity);
        List<Cuadrilla> cuadrillaList = mergedEntity.getCuadrillaList();
        cuadrillaList.size();
        return cuadrillaList;
    }
    
}
