package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Option;
import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.model.Value;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    void create(Product product, long categoryId, List<Long> optionsIds, List<String> values);

    List<Product> findAll();

    void update(long productId, String updatedName, double updatedPrice, List<Long> optionIds, List<String> values);

    Product findById(long id);

    void deleteById(long id);

    Map<Option, Optional<Value>> getOptions(Product product);

    List<Product> findByFilters(Double minPrice, Double maxPrice, Long categoryId);
}