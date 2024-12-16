package com.vert;

import com.vert.controller.BookController;
import com.vert.controller.CartController;
import com.vert.controller.UserController;
import com.vert.dao.BookDao;
import com.vert.dao.UserDao;
import com.vert.model.Book;
import com.vert.model.User;
import com.vert.service.BookService;
import com.vert.service.CartService;
import com.vert.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookDao bookDao = new BookDao();
        bookDao.addBook("Java. Programming methods", 500, 3);
        bookDao.addBook("Effective Java", 600, 3);
        bookDao.addBook("Head First Java, Learning Java", 450, 3);
        bookDao.addBook("Java. Beginner's Guide", 400, 4);
        bookDao.addBook("Java for Dummies", 300, 5);

        UserDao userDao = new UserDao();

        UserService userService = new UserService(userDao);
        BookService bookService = new BookService(bookDao);
        CartService cartService = new CartService();

        CartController cartController = new CartController(cartService);
        UserController userController = new UserController(scanner, userService);
        BookController bookController = new BookController(bookService);

        System.out.println("Вас приветствует интернет магазин АлексБук");
        User currentUser = null;

        int choice = -1;
        while (choice != 0) {
            if (currentUser == null) {
                showLoginForm();
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        userController.registerUser();
                        break;
                    case 2:
                        currentUser = userController.loginUser();
                        break;
                }
            } else {
                choice = -1;
                while (choice != 5) {
                    showMainMenu();
                    choice = Integer.parseInt(scanner.nextLine());
                    Map<Integer, Book> bookList = bookService.getBookList();
                    switch (choice) {
                        case 1:
                            bookController.showBookList();
                            break;
                        case 2:
                            System.out.println("Введите номер книги, чтобы добавить ее в корзину");
                            choice = Integer.parseInt(scanner.nextLine());
                            Book book = bookList.get(choice);
                            cartService.addBook(book);
                            break;
                        case 3:
                            cartController.showCart();
                            cartController.showTotalPrice();
                            break;
                        case 4:
                            System.out.println("Покупка совершена, с вами свяжется наш агент");
                            cartService.clear();
                        case 5:
                            currentUser = null;
                            break;
                    }
                }
            }
        }
    }


    public static void showLoginForm() {
        System.out.println("Введите номер команды, чтобы продолжить:");
        System.out.println("0. Завершить работу программы");
        System.out.println("1. Регистрация");
        System.out.println("2. Авторизация");
    }

    public static void showMainMenu() {
        System.out.println("1. Вывести на экран доступные книги");
        System.out.println("2. Добавить книгу в корзину");
        System.out.println("3. Показать корзину");
        System.out.println("4. Совершить покупку");
        System.out.println("5. Выйти из системы");
    }
}