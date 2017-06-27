package com.qulix.sitkinke.trainingtask.dao;

import com.qulix.sitkinke.trainingtask.entities.Entity;

import java.util.List;

/**
 *
 * Created by upsit on 27.06.2017.
 */
public interface IDao <T extends Entity> {

    void add(T t);
    void modify(T t);
    void delete(int id);
    T getById(int id);
    int getNextId();
    List<T> getAll();


}
