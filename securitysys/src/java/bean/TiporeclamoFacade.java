/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.EstadoTrab;
import entities.Tiporeclamo;
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
public class TiporeclamoFacade extends AbstractFacade<Tiporeclamo> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiporeclamoFacade() {
        super(Tiporeclamo.class);
    }
    
    @Override
     public List<Tiporeclamo> findAll() {
        try {
            return (List<Tiporeclamo>) em.createNamedQuery("Tiporeclamo.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
