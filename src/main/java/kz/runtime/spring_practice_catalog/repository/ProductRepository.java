package kz.runtime.spring_practice_catalog.repository;

import kz.runtime.spring_practice_catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}