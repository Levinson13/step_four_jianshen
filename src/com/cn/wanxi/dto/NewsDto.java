package com.cn.wanxi.dto;

import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;

import java.util.List;

public class NewsDto {
    private List<NewsModel> newsModelList;

    private List<NavModel> navModels;

    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    public void setNewsModelList(List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
    }

    public List<NavModel> getNavModels() {
        return navModels;
    }

    public void setNavModels(List<NavModel> navModels) {
        this.navModels = navModels;
    }
}
