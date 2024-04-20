package kz.runtime.spring_practice_catalog.service.impl;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Option;
import kz.runtime.spring_practice_catalog.repository.CategoryRepository;
import kz.runtime.spring_practice_catalog.repository.OptionRepository;
import kz.runtime.spring_practice_catalog.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {
    private final OptionRepository optionRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Option> findAll() {
        return optionRepository.findAll();
    }

    @Override
    public List<Option> findAllByCategoryId(long categoryId) {
        return optionRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Option findById(long id) {
        return optionRepository.findById(id).orElseThrow();
    }

    @Override
    public void create(String optionNames, Category category) {
        for (String optionName : optionNames.split(", ")) {
            Option option = new Option();
            option.setName(optionName);
            option.setCategory(category);
            optionRepository.save(option);
            System.out.printf("Создана характеристика {%s}\n", optionName);
        }
    }

    @Override
    public void update(long id, Option updatedEntity) {
        Option option = optionRepository.findById(id).orElseThrow();
        option.setName(updatedEntity.getName());

        option.setCategory(updatedEntity.getCategory());
        optionRepository.save(option);
    }

    @Override
    public void deleteById(long id) {
        optionRepository.deleteById(id);
    }

    // NOT IMPLEMENTED
    @Override
    public void create(Option entity) {
        throw new IllegalArgumentException();
    }
}