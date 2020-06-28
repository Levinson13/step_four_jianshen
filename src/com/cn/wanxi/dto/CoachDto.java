package com.cn.wanxi.dto;

import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.NavModel;

import java.util.List;

public class CoachDto {
    private List<NavModel> navModelList;

    private List<CoachModel> coachModelList;

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }

    public List<CoachModel> getCoachModelList() {
        return coachModelList;
    }

    public void setCoachModelList(List<CoachModel> coachModelList) {
        this.coachModelList = coachModelList;
    }
}
