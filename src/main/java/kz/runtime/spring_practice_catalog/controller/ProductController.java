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
    public String showForm(Model model, @RequestParam(required = false) Long categoryId) {
        if (categoryId == null) {
            return "redirect:/products/create/chooseCategory";
        }
        model.addAttribute("category", categoryService.findById(categoryId));
        model.addAttribute("product", new Product());
        return "product_create";
    }

    @PostMapping("/create")
    public String createProduct(
            @ModelAttribute Product product,
            @RequestParam long categoryId,
            @RequestParam List<String> values,
            @RequestParam List<Long> optionIds) {
        productService.create(product, categoryId, optionIds, values);
        return "redirect:/products";
    }

    @GetMapping("/update/{productId}")
    public String showUpdateForm(@PathVariable("productId") long productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        model.addAttribute("options", categoryService.findById(product.getCategory().getId()).getOptions());
        model.addAttribute("values", product.getValueList());
        return "product_update";
    }

    @PostMapping("/update/{productId}")
    public String updateProduct(@PathVariable long productId,
                                @RequestParam String updatedName,
                                @RequestParam double updatedPrice,
                                @RequestParam List<String> valueNames,
                                @RequestParam List<Long> optionIds) {
        productService.update(productId, updatedName, updatedPrice, optionIds, valueNames);
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
        productService.deleteProductAndValues(productId);
        return "redirect:/products";
    }
}