package com.example.shoppingproject.repository;

import com.example.shoppingproject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
