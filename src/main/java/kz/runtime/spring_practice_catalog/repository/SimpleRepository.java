package kz.runtime.spring_practice_catalog.repository;

import java.util.List;

public interface SimpleRepository<T> {
    T findById(long id);

    List<T> findAll();

    void create(T t);
}