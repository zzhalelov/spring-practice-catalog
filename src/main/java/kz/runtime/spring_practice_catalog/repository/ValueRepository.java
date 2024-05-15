package kz.runtime.spring_practice_catalog.repository;

import kz.runtime.spring_practice_catalog.model.Option;
import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ValueRepository extends JpaRepository<Value, Long> {
    @Transactional
    void deleteByProduct(Product product);

    List<Value> findAllProductsById(long productId);

    Optional<Value> findByProductAndOption(Product product, Option option);
}