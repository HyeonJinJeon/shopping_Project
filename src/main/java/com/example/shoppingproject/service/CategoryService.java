package com.example.shoppingproject.service;

import com.example.shoppingproject.domain.Category;
import com.example.shoppingproject.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
