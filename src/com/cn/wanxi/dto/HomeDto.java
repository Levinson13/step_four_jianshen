package com.cn.wanxi.dto;

import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.StudentModel;

import java.util.List;

public class HomeDto {

    private List<NavModel> navModelList;

    private List<NewsModel> newsModelList;

    private List<CoachModel> coachModelList;

    private List<StudentModel> studentModelList;

    // 获取导航列表
    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }

    // 获取新闻列表
    public void setNewsModelList(List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
    }

    // 获取教练列表
    public void setCoachModelList(List<CoachModel> coachModelList) {
        this.coachModelList = coachModelList;
    }

    // 获取学生列表
    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    public List<CoachModel> getCoachModelList() {
        return coachModelList;
    }
}
