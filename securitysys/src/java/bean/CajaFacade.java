/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Caja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.AperturaCierreCaja;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class CajaFacade extends AbstractFacade<Caja> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajaFacade() {
        super(Caja.class);
    }

    public boolean isAperturaCierreCajaListEmpty(Caja entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Caja> caja = cq.from(Caja.class);
//        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(caja, entity), cb.isNotEmpty(caja.get(Caja_.aperturaCierreCajaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<AperturaCierreCaja> findAperturaCierreCajaList(Caja entity) {
        Caja mergedEntity = this.getMergedEntity(entity);
        List<AperturaCierreCaja> aperturaCierreCajaList = mergedEntity.getAperturaCierreCajaList();
        aperturaCierreCajaList.size();
        return aperturaCierreCajaList;
    }
    
}
