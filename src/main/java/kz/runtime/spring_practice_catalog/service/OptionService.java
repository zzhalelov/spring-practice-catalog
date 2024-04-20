package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Option;

import java.util.List;

public interface OptionService extends AbstractService<Option> {
    void create(String optionNames, Category category);

    List<Option> findAllByCategoryId(long categoryId);
}