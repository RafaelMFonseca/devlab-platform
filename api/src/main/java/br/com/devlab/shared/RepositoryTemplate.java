package br.com.devlab.shared;

import java.util.List;

/**
 *
 * @author rafael.fonseca
 * @param <T> type which is accessed by this DAO, for example Item.
 */
public interface RepositoryTemplate<T> {

    /**
     * Create a new instance of this type in the database.
     *
     * @param entity type to be created.
     */
    public T create(T entity);

    /**
     * Persist this instance in the database.
     *
     * @param entity type to be created.
     */
    public T save(T entity);

    /**
     * Remove an instance from the database.
     */
    public void delete(Long id);

    /**
     * Fetch all persisted instances of a given object type.
     */
    public List<T> findAll();

    /**
     * Fetch the entity identified by its legacy database identifier.
     */
    public T findById(Long id);

}
