package com.cn.wanxi.dto;

import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.CoachPostModel;

import java.util.List;

public class CoachBackDto {
    private CoachModel coachModel;

    private String post;

    private List<CoachPostModel> coachPostModelList;

    public CoachModel getCoachModel() {
        return coachModel;
    }

    public void setCoachModel(CoachModel coachModel) {
        this.coachModel = coachModel;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<CoachPostModel> getCoachPostModelList() {
        return coachPostModelList;
    }

    public void setCoachPostModelList(List<CoachPostModel> coachPostModelList) {
        this.coachPostModelList = coachPostModelList;
    }
}
