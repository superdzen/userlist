package com.superdzen.userlist.dao;

import com.superdzen.userlist.model.User;

import java.util.List;

public interface UserDao {

    void insert(User user);

    List<User> listUsers();

    List<User> listUsers(String filter);

}
