/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.MarcaTarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Tarjeta;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class MarcaTarjetaFacade extends AbstractFacade<MarcaTarjeta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaTarjetaFacade() {
        super(MarcaTarjeta.class);
    }

    public boolean isTarjetaListEmpty(MarcaTarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MarcaTarjeta> marcaTarjeta = cq.from(MarcaTarjeta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marcaTarjeta, entity), cb.isNotEmpty(marcaTarjeta.get(MarcaTarjeta_.tarjetaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tarjeta> findTarjetaList(MarcaTarjeta entity) {
        MarcaTarjeta mergedEntity = this.getMergedEntity(entity);
        List<Tarjeta> tarjetaList = mergedEntity.getTarjetaList();
        tarjetaList.size();
        return tarjetaList;
    }
    
}
