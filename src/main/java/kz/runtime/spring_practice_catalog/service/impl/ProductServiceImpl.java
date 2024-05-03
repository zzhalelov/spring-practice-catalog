package kz.runtime.spring_practice_catalog.service.impl;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.model.Value;
import kz.runtime.spring_practice_catalog.repository.ProductRepository;
import kz.runtime.spring_practice_catalog.repository.ValueRepository;
import kz.runtime.spring_practice_catalog.service.CategoryService;
import kz.runtime.spring_practice_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ValueRepository valueRepository;

    @Override
    public void create(String name, long categoryId, List<String> values, double price) {
        Category category = categoryService.findById(categoryId);
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);

        productRepository.save(product);

        for (String value : values) {
            Value val = new Value();
            val.setProduct(product);
            valueRepository.save(val);
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(long id, Product updatedProduct) {
        Product currentProduct = findById(id);
        currentProduct.setName(updatedProduct.getName());
        currentProduct.setPrice(updatedProduct.getPrice());
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}