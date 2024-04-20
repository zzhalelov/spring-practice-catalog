package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Product;

import java.util.List;

public interface ProductService {
    void create(Product product, long categoryId, List<Long> optionIds, List<String> values);

    List<Product> findAll();
}