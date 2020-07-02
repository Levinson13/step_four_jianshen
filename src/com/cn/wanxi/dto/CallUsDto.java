package com.cn.wanxi.dto;

import com.cn.wanxi.model.CallUsModel;
import com.cn.wanxi.model.NavModel;

import java.util.List;

public class CallUsDto {
    private List<NavModel> navModelList;

    private List<CallUsModel> callUsModelList;

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }

    public List<CallUsModel> getCallUsModelList() {
        return callUsModelList;
    }

    public void setCallUsModelList(List<CallUsModel> callUsModelList) {
        this.callUsModelList = callUsModelList;
    }
}
