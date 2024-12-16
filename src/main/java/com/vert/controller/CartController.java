package com.vert.controller;

import com.vert.model.Book;
import com.vert.service.CartService;

public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public void showCart() {
        System.out.println("Ваша корзина:");
        for (Book book : cartService.getCart()) {
            System.out.println("- " + book.getTitle() + ": " + book.getPrice() + " руб.");
        }
    }

    public void showTotalPrice() {
        System.out.println("Общая стоимость: " + cartService.countTotalPrice() + " руб.");
    }
}
