/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Empresa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Ciudad;

/**
 *
 * @author expsee
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public boolean isIdCiudadEmpty(Empresa entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empresa> empresa = cq.from(Empresa.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empresa, entity), cb.isNotNull(empresa.get(Empresa_.idCiudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findIdCiudad(Empresa entity) {
        return this.getMergedEntity(entity).getIdCiudad();
    }
    
}
