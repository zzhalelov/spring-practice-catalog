package kz.runtime.spring_practice_catalog.service;

import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void create(Product product, long categoryId, List<Long> optionIds, List<String> values) {

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}