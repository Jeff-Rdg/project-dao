package org.jotasilva.dao;

import java.util.List;

public interface BaseDAO<T> {
    void insert(T entity);

    void update(T department);

    void deleteById(Integer id);

    void findById(Integer id);

    List<T> findAll();
}
