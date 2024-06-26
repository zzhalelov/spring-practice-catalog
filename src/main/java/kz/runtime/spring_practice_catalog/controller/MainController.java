package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("user", userService.getUser());
        return "index";
    }
}