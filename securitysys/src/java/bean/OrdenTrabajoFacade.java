/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.OrdenTrabajo;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebas
 */
@Stateless
public class OrdenTrabajoFacade extends AbstractFacade<OrdenTrabajo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenTrabajoFacade() {
        super(OrdenTrabajo.class);
    }

    public OrdenTrabajo findByNroOrden(Integer nroOrden) {
        try {
            return (OrdenTrabajo) em.createNamedQuery("OrdenTrabajo.findByIdOt").setParameter("idOt", nroOrden).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<OrdenTrabajo> findBetweenFechaOrden(Date startDate, Date endDate) {
        try {
            return (List<OrdenTrabajo>) em.createNamedQuery("OrdenTrabajo.findBetweenFechaOrden")
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
