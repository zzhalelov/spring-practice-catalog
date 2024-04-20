package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.service.CategoryService;
import kz.runtime.spring_practice_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/create/chooseCategory")
    public String chooseCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "choose_category_for_product";
    }

    @GetMapping("/create")
    public String showForm(Model model, @RequestParam long categoryId) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryService.findById(categoryId));
        return "product_create";
    }

    @PostMapping("/create")
    public String showForm(
            @ModelAttribute Product product,
            @RequestParam List<String> values,
            @RequestParam(required = false) List<Long> optionIds
    ) {
        System.out.println(product);
        System.out.println(values);
        System.out.println(optionIds);
        return "redirect:/products";
    }
}
