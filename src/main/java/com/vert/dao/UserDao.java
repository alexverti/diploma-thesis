package com.vert.dao;

import com.vert.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private List<User> users = new ArrayList<>();

    public void saveUser(String username, String password) {
        users.add(new User(username, password));
        System.out.println("Пользователь зарегистрирован: " + username);
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("Неверное имя пользователя или пароль.");
        return null;
    }
}
