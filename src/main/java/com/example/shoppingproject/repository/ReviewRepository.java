package com.example.shoppingproject.repository;

import com.example.shoppingproject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
