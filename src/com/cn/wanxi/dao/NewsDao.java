package com.cn.wanxi.dao;

import com.cn.wanxi.dto.NewsBackDto;
import com.cn.wanxi.dto.NewsDto;
import com.cn.wanxi.dto.NewsFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.NewsModel;

import java.util.List;

public interface NewsDao {

    int add(NewsModel newsModel);

    int update(NewsModel newsModel);

    int delete(Integer id);

    NewsModel getOneNewsModel(Integer id);

    List<NewsBackDto> getNewsList();

    List<NewsBackDto> findNewsListByCondition(NewsFindDto newsModel, PageDto pageDto);

    int findAllNewsCount();

    List<NewsModel> getAllNews();

}
