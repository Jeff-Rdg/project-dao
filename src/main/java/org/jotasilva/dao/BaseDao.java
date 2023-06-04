package org.jotasilva.dao;

import java.util.List;

public interface BaseDao<T> {
    void insert(T entity);

    void update(T department);

    void deleteById(Integer id);

    void findById(Integer id);

    List<T> findAll();
}
