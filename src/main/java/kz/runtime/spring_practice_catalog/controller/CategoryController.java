package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Category;

import kz.runtime.spring_practice_catalog.service.CategoryService;
import kz.runtime.spring_practice_catalog.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final OptionService optionService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("category", new Category());
        return "category_create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Category category, @RequestParam String optionNames) {
        categoryService.create(category);
        optionService.create(optionNames, category);
        return "redirect:/categories";
    }
}