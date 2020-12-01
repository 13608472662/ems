package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

   /* public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(String name) {
        return userDao.login(name);
    }

    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.register(user);
    }
}
