/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoReclamo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LOTHAR
 */
@Stateless
public class TipoReclamoFacade extends AbstractFacade<TipoReclamo> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReclamoFacade() {
        super(TipoReclamo.class);
    }
    
    @Override
     public List<TipoReclamo> findAll() {
        try {
            return (List<TipoReclamo>) em.createNamedQuery("TipoReclamo.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
     
    public TipoReclamo findByIdTiporecla(Integer idTiporecla) {
        try {
            return (TipoReclamo) em.createNamedQuery("TipoReclamo.findByIdTiporecla").setParameter("idTiporecla", idTiporecla).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
