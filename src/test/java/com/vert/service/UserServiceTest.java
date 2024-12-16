package com.vert.service;

import com.vert.dao.UserDao;
import com.vert.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    void saveUserTest() {
        userService.saveUser("Ivan", "12345");

        Mockito.verify(userDao).saveUser("Ivan", "12345");
    }

    @Test
    void readUserTest() {
        User expectedUser = new User("Sergey", "qwerty");
        Mockito.when(userDao.getUser("Sergey", "qwerty")).thenReturn(expectedUser);

        User actualUser = userService.getUser("Sergey", "qwerty");

        Assertions.assertEquals(expectedUser, actualUser);
    }
}