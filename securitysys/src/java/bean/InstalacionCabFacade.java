/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.InstalacionCab;
import entities.OrdenTrabajoCab;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LOTHAR
 */
@Stateless
public class InstalacionCabFacade extends AbstractFacade<InstalacionCab> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstalacionCabFacade() {
        super(InstalacionCab.class);
    }
    
    public InstalacionCab findByIdInstalacion(Integer idInstalacion) {
        try {
            return (InstalacionCab) em.createNamedQuery("InstalacionCab.findByIdInstalacion").setParameter("idInstalacion", idInstalacion).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
