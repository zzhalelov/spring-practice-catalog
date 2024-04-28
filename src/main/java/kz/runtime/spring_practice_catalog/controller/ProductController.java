package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.service.CategoryService;
import kz.runtime.spring_practice_catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String showForm(Model model, @RequestParam(required = false) Long categoryId) {
        if (categoryId == null) {
            model.addAttribute("categories", categoryService.findAll());
            return "choose_category_for_product";
        } else {
            Category category = categoryService.findById(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("options", category.getOptions());
            return "product_create";
        }
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam String name,
                                @RequestParam long categoryId,
                                @RequestParam Map<String, String> requestParams) {
        List<String> values = List.of();
        double price = Double.parseDouble(requestParams.get("price"));
        productService.create(name, categoryId, values, price);
        return "redirect:/products";
    }
}