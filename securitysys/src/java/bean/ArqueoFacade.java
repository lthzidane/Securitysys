/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Arqueo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Recaudacion;
import entities.AperturaCierreCaja;
import entities.Valor;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class ArqueoFacade extends AbstractFacade<Arqueo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArqueoFacade() {
        super(Arqueo.class);
    }

    public boolean isRecaudacionListEmpty(Arqueo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Arqueo> arqueo = cq.from(Arqueo.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(arqueo, entity), cb.isNotEmpty(arqueo.get(Arqueo_.recaudacionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Recaudacion> findRecaudacionList(Arqueo entity) {
        Arqueo mergedEntity = this.getMergedEntity(entity);
        List<Recaudacion> recaudacionList = mergedEntity.getRecaudacionList();
        recaudacionList.size();
        return recaudacionList;
    }

    public boolean isAperturaCierreCajaEmpty(Arqueo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Arqueo> arqueo = cq.from(Arqueo.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(arqueo, entity), cb.isNotNull(arqueo.get(Arqueo_.aperturaCierreCaja)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public AperturaCierreCaja findAperturaCierreCaja(Arqueo entity) {
        return this.getMergedEntity(entity).getAperturaCierreCaja();
    }

    public boolean isValorEmpty(Arqueo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Arqueo> arqueo = cq.from(Arqueo.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(arqueo, entity), cb.isNotNull(arqueo.get(Arqueo_.valor)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Valor findValor(Arqueo entity) {
        return this.getMergedEntity(entity).getValor();
    }
    
}
