package com.example.shoppingproject.controller;

import com.example.shoppingproject.domain.Product;
import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.service.ProductService;
import com.example.shoppingproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/signUp")
    public String signUpForm(Model model){
        model.addAttribute("user", new User());
        return "user/signUp";
    }
    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/signIn";
    }

    @GetMapping("/signIn")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "user/signIn";
    }
    @PostMapping("/signIn")
    public String signIn(@ModelAttribute User user, Model model) {
        boolean isUser = userService.authenticateByEmail(user.getEmail(), user.getPassword());
        if(isUser){
            return "redirect:/main";
        }else{
            return "redirect:/signIn";
        }
    }

    @GetMapping("/main")
    public String main(Model model){
        List<Product> products = productService.getAllProducts(); // productService는 ProductService에 의존성 주입되어야 함
        model.addAttribute("products", products);
        return "user/main";
    }
}
