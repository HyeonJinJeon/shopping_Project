package com.example.shoppingproject.service;

import com.example.shoppingproject.domain.Cart;
import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

//    public Cart getCartByUserId(Long userId) {
//        Cart cart = cartRepository.findByUserId(userId);
//        return cart;
//    }
    public Cart getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        return cart;
    }

}
