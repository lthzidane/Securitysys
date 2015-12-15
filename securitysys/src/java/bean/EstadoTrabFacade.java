/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.EstadoTrab;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author expsee
 */
@Stateless
public class EstadoTrabFacade extends AbstractFacade<EstadoTrab> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoTrabFacade() {
        super(EstadoTrab.class);
    }
    
    public EstadoTrab findByIdEstadoTrab(Integer idEstadoTrab) {
        try {
            return (EstadoTrab) em.createNamedQuery("EstadoTrab.findByIdEstadoTrab").setParameter("idEstadoTrab", idEstadoTrab).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public EstadoTrab findByEstado(String estado) {
        try {
            return (EstadoTrab) em.createNamedQuery("EstadoTrab.findByEstado").setParameter("estado", estado).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
     public List<EstadoTrab> findAll() {
        try {
            return (List<EstadoTrab>) em.createNamedQuery("EstadoTrab.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
}
