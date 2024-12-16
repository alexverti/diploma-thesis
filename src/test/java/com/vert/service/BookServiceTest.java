package com.vert.service;

import com.vert.dao.BookDao;
import com.vert.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {


    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookService bookService;

    @Test
    void testUpdateBookList() {
        Book book_1 = new Book("TestBook_1", 200.0, 1);
        Book book_2 = new Book("TestBook_2", 150.0, 1);
        Set<Book> books = Set.of(book_1, book_2);
        Mockito.when(bookDao.getBooks()).thenReturn(books);
        Map<Integer, Book> expectedResult = Map.of(1, book_1, 2, book_2);

        bookService.updateBookList();
        Map<Integer, Book> actualResult = bookService.getBookList();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testRemoveBook() {
       bookService.removeBook("TestBook_1");

       Mockito.verify(bookDao, Mockito.times(1)).removeBook("TestBook_1");
    }
}
