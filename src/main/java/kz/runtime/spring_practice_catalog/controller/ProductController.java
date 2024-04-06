package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.repository.CategoryRepository;
import kz.runtime.spring_practice_catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product_create";
    }

    @PostMapping
    public String createPost(@ModelAttribute Product product, @ModelAttribute Category category) {
        productRepository.create(product);
        return "redirect:/products";
    }
}