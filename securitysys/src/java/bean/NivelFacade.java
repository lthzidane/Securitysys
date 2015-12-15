/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Cliente;
import entities.Nivel;
import entities.Subtipo;
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
public class NivelFacade extends AbstractFacade<Nivel> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelFacade() {
        super(Nivel.class);
    }

    @Override
     public List<Nivel> findAll() {
        try {
            return (List<Nivel>) em.createNamedQuery("Nivel.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }    
    
    public Nivel findByIdNivel(Integer idNivel) {
        try {
            return (Nivel) em.createNamedQuery("Nivel.findByIdNivel").setParameter("idNivel", idNivel).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
