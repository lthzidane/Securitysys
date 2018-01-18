/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Moviles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Marca;
import entities.TipoMovil;
import entities.Cuadrilla;
import entities.Itinerario;
import entities.NotaRemisionVenta;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class MovilesFacade extends AbstractFacade<Moviles> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovilesFacade() {
        super(Moviles.class);
    }

    public boolean isIdMarcaEmpty(Moviles entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Moviles> moviles = cq.from(Moviles.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(moviles, entity), cb.isNotNull(moviles.get(Moviles_.idMarca)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marca findIdMarca(Moviles entity) {
        return this.getMergedEntity(entity).getIdMarca();
    }

    public boolean isIdTipoMovilEmpty(Moviles entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Moviles> moviles = cq.from(Moviles.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(moviles, entity), cb.isNotNull(moviles.get(Moviles_.idTipoMovil)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoMovil findIdTipoMovil(Moviles entity) {
        return this.getMergedEntity(entity).getIdTipoMovil();
    }

    public boolean isCuadrillaListEmpty(Moviles entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Moviles> moviles = cq.from(Moviles.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(moviles, entity), cb.isNotEmpty(moviles.get(Moviles_.cuadrillaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cuadrilla> findCuadrillaList(Moviles entity) {
        Moviles mergedEntity = this.getMergedEntity(entity);
        List<Cuadrilla> cuadrillaList = mergedEntity.getCuadrillaList();
        cuadrillaList.size();
        return cuadrillaList;
    }

    public boolean isItinerarioListEmpty(Moviles entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Moviles> moviles = cq.from(Moviles.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(moviles, entity), cb.isNotEmpty(moviles.get(Moviles_.itinerarioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Itinerario> findItinerarioList(Moviles entity) {
        Moviles mergedEntity = this.getMergedEntity(entity);
        List<Itinerario> itinerarioList = mergedEntity.getItinerarioList();
        itinerarioList.size();
        return itinerarioList;
    }

    public boolean isNotaRemisionVentaListEmpty(Moviles entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Moviles> moviles = cq.from(Moviles.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(moviles, entity), cb.isNotEmpty(moviles.get(Moviles_.notaRemisionVentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NotaRemisionVenta> findNotaRemisionVentaList(Moviles entity) {
        Moviles mergedEntity = this.getMergedEntity(entity);
        List<NotaRemisionVenta> notaRemisionVentaList = mergedEntity.getNotaRemisionVentaList();
        notaRemisionVentaList.size();
        return notaRemisionVentaList;
    }
    
}
