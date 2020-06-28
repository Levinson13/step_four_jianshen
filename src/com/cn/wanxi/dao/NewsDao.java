package com.cn.wanxi.dao;

import com.cn.wanxi.dto.NewsFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.NewsModel;

import java.util.List;

public interface NewsDao {

    int add(NewsModel newsModel);

    int update(NewsModel newsModel);

    int delete(Integer id);

    NewsModel getOneNewsModel(Integer id);

    List<NewsModel> getNewsList();

    List<NewsModel> findNewsListByCondition(NewsFindDto newsModel, PageDto pageDto);

    int findAllNewsCount();
}
