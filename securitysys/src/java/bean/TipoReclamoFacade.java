/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.TipoReclamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebas
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

    public TipoReclamo findByIdTipoReclamo(Integer idTipoReclamo) {
        try {
            return (TipoReclamo) em.createNamedQuery("TipoReclamo.findByIdTipoReclamo").setParameter("idTipoReclamo", idTipoReclamo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
