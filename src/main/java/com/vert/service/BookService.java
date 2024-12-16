package com.vert.service;

import com.vert.dao.BookDao;
import com.vert.model.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookService {
    Map<Integer, Book> shopList = new HashMap<>();

    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
        updateBookList();
    }

    public void updateBookList() {
        Set<Book> books = bookDao.getBooks();
        int index = 1;
        for (Book book : books) {
            shopList.put(index, book);
            index++;
        }
    }

    public Map<Integer, Book> getBookList() {
        return shopList;
    }

    public void removeBook(String title) {
        bookDao.removeBook(title);
    }
}
