package com.qulix.sitkinke.trainingtask.dao;

import java.util.List;

import com.qulix.sitkinke.trainingtask.entities.Entity;

/**
 * Interface that describes DAO basic methods.
 *
 * @author sitkin
 */
public interface IDao<T extends Entity> {

    /**
     * Sets entity.
     *
     * @param t the entity
     */
    void add(T t);

    /**
     * Modifies entity.
     *
     * @param t the entity
     */
    void modify(T t);

    /**
     * Deletes entity.
     *
     * @param id the entity id
     */
    void delete(int id);

    /**
     * Deletes entity.
     *
     * @param id the entity id
     * @return the entity
     */
    T getById(int id);

    /**
     * Gets entity id.
     *
     * @return id the next entity id
     */
    int getNextId();

    /**
     * Gets list of entities.
     *
     * @return list the list of entities
     */
    List<T> getAll();

}
