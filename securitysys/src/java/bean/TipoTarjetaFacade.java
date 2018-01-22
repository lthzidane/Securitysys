/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoTarjeta;
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
public class TipoTarjetaFacade extends AbstractFacade<TipoTarjeta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTarjetaFacade() {
        super(TipoTarjeta.class);
    }

    public boolean isTarjetaListEmpty(TipoTarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoTarjeta> tipoTarjeta = cq.from(TipoTarjeta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoTarjeta, entity), cb.isNotEmpty(tipoTarjeta.get(TipoTarjeta_.tarjetaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tarjeta> findTarjetaList(TipoTarjeta entity) {
        TipoTarjeta mergedEntity = this.getMergedEntity(entity);
        List<Tarjeta> tarjetaList = mergedEntity.getTarjetaList();
        tarjetaList.size();
        return tarjetaList;
    }
    
}
