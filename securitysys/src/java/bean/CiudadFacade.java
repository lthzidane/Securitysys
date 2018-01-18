/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Ciudad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Zona;
import entities.Cliente;
import entities.Empresa;
import entities.Sucursal;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public boolean isZonaListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.zonaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Zona> findZonaList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Zona> zonaList = mergedEntity.getZonaList();
        zonaList.size();
        return zonaList;
    }

    public boolean isClienteListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }

    public boolean isEmpresaListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
       ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.empresaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Empresa> findEmpresaList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Empresa> empresaList = mergedEntity.getEmpresaList();
        empresaList.size();
        return empresaList;
    }

    public boolean isSucursalListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        ////cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.sucursalList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Sucursal> findSucursalList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Sucursal> sucursalList = mergedEntity.getSucursalList();
        sucursalList.size();
        return sucursalList;
    }
    
}
