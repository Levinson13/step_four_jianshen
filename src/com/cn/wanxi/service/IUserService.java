package com.cn.wanxi.service;

public interface IUserService {

    int login(String username,String password);

    int register(String username,String password);
}
