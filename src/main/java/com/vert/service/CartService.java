package com.vert.service;

import com.vert.model.Book;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public double countTotalPrice() {
        double total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }

        return total;
    }
    public List<Book> getCart() {
        return books;
    }

    public void clear() {
        books.clear();
    }
}
