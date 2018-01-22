/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cuadrilla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.OrdenTrabajo;
import entities.Moviles;
import entities.Tecnico;
import entities.TipoCuadrilla;
import entities.Zona;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class CuadrillaFacade extends AbstractFacade<Cuadrilla> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuadrillaFacade() {
        super(Cuadrilla.class);
    }

    public boolean isOrdenTrabajoListEmpty(Cuadrilla entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuadrilla> cuadrilla = cq.from(Cuadrilla.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuadrilla, entity), cb.isNotEmpty(cuadrilla.get(Cuadrilla_.ordenTrabajoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<OrdenTrabajo> findOrdenTrabajoList(Cuadrilla entity) {
        Cuadrilla mergedEntity = this.getMergedEntity(entity);
        List<OrdenTrabajo> ordenTrabajoList = mergedEntity.getOrdenTrabajoList();
        ordenTrabajoList.size();
        return ordenTrabajoList;
    }

    public boolean isIdMovilEmpty(Cuadrilla entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuadrilla> cuadrilla = cq.from(Cuadrilla.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuadrilla, entity), cb.isNotNull(cuadrilla.get(Cuadrilla_.idMovil)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Moviles findIdMovil(Cuadrilla entity) {
        return this.getMergedEntity(entity).getIdMovil();
    }

    public boolean isIdTecnicoEmpty(Cuadrilla entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuadrilla> cuadrilla = cq.from(Cuadrilla.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuadrilla, entity), cb.isNotNull(cuadrilla.get(Cuadrilla_.idTecnico)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tecnico findIdTecnico(Cuadrilla entity) {
        return this.getMergedEntity(entity).getIdTecnico();
    }

    public boolean isIdTipoCuadrillaEmpty(Cuadrilla entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuadrilla> cuadrilla = cq.from(Cuadrilla.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuadrilla, entity), cb.isNotNull(cuadrilla.get(Cuadrilla_.idTipoCuadrilla)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoCuadrilla findIdTipoCuadrilla(Cuadrilla entity) {
        return this.getMergedEntity(entity).getIdTipoCuadrilla();
    }

    public boolean isIdZonaEmpty(Cuadrilla entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cuadrilla> cuadrilla = cq.from(Cuadrilla.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cuadrilla, entity), cb.isNotNull(cuadrilla.get(Cuadrilla_.idZona)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Zona findIdZona(Cuadrilla entity) {
        return this.getMergedEntity(entity).getIdZona();
    }
    
}
