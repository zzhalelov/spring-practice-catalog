package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Product;

import java.util.List;

public interface ProductService {
    void create(String name, long categoryId, List<String> values, double price);

    List<Product> findAll();
}