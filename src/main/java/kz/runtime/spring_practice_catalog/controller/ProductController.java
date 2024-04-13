package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Option;
import kz.runtime.spring_practice_catalog.model.Product;
import kz.runtime.spring_practice_catalog.model.Value;
import kz.runtime.spring_practice_catalog.repository.CategoryRepository;
import kz.runtime.spring_practice_catalog.repository.OptionRepository;
import kz.runtime.spring_practice_catalog.repository.ProductRepository;
import kz.runtime.spring_practice_catalog.repository.ValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OptionRepository optionRepository;
    private final ValueRepository valueRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("options", optionRepository.findAll());
        return "product_create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product,
                                @RequestParam("optionIds") List<Long> optionIds,
                                @RequestParam("values") List<String> values) {
        productRepository.save(product);
        for (int i = 0; i < optionIds.size(); i++) {
            Option option = optionRepository.findById(optionIds.get(i)).orElse(null);
            if (option != null) {
                Value value = new Value();
                value.setName(values.get(i));
                value.setOption(option);
                value.setProduct(product);
                valueRepository.save(value);
            }
        }
        return "redirect:/products";
    }
}
