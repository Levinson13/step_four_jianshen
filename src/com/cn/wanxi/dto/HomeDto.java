package com.cn.wanxi.dto;

import com.cn.wanxi.model.*;

import java.util.List;

public class HomeDto {

    private List<NavModel> navModelList;

    private List<NewsBackDto> newsModelList;

    private List<CoachBackDto> coachModelList;

    private List<StudentModel> studentModelList;

    private List<AboutModel> aboutModelList;

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }

    public List<NewsBackDto> getNewsModelList() {
        return newsModelList;
    }

    public void setNewsModelList(List<NewsBackDto> newsModelList) {
        this.newsModelList = newsModelList;
    }

    public List<CoachBackDto> getCoachModelList() {
        return coachModelList;
    }

    public void setCoachModelList(List<CoachBackDto> coachModelList) {
        this.coachModelList = coachModelList;
    }

    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    public List<AboutModel> getAboutModelList() {
        return aboutModelList;
    }

    public void setAboutModelList(List<AboutModel> aboutModelList) {
        this.aboutModelList = aboutModelList;
    }
}
