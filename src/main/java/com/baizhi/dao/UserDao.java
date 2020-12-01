package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
    public User login(String name);

    public void register(User user);
}
