package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CallUsDao;
import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.impl.CallUsDaoImpl;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dto.CallUsDto;
import com.cn.wanxi.model.CallUsModel;
import com.cn.wanxi.service.ICallUsService;

import java.util.List;

public class CallUsServiceImpl implements ICallUsService {

    private CallUsDao callUsDao = new CallUsDaoImpl();

    private NavDao navDao = new NavDaoImpl();

    @Override
    public int add(CallUsModel callUsModel) {
        return callUsDao.add(callUsModel);
    }

    @Override
    public List<CallUsModel> getCallUsList() {
        return callUsDao.getCallUsList();
    }

    @Override
    public CallUsDto getCallUsDto() {
        CallUsDto callUsDto = new CallUsDto();
        callUsDto.setNavModelList(navDao.getNavList());
        callUsDto.setCallUsModelList(callUsDao.getCallUsList());
        return callUsDto;
    }
}
