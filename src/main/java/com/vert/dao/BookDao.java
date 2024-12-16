package com.vert.dao;

import com.vert.model.Book;

import java.util.HashSet;
import java.util.Set;

public class BookDao {
    private final Set<Book> books = new HashSet<>();

    public void addBook(String title, double price, int count) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setCount(book.getCount() + count);
                return;
            }
        }

        books.add(new Book(title, price, count));
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getCount() > 1) {
                book.setCount(book.getCount() - 1);
            }

            if (book.getTitle().equals(title) && book.getCount() == 1) {
                books.remove(book);
            }
        }
    }
}
