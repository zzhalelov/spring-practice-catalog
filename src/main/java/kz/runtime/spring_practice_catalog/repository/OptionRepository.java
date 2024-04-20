package kz.runtime.spring_practice_catalog.repository;

import kz.runtime.spring_practice_catalog.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByCategoryId(long categoryId);
}