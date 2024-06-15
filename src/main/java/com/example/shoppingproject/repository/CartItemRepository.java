package com.example.shoppingproject.repository;

import com.example.shoppingproject.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findCartItemsByCartId(Long cartId);

    CartItem findByProductId(Long id);

    CartItem findByCartIdAndProductId(Long cartId, Long productId);
}
