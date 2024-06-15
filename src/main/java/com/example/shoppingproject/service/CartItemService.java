package com.example.shoppingproject.service;

import com.example.shoppingproject.domain.CartItem;
import com.example.shoppingproject.repository.CartItemRepository;
import com.example.shoppingproject.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByCartId(Long cartId) {
        return cartItemRepository.findCartItemsByCartId(cartId);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemByProductId(Long id) {
        return cartItemRepository.findByProductId(id);
    }

    public CartItem findCartItemByCartIdAndProductId(Long cartId, Long productId) {
        return cartItemRepository.findByCartIdAndProductId(cartId, productId);
    }

    public void saveCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }
}
