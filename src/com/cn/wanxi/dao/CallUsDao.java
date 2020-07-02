package com.cn.wanxi.dao;

import com.cn.wanxi.model.CallUsModel;

import java.util.List;

public interface CallUsDao {

    int add(CallUsModel callUsModel);

    List<CallUsModel> getCallUsList();

}
