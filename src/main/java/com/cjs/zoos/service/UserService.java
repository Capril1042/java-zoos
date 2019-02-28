package com.cjs.zoos.service;

import com.cjs.zoos.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
