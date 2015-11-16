/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.ProductosKit;
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
public class ProductosKitFacade extends AbstractFacade<ProductosKit> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosKitFacade() {
        super(ProductosKit.class);
    }
    
    @Override
     public List<ProductosKit> findAll() {
        try {
            return (List<ProductosKit>) em.createNamedQuery("ProductosKit.findAll").getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
