package com.cn.wanxi.dto;

import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.CoachPostModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.NewsTypeModel;

import java.util.List;

public class NewsBackDto {
    private NewsModel newsModel;

    private String type;

    private List<NewsTypeModel> newsTypeModelList;

    public NewsModel getNewsModel() {
        return newsModel;
    }

    public void setNewsModel(NewsModel newsModel) {
        this.newsModel = newsModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NewsTypeModel> getNewsTypeModelList() {
        return newsTypeModelList;
    }

    public void setNewsTypeModelList(List<NewsTypeModel> newsTypeModelList) {
        this.newsTypeModelList = newsTypeModelList;
    }
}
