/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoServicios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class TipoServiciosFacade extends AbstractFacade<TipoServicios> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoServiciosFacade() {
        super(TipoServicios.class);
    }
 
    public TipoServicios findByIdServicio(Integer idServicio) {
        try {
            return (TipoServicios) em.createNamedQuery("TipoServicios.findByIdServicio").setParameter("idServicio", idServicio).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }    
    
}
