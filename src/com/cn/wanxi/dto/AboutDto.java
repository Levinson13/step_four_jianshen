package com.cn.wanxi.dto;

import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.StudentModel;

import java.util.List;

public class AboutDto {

    private List<NavModel> navModelList;

    private List<AboutModel> aboutModelList;

    private List<StudentModel> studentModelList;

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }

    public List<AboutModel> getAboutModelList() {
        return aboutModelList;
    }

    public void setAboutModelList(List<AboutModel> aboutModelList) {
        this.aboutModelList = aboutModelList;
    }

    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }
}
