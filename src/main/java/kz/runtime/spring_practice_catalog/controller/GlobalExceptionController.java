package kz.runtime.spring_practice_catalog.controller;

import kz.runtime.spring_practice_catalog.exception.EntityNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    public String noSuchElementExceptionHandler(EntityNotFoundException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "not_found";
    }
}