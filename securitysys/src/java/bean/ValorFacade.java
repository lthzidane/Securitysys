/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Valor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Arqueo;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class ValorFacade extends AbstractFacade<Valor> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValorFacade() {
        super(Valor.class);
    }

    public boolean isArqueoListEmpty(Valor entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Valor> valor = cq.from(Valor.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(valor, entity), cb.isNotEmpty(valor.get(Valor_.arqueoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Arqueo> findArqueoList(Valor entity) {
        Valor mergedEntity = this.getMergedEntity(entity);
        List<Arqueo> arqueoList = mergedEntity.getArqueoList();
        arqueoList.size();
        return arqueoList;
    }
    
}
