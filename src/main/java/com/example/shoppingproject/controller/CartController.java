package com.example.shoppingproject.controller;

import com.example.shoppingproject.domain.Cart;
import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
//    @GetMapping("/list")
//    public String getCart(Model model, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        Cart cart = cartService.getCartByUserEmail(user);
//        model.addAttribute("cart", cart);
//        return "/product/list";
//    }
}
