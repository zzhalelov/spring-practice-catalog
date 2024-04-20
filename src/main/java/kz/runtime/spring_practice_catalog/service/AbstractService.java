package kz.runtime.spring_practice_catalog.service;

import java.util.List;

public interface AbstractService<T> {
    List<T> findAll();

    T findById(long id);

    void create(T entity);

    void update(long id, T updatedEntity);

    void deleteById(long id);
}