package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.model.Value;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    void create(Product product, long categoryId, List<Long> optionsIds, List<String> values);

    List<Product> findAll();

    void update(long id, String updatedName, double updatedPrice, List<Long> optionIds, List<String> values);

    Product findById(long id);

    void deleteById(long id);

    List<Value> findValuesByProductId(long id);

    void deleteProductAndValues(long productId);
}