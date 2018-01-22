/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.EntidadEmisora;
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
public class EntidadEmisoraFacade extends AbstractFacade<EntidadEmisora> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadEmisoraFacade() {
        super(EntidadEmisora.class);
    }

    public boolean isTarjetaListEmpty(EntidadEmisora entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<EntidadEmisora> entidadEmisora = cq.from(EntidadEmisora.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(entidadEmisora, entity), cb.isNotEmpty(entidadEmisora.get(EntidadEmisora_.tarjetaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tarjeta> findTarjetaList(EntidadEmisora entity) {
        EntidadEmisora mergedEntity = this.getMergedEntity(entity);
        List<Tarjeta> tarjetaList = mergedEntity.getTarjetaList();
        tarjetaList.size();
        return tarjetaList;
    }
    
}
