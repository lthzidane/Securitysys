/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.LibroVenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Cliente;
import entities.Venta;

/**
 *
 * @author acer
 */
@Stateless
public class LibroVentaFacade extends AbstractFacade<LibroVenta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroVentaFacade() {
        super(LibroVenta.class);
    }

    public boolean isIdClienteEmpty(LibroVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<LibroVenta> libroVenta = cq.from(LibroVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(libroVenta, entity), cb.isNotNull(libroVenta.get(LibroVenta_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(LibroVenta entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isVentaEmpty(LibroVenta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<LibroVenta> libroVenta = cq.from(LibroVenta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(libroVenta, entity), cb.isNotNull(libroVenta.get(LibroVenta_.venta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Venta findVenta(LibroVenta entity) {
        return this.getMergedEntity(entity).getVenta();
    }
    
}
