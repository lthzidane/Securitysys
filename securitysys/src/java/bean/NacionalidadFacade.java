/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Nacionalidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cliente;
import java.util.List;

/**
 *
 * @author expsee
 */
@Stateless
public class NacionalidadFacade extends AbstractFacade<Nacionalidad> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NacionalidadFacade() {
        super(Nacionalidad.class);
    }

    public boolean isClienteListEmpty(Nacionalidad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Nacionalidad> nacionalidad = cq.from(Nacionalidad.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(nacionalidad, entity), cb.isNotEmpty(nacionalidad.get(Nacionalidad_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(Nacionalidad entity) {
        Nacionalidad mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }
    
}
