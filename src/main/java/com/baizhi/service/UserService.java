package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
    public User login(String name);

    public void register(User user);
}

