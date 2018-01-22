/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Ruta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Zona;
import entities.Itinerario;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class RutaFacade extends AbstractFacade<Ruta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutaFacade() {
        super(Ruta.class);
    }

    public boolean isIdZonaEmpty(Ruta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ruta> ruta = cq.from(Ruta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ruta, entity), cb.isNotNull(ruta.get(Ruta_.idZona)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Zona findIdZona(Ruta entity) {
        return this.getMergedEntity(entity).getIdZona();
    }

    public boolean isItinerarioListEmpty(Ruta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ruta> ruta = cq.from(Ruta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ruta, entity), cb.isNotEmpty(ruta.get(Ruta_.itinerarioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Itinerario> findItinerarioList(Ruta entity) {
        Ruta mergedEntity = this.getMergedEntity(entity);
        List<Itinerario> itinerarioList = mergedEntity.getItinerarioList();
        itinerarioList.size();
        return itinerarioList;
    }
    
}
