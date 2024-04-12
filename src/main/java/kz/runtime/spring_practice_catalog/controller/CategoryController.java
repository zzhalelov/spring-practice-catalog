package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("category", new Category());
        return "category_create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Category category, Model model) {
        if (category.getName() == null || category.getName().isEmpty()) {
            model.addAttribute("error", "Название пустое");
            return "category_create";
        }

        boolean exists = false;
        List<Category> categoryList = categoryRepository.findAll();
        for (Category c : categoryList) {
            if (c.getName().equals(category.getName())) {
                exists = true;
                break;
            }
        }
        if (exists) {
            model.addAttribute("error", "Такая категория уже есть");
            return "category_create";
        }
        categoryRepository.save(category);
        return "redirect:/categories";
    }
}