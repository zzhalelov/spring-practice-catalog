package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.model.Option;
import kz.runtime.spring_practice_catalog.repository.CategoryRepository;
import kz.runtime.spring_practice_catalog.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/options")
public class OptionController {
    private final OptionRepository optionRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("option", new Option());
        model.addAttribute("categories", categoryRepository.findAll());
        return "option_create";
    }

    @PostMapping("/create")
    public String createOption(@ModelAttribute Option option) {
        optionRepository.save(option);
        return "redirect:/options/create";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("options", optionRepository.findAll());
        return "options";
    }
}