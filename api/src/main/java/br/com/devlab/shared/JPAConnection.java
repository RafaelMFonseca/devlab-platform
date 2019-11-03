package br.com.devlab.shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafael.fonseca
 */
public class JPAConnection {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        buildEntityManagerFactory();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    private static void buildEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(Constants.JPA_PERSISTENCE_UNIT);
        entityManager = entityManagerFactory.createEntityManager();
    }

}
