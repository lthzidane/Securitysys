/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.DiagnosticoDet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Diagnostico;
import entities.Equipo;

/**
 *
 * @author acer
 */
@Stateless
public class DiagnosticoDetFacade extends AbstractFacade<DiagnosticoDet> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticoDetFacade() {
        super(DiagnosticoDet.class);
    }

    public boolean isDiagnosticoEmpty(DiagnosticoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DiagnosticoDet> diagnosticoDet = cq.from(DiagnosticoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnosticoDet, entity), cb.isNotNull(diagnosticoDet.get(DiagnosticoDet_.diagnostico)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Diagnostico findDiagnostico(DiagnosticoDet entity) {
        return this.getMergedEntity(entity).getDiagnostico();
    }

    public boolean isIdEquipoEmpty(DiagnosticoDet entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DiagnosticoDet> diagnosticoDet = cq.from(DiagnosticoDet.class);
        //cq.select(cb.literal(1L)).distinct(true).where(cb.equal(diagnosticoDet, entity), cb.isNotNull(diagnosticoDet.get(DiagnosticoDet_.idEquipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipo findIdEquipo(DiagnosticoDet entity) {
        return this.getMergedEntity(entity).getIdEquipo();
    }
    
}
