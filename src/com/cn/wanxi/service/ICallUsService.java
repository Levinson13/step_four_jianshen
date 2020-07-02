package com.cn.wanxi.service;

import com.cn.wanxi.dto.CallUsDto;
import com.cn.wanxi.model.CallUsModel;

import java.util.List;

public interface ICallUsService {
    int add(CallUsModel callUsModel);

    List<CallUsModel> getCallUsList();

    CallUsDto getCallUsDto();
}
