package com.vert.controller;

import com.vert.model.User;
import com.vert.service.UserService;

import java.util.Scanner;

public class UserController {

    private Scanner scanner;
    private final UserService userService;

    public UserController(Scanner scanner, UserService userService) {
        this.userService = userService;
        this.scanner = scanner;
    }

    public void registerUser() {
        System.out.print("Введите имя пользователя для регистрации: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        userService.saveUser(username, password);
    }

    public User loginUser() {
        System.out.print("Введите имя пользователя для входа: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String loginPassword = scanner.nextLine();
        User user = userService.getUser(loginUsername, loginPassword);
        if (user == null) {
            System.out.println("Пользователь не найден");
            return null;
        }

        return user;
    }
}
