/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Recaudacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Arqueo;
import entities.FormaCobro;

/**
 *
 * @author expsee
 */
@Stateless
public class RecaudacionFacade extends AbstractFacade<Recaudacion> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecaudacionFacade() {
        super(Recaudacion.class);
    }

    public boolean isArqueoEmpty(Recaudacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Recaudacion> recaudacion = cq.from(Recaudacion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(recaudacion, entity), cb.isNotNull(recaudacion.get(Recaudacion_.arqueo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Arqueo findArqueo(Recaudacion entity) {
        return this.getMergedEntity(entity).getArqueo();
    }

    public boolean isFormaCobroEmpty(Recaudacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Recaudacion> recaudacion = cq.from(Recaudacion.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(recaudacion, entity), cb.isNotNull(recaudacion.get(Recaudacion_.formaCobro)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public FormaCobro findFormaCobro(Recaudacion entity) {
        return this.getMergedEntity(entity).getFormaCobro();
    }
    
}
