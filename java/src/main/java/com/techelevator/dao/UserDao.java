package com.techelevator.dao;

import com.techelevator.model.LoginDto;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {




    User getUserById(int userId);

    List<User> findAll();

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    void newUserChangePassword(String username, String newPassword);
}
