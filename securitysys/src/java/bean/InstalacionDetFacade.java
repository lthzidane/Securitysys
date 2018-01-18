/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.InstalacionDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Equipo;
import entities.InstalacionCab;

/**
 *
 * @author acer
 */
@Stateless
public class InstalacionDetFacade extends AbstractFacade<InstalacionDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstalacionDetFacade() {
        super(InstalacionDet.class);
    }

    public boolean isIdEquipoEmpty(InstalacionDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InstalacionDet> instalacionDet = cq.from(InstalacionDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instalacionDet, entity), cb.isNotNull(instalacionDet.get(InstalacionDet_.idEquipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipo findIdEquipo(InstalacionDet entity) {
        return this.getMergedEntity(entity).getIdEquipo();
    }

    public boolean isInstalacionCabEmpty(InstalacionDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InstalacionDet> instalacionDet = cq.from(InstalacionDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instalacionDet, entity), cb.isNotNull(instalacionDet.get(InstalacionDet_.instalacionCab)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public InstalacionCab findInstalacionCab(InstalacionDet entity) {
        return this.getMergedEntity(entity).getInstalacionCab();
    }
    
}
