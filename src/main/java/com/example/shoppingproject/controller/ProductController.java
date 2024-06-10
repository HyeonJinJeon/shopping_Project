package com.example.shoppingproject.controller;

import com.example.shoppingproject.domain.Cart;
import com.example.shoppingproject.domain.CartItem;
import com.example.shoppingproject.domain.Product;
import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.service.CartItemService;
import com.example.shoppingproject.service.CartService;
import com.example.shoppingproject.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CartService cartService;
    private final CartItemService cartItemService;
    @GetMapping("/list")
    public String list(@RequestParam Long id, Model model, HttpSession session){

        List<Product> products = productService.getProductsByCategoryId(id);
        model.addAttribute("products", products);

        User user = (User) session.getAttribute("user");

        if (user != null) {
            if (user.getCart() != null) {
                Cart cart = cartService.getCartById(user.getCart().getId());
                if (cart != null) {
                    List<CartItem> cartItems = cartItemService.getCartItemsByCartId(cart.getId());
                    List<CartItem> allCartItems = cartItemService.getAllCartItems();
                    System.out.println("모든 아이템" + allCartItems.toString());
                    System.out.println("Cart ID: " + cart.getId());
                    System.out.println("Cart Items Size: " + cartItems.size());
                    System.out.println("Cart Items: " + cartItems);
                    model.addAttribute("cart", cart);
                    model.addAttribute("cartItems", cartItems);
                    model.addAttribute("user", user);
                } else {
                    System.out.println("Cart is null");
                }
            } else {
                System.out.println("User cart is null");
            }
        } else {
            System.out.println("User is null");
        }
        return "/product/list";
    }
}
