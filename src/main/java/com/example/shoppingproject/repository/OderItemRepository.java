package com.example.shoppingproject.repository;

import com.example.shoppingproject.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderItemRepository extends JpaRepository<OrderItem, Long> {
}
