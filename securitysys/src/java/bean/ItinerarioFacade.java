/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Itinerario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.OrdenTrabajo;
import entities.Moviles;
import entities.Ruta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class ItinerarioFacade extends AbstractFacade<Itinerario> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItinerarioFacade() {
        super(Itinerario.class);
    }

    public boolean isOrdenTrabajoListEmpty(Itinerario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Itinerario> itinerario = cq.from(Itinerario.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(itinerario, entity), cb.isNotEmpty(itinerario.get(Itinerario_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Itinerario entity) {
        Itinerario mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isIdMovilEmpty(Itinerario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Itinerario> itinerario = cq.from(Itinerario.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(itinerario, entity), cb.isNotNull(itinerario.get(Itinerario_.idMovil)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Moviles findIdMovil(Itinerario entity) {
        return this.getMergedEntity(entity).getIdMovil();
    }

    public boolean isIdRutaEmpty(Itinerario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Itinerario> itinerario = cq.from(Itinerario.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(itinerario, entity), cb.isNotNull(itinerario.get(Itinerario_.idRuta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ruta findIdRuta(Itinerario entity) {
        return this.getMergedEntity(entity).getIdRuta();
    }
    
}
