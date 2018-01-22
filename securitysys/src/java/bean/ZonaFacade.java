/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Zona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Ciudad;
import entities.Ruta;
import entities.Cuadrilla;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class ZonaFacade extends AbstractFacade<Zona> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZonaFacade() {
        super(Zona.class);
    }

    public boolean isIdCiudadEmpty(Zona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Zona> zona = cq.from(Zona.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(zona, entity), cb.isNotNull(zona.get(Zona_.idCiudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findIdCiudad(Zona entity) {
        return this.getMergedEntity(entity).getIdCiudad();
    }

    public boolean isRutaListEmpty(Zona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Zona> zona = cq.from(Zona.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(zona, entity), cb.isNotEmpty(zona.get(Zona_.rutaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Ruta> findRutaList(Zona entity) {
        Zona mergedEntity = this.getMergedEntity(entity);
        List<Ruta> rutaList = mergedEntity.getRutaList();
        rutaList.size();
        return rutaList;
    }

    public boolean isCuadrillaListEmpty(Zona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Zona> zona = cq.from(Zona.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(zona, entity), cb.isNotEmpty(zona.get(Zona_.cuadrillaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cuadrilla> findCuadrillaList(Zona entity) {
        Zona mergedEntity = this.getMergedEntity(entity);
        List<Cuadrilla> cuadrillaList = mergedEntity.getCuadrillaList();
        cuadrillaList.size();
        return cuadrillaList;
    }
    
}
