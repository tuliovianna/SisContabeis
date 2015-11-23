/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.EnderecoEstabelecimento;

/**
 *
 * @author tulio
 */
public class EnderecoEstabelecimentoJpaController implements Serializable {

    public EnderecoEstabelecimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EnderecoEstabelecimento enderecoEstabelecimento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(enderecoEstabelecimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EnderecoEstabelecimento enderecoEstabelecimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            enderecoEstabelecimento = em.merge(enderecoEstabelecimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = enderecoEstabelecimento.getId();
                if (findEnderecoEstabelecimento(id) == null) {
                    throw new NonexistentEntityException("The enderecoEstabelecimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EnderecoEstabelecimento enderecoEstabelecimento;
            try {
                enderecoEstabelecimento = em.getReference(EnderecoEstabelecimento.class, id);
                enderecoEstabelecimento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enderecoEstabelecimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(enderecoEstabelecimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EnderecoEstabelecimento> findEnderecoEstabelecimentoEntities() {
        return findEnderecoEstabelecimentoEntities(true, -1, -1);
    }

    public List<EnderecoEstabelecimento> findEnderecoEstabelecimentoEntities(int maxResults, int firstResult) {
        return findEnderecoEstabelecimentoEntities(false, maxResults, firstResult);
    }

    private List<EnderecoEstabelecimento> findEnderecoEstabelecimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EnderecoEstabelecimento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EnderecoEstabelecimento findEnderecoEstabelecimento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EnderecoEstabelecimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnderecoEstabelecimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EnderecoEstabelecimento> rt = cq.from(EnderecoEstabelecimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
