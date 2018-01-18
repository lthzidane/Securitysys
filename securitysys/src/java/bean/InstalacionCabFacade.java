/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.InstalacionCab;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.OrdenTrabajo;
import entities.InstalacionDet;
import java.util.Date;
import java.util.List;import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.OrdenTrabajo;
import entities.InstalacionDet;
import java.util.List;

/**
 *
 * @author acer
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

    public boolean isIdOtEmpty(InstalacionCab entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InstalacionCab> instalacionCab = cq.from(InstalacionCab.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instalacionCab, entity), cb.isNotNull(instalacionCab.get(InstalacionCab_.idOt)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public OrdenTrabajo findIdOt(InstalacionCab entity) {
        return this.getMergedEntity(entity).getIdOt();
    }

    public boolean isInstalacionDetListEmpty(InstalacionCab entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InstalacionCab> instalacionCab = cq.from(InstalacionCab.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(instalacionCab, entity), cb.isNotEmpty(instalacionCab.get(InstalacionCab_.instalacionDetList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<InstalacionDet> findInstalacionDetList(InstalacionCab entity) {
        InstalacionCab mergedEntity = this.getMergedEntity(entity);
        List<InstalacionDet> instalacionDetList = mergedEntity.getInstalacionDetList();
        instalacionDetList.size();
        return instalacionDetList;
    }

    InstalacionCab findByIdInstalacion(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Iterable<InstalacionCab> findBetweenFechaInstalacion(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
