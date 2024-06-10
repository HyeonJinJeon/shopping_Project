package com.example.shoppingproject.controller;

import com.example.shoppingproject.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
}
