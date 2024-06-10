package com.example.shoppingproject.controller;

import org.springframework.ui.Model;
import com.example.shoppingproject.domain.Category;
import com.example.shoppingproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/main")
    public String main(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category/main";
    }
}
