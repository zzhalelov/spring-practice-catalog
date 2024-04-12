package kz.runtime.spring_practice_catalog.repository;

import kz.runtime.spring_practice_catalog.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {

}