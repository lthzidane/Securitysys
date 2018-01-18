/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Banco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.CobroCheque;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class BancoFacade extends AbstractFacade<Banco> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BancoFacade() {
        super(Banco.class);
    }

    public boolean isCobroChequeListEmpty(Banco entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Banco> banco = cq.from(Banco.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(banco, entity), cb.isNotEmpty(banco.get(Banco_.cobroChequeList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CobroCheque> findCobroChequeList(Banco entity) {
        Banco mergedEntity = this.getMergedEntity(entity);
        List<CobroCheque> cobroChequeList = mergedEntity.getCobroChequeList();
        cobroChequeList.size();
        return cobroChequeList;
    }
    
}
