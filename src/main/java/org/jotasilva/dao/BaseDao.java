package org.jotasilva.dao;

import java.util.List;

public interface BaseDao<T> {
    void insert(T entity);

    void update(T entity);

    void deleteById(Integer id);

    T findById(Integer id);

    List<T> findAll();
}
