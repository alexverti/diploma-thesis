package com.vert.service;

import com.vert.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    private CartService cartService = new CartService();

    @Test
    void testAdditionToCart() {
        Book book_1 = new Book("TestBook_1", 200.0, 1);
        Book book_2 = new Book("TestBook_2", 150.0, 1);
        cartService.addBook(book_1);
        cartService.addBook(book_2);
        int expectedSize = 2;

        List<Book> actualCart = cartService.getCart();

        Assertions.assertEquals(expectedSize, actualCart.size());
    }

    @Test
    void testCountTotalPrice() {
        Book book_1 = new Book("TestBook_1", 200.0, 1);
        Book book_2 = new Book("TestBook_2", 150.0, 1);
        cartService.addBook(book_1);
        cartService.addBook(book_2);
        double expectedSize = 350.0;

        double actualTotalPrice = cartService.countTotalPrice();

        Assertions.assertEquals(expectedSize, actualTotalPrice);
    }

    @Test
    void testClearCart() {
        Book book_1 = new Book("TestBook_1", 200.0, 1);
        Book book_2 = new Book("TestBook_2", 150.0, 1);
        cartService.addBook(book_1);
        cartService.addBook(book_2);
        int expectedSize = 0;

        cartService.clear();

        int actualSize = cartService.getCart().size();

        Assertions.assertEquals(expectedSize, actualSize);
    }
}
