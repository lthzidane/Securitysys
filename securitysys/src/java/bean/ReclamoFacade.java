/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Reclamo;
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
public class ReclamoFacade extends AbstractFacade<Reclamo> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamoFacade() {
        super(Reclamo.class);
    }

    public Reclamo findByIdReclamo(Integer idReclamo) {
        try {
            return (Reclamo) em.createNamedQuery("Reclamo.findByIdReclamo").setParameter("idReclamo", idReclamo).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Reclamo> findBetweenfechaAlta(Date startDate, Date endDate) {
        try {
            return (List<Reclamo>) em.createNamedQuery("Reclamo.findBetweenfechaAlta")
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Reclamo> findAll() {
        try {
            return (List<Reclamo>) em.createNamedQuery("Reclamo.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
