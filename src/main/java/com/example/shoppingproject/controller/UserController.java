package com.example.shoppingproject.controller;

import com.example.shoppingproject.domain.Product;
import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.service.ProductService;
import com.example.shoppingproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String signIn(@ModelAttribute User user, HttpSession session, HttpServletRequest request) {
        boolean isUser = userService.authenticateByEmail(user.getEmail(), user.getPassword());
        if(isUser){
            User loginUser = userService.findUserByEmail(user.getEmail());
            session = request.getSession();
            session.setAttribute("user", loginUser);
            if(session.getAttribute("user") == null){
                return "redirect:/signIn";
            }else{
                return "redirect:/main";
            }
        }else{
            return "redirect:/signIn";
        }
    }


}
