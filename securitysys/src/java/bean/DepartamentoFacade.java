/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebas
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    @PersistenceContext(unitName = "securitysysPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }

    Departamento findByIdDepartamento(Integer idDepartamento) {
        try {
            return (Departamento) em.createNamedQuery("Departamento.findByIdDepartamento").setParameter("idDepartamento", idDepartamento).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
