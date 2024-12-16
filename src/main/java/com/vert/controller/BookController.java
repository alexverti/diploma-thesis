package com.vert.controller;

import com.vert.model.Book;
import com.vert.service.BookService;

import java.util.*;

public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void showBookList() {
        Map<Integer, Book> shopList = bookService.getBookList();

        System.out.println();
        System.out.println("----------------");
        System.out.println("Доступные книги:");
        for (Map.Entry<Integer, Book> entry : shopList.entrySet()) {
            Integer bookIndex = entry.getKey();
            String bookTitle = entry.getValue().getTitle();
            Integer count = entry.getValue().getCount();
            double price = entry.getValue().getPrice();

            System.out.println(bookIndex + ". " + bookTitle + ": " + price + " руб. В количестве: " + count);
        }
        System.out.println("----------------");
        System.out.println();
    }
}
