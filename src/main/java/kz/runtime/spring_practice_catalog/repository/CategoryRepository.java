package kz.runtime.spring_practice_catalog.repository;

import kz.runtime.spring_practice_catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}