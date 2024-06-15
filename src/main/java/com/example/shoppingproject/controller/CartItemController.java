package com.example.shoppingproject.controller;

import com.example.shoppingproject.domain.Cart;
import com.example.shoppingproject.domain.CartItem;
import com.example.shoppingproject.domain.Product;
import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.service.CartItemService;
import com.example.shoppingproject.service.CartService;
import com.example.shoppingproject.service.ProductService;
import com.example.shoppingproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final CartService cartService;

    @PostMapping("/addCart")
    public String addCart(@RequestParam("quantity") int quantity, @RequestParam("product") Long productId, HttpSession session, HttpServletRequest request) {
        Product product = productService.getProductById(productId);
        User user = (User) session.getAttribute("user");
        Cart cart = user.getCart();

        if (cart == null) {
            // 유저의 장바구니가 없는 경우
            cart = new Cart();
            cart.setUser(user);
            cartService.save(cart); // 새로운 장바구니를 데이터베이스에 저장

            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItemService.saveCartItem(cartItem); // 새로운 장바구니 아이템을 데이터베이스에 저장
        } else {
            // 유저의 장바구니가 있는 경우
            CartItem cartItem = cartItemService.findCartItemByCartIdAndProductId(cart.getId(), productId);

            if (cartItem == null) {
                // 장바구니에 해당 상품이 없는 경우
                cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
                cartItemService.saveCartItem(cartItem); // 새로운 장바구니 아이템을 데이터베이스에 저장
            } else {
                // 장바구니에 해당 상품이 있는 경우
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItemService.saveCartItem(cartItem); // 기존 장바구니 아이템을 업데이트
            }
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
