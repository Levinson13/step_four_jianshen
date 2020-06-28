package com.cn.wanxi.service;

import com.cn.wanxi.dto.NewsDto;
import com.cn.wanxi.dto.NewsFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.NewsModel;

import java.util.List;

public interface INewsService {
    int add(NewsModel newsModel);

    int update(NewsModel newsModel);

    int delete(Integer id);

    NewsModel getOneNews(Integer id);

    ResultDto getNewsList();

    ResultDto findCoachListByCondition(NewsFindDto condition, PageDto pageDto);

    NewsDto getNewsDto();
}
