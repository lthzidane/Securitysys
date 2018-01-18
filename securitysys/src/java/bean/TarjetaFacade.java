/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Tarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.EntidadEmisora;
import entities.MarcaTarjeta;
import entities.TipoTarjeta;
import entities.CobroTarjeta;
import java.util.List;

/**
 *
 * @author acer
 */
@Stateless
public class TarjetaFacade extends AbstractFacade<Tarjeta> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarjetaFacade() {
        super(Tarjeta.class);
    }

    public boolean isIdEntidadEmisoraEmpty(Tarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tarjeta> tarjeta = cq.from(Tarjeta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tarjeta, entity), cb.isNotNull(tarjeta.get(Tarjeta_.idEntidadEmisora)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public EntidadEmisora findIdEntidadEmisora(Tarjeta entity) {
        return this.getMergedEntity(entity).getIdEntidadEmisora();
    }

    public boolean isIdMarcaTarjetaEmpty(Tarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tarjeta> tarjeta = cq.from(Tarjeta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tarjeta, entity), cb.isNotNull(tarjeta.get(Tarjeta_.idMarcaTarjeta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public MarcaTarjeta findIdMarcaTarjeta(Tarjeta entity) {
        return this.getMergedEntity(entity).getIdMarcaTarjeta();
    }

    public boolean isIdTipoTarjetaEmpty(Tarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tarjeta> tarjeta = cq.from(Tarjeta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tarjeta, entity), cb.isNotNull(tarjeta.get(Tarjeta_.idTipoTarjeta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoTarjeta findIdTipoTarjeta(Tarjeta entity) {
        return this.getMergedEntity(entity).getIdTipoTarjeta();
    }

    public boolean isCobroTarjetaListEmpty(Tarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tarjeta> tarjeta = cq.from(Tarjeta.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tarjeta, entity), cb.isNotEmpty(tarjeta.get(Tarjeta_.cobroTarjetaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CobroTarjeta> findCobroTarjetaList(Tarjeta entity) {
        Tarjeta mergedEntity = this.getMergedEntity(entity);
        List<CobroTarjeta> cobroTarjetaList = mergedEntity.getCobroTarjetaList();
        cobroTarjetaList.size();
        return cobroTarjetaList;
    }
    
}
