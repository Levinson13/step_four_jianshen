package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.UserDao;
import com.cn.wanxi.dao.impl.UserDaoImpl;
import com.cn.wanxi.service.IUserService;

public class UserServiceImpl implements IUserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public int login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public int register(String username, String password) {
        if (userDao.findUser(username) == 1) {
            return userDao.register(username, password);
        }
        return 0;
    }
}
