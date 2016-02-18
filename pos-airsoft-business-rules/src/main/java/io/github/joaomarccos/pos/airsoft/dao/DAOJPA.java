package io.github.joaomarccos.pos.airsoft.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 * @author João Marcos F DAO default para CRUD básico
 * @param <T>
 */
public class DAOJPA<T> implements DAO<T> {

    protected EntityManager entityManager;

    public DAOJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean save(T obj) {
        EntityTransaction trnasaction = entityManager.getTransaction();

        try {
            trnasaction.begin();
            entityManager.persist(obj);
            trnasaction.commit();
            entityManager.detach(obj);
            return true;
        } catch (Exception ex) {
            if (trnasaction.isActive()) {
                trnasaction.rollback();
            }
            return false;
        }

    }

    @Override
    public boolean update(T obj) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(obj);
            transaction.commit();
            entityManager.detach(obj);
            return true;
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean delete(T obj) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(obj);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public T find(Object key, Class<T> entity) {
        return entityManager.find(entity, key);
    }

    @Override
    public List<T> listQuery(String namedQuery, Map<String, Object> params) {
        entityManager.clear();
        Query query = entityManager.createNamedQuery(namedQuery);
        if (params != null && !params.isEmpty()) {
            params.keySet().stream().forEach((parametro) -> {
                query.setParameter(parametro, params.get(parametro));
            });
        }
        return query.getResultList();
    }

    @Override
    public T simpleQuery(String namedQuery, Map<String, Object> params) {
        entityManager.clear();
        Query query = entityManager.createNamedQuery(namedQuery);
        if (params != null && !params.isEmpty()) {
            params.keySet().stream().forEach((parametro) -> {
                query.setParameter(parametro, params.get(parametro));
            });
        }
        return (T) query.getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
