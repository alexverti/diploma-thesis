package com.vert.service;

import com.vert.dao.UserDao;
import com.vert.model.User;

public class UserService {
    private final UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(String username, String password) {
        userDao.saveUser(username, password);
    }

    public User getUser(String loginUsername, String loginPassword) {
        return userDao.getUser(loginUsername, loginPassword);
    }
}
