package com.example.shoppingproject.repository;

import com.example.shoppingproject.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
