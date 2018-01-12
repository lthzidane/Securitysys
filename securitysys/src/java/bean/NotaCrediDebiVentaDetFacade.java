/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.NotaCrediDebiVentaDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebas
 */
@Stateless
public class NotaCrediDebiVentaDetFacade extends AbstractFacade<NotaCrediDebiVentaDet> {
    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaCrediDebiVentaDetFacade() {
        super(NotaCrediDebiVentaDet.class);
    }
    
}
