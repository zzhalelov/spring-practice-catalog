package kz.runtime.spring_practice_catalog.service.impl;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Option;
import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.model.Value;
import kz.runtime.spring_practice_catalog.repository.CategoryRepository;
import kz.runtime.spring_practice_catalog.repository.OptionRepository;
import kz.runtime.spring_practice_catalog.repository.ProductRepository;
import kz.runtime.spring_practice_catalog.repository.ValueRepository;
import kz.runtime.spring_practice_catalog.service.CategoryService;
import kz.runtime.spring_practice_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OptionRepository optionRepository;
    private final ValueRepository valueRepository;

    @Override
    public void create(Product product, long categoryId, List<Long> optionIds, List<String> values) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        product.setCategory(category);

        productRepository.save(product);

        List<Option> options = optionRepository.findAllById(optionIds);

        for (int i = 0; i < optionIds.size(); i++) {
            Option option = options.get(i);
            String valueName = values.get(i);

            Value value = new Value();
            value.setName(valueName);
            value.setProduct(product);
            value.setOption(option);
            valueRepository.save(value);
        }

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
    public void update(long productId, String updatedName, double updatedPrice, List<Long> optionIds, List<String> values) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setPrice(updatedPrice);
        product.setName(updatedName);
        productRepository.save(product);

        for (int i = 0; i < optionIds.size(); i++) {
            long optionId = optionIds.get(i);
            Value value = valueRepository.findByProductIdAndOptionId(productId, optionId).orElseThrow();
            value.setName(values.get(i));
            valueRepository.save(value);
        }
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Value> findValuesByProductId(long id) {
        return valueRepository.findAllProductsById(id);
    }

    @Override
    @Transactional
    public void deleteProductAndValues(long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        valueRepository.deleteByProduct(product);
        productRepository.delete(product);
    }
}