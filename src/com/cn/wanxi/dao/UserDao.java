package com.cn.wanxi.dao;

public interface UserDao {

    int login(String username , String password);

    int register(String username, String password);

    int findUser(String username);

}
