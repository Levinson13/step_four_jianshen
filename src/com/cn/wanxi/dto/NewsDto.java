package com.cn.wanxi.dto;

import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.NewsTypeModel;

import java.util.List;

public class NewsDto {

    private List<NewsTypeModel> newsTypeModelList;

    private List<NavModel> navModels;

    private List<NewsModel> newsModelList;

    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    public void setNewsModelList(List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
    }


    public List<NewsTypeModel> getNewsTypeModelList() {
        return newsTypeModelList;
    }

    public void setNewsTypeModelList(List<NewsTypeModel> newsTypeModelList) {
        this.newsTypeModelList = newsTypeModelList;
    }

    public List<NavModel> getNavModels() {
        return navModels;
    }

    public void setNavModels(List<NavModel> navModels) {
        this.navModels = navModels;
    }
}
