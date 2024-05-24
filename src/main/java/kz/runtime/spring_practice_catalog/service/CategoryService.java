package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Option;

import java.util.List;

public interface CategoryService extends AbstractService<Category> {
    List<Option> findOptionsByCategoryId(long categoryId);
}