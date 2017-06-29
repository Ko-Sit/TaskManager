package com.qulix.sitkinke.trainingtask.entities;

/**
 * Abstract class that describes {@link Employee}.
 *
 * @author sitkin
 */
public abstract class Entity {

    private int id;

    /**
     * Gets entity id.
     *
     * @return the entity id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets entity id.
     *
     * @param id entity id
     */
    public void setId(int id) {
        this.id = id;
    }
}
