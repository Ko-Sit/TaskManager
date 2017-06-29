package com.qulix.sitkinke.trainingtask.exceptions;

/**
 * Exceptions in DAO layer.
 *
 * @author sitkin
 */
public class DaoException extends RuntimeException {

    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
