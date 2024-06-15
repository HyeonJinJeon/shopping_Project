package com.example.shoppingproject.service;

import com.example.shoppingproject.domain.Product;
import com.example.shoppingproject.repository.ProductRepository;
import com.example.shoppingproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product getProductById(Long Id){
        return productRepository.findById(Id).get();
    }

    public List<Product> getAllProducts() {
        // 예시로 더미 데이터를 생성하여 반환합니다.
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();
        return products;
    }

    public List<Product> getProductsByCategoryId(Long CategoryId) {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> {
            if (product.getCategory().getId().equals(CategoryId)) {
                products.add(product);
            }
        });
        return products;
    }
}
