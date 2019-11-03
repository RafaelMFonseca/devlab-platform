package br.com.devlab.shared;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.devlab.shared.JPAConnection;

/**
 * Generic Database Access Object that should be implemented by all DAOs.
 * This class should not be instantiated directly.
 *
 * https://github.com/teiniker/teiniker-lectures-modeldrivendevelopment/blob/master/code-generation/Generator-DAO-Solution/src/generic/java/org/se/lab/DAOTemplate.java
 * https://www.programcreek.com/java-api-examples/?code=Fatlonder/E-Clinic/E-Clinic-master/src/main/java/com/jfc/eclinic/services/impl/AdminClinicServiceImpl.java#
 * https://github.com/DSpace/DSpace/blob/master/dspace-api/src/main/java/org/dspace/core/GenericDAO.java
 * https://github.com/DSpace/DSpace/blob/master/dspace-api/src/main/java/org/dspace/core/AbstractHibernateDAO.java
 * https://stackoverflow.com/questions/38044194/how-to-implement-hibernate-dao-with-generics
 * https://pt.stackoverflow.com/questions/12927/qual-a-diferen%C3%A7a-entre-dao-e-repository
 *
 * @author rafael.fonseca
 */
public abstract class RepositoryImplTemplate<T> implements RepositoryTemplate<T> {

    private Class<T> clazz;

    protected RepositoryImplTemplate(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T create(T entity) {
        EntityManager entityManager = JPAConnection.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        entityManager.flush();
        transaction.commit();
        return entity;
    }

    @Override
    public T save(T entity) {
        EntityManager entityManager = JPAConnection.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        entityManager.flush();
        transaction.commit();
        return entity;
    }

    @Override
    public void delete(Long id) {
        T entity = findById(id);
        EntityManager entityManager = JPAConnection.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entity);
        entityManager.flush();
        transaction.commit();
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = JPAConnection.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public T findById(Long id) {
        EntityManager entityManager = JPAConnection.getEntityManager();
        return entityManager.find(getEntityClass(), id);
    }

    protected Class<T> getEntityClass() {
        return this.clazz;
    }

}
