package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Category;
import kz.runtime.spring_practice_catalog.model.Product;
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
                                @RequestParam Map<String, String> values) {
        List<String> val = List.of();
        double price = Double.parseDouble(values.get("price"));
        productService.create(name, categoryId, val, price);
        return "redirect:/products";
    }

    @GetMapping("/update/{productId}")
    public String showUpdateForm(@PathVariable("productId") long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "product_update";
    }

    @PostMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") long productId, @ModelAttribute Product updatedProduct) {
        productService.update(productId, updatedProduct);
        return "redirect:/products";
    }

    @GetMapping("/delete/{productId}")
    public String showDeleteForm(@PathVariable("productId") long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "product_delete";
    }

    @PostMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") long productId) {
        productService.deleteById(productId);
        return "redirect:/products";
    }
}