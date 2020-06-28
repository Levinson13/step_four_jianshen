package com.cn.wanxi.model;

import java.util.Date;

public class CoachModel {
    private Integer id;

    private String coachName;

    private Integer coachPost;

    private String coachImg;

    private String createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getCoachPost() {
        return coachPost;
    }

    public void setCoachPost(Integer coachPost) {
        this.coachPost = coachPost;
    }

    public String getCoachImg() {
        return coachImg;
    }

    public void setCoachImg(String coachImg) {
        this.coachImg = coachImg;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
