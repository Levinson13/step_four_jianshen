package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.dao.NewsTypeDao;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dao.impl.NewsDaoImpl;
import com.cn.wanxi.dao.impl.NewsTypeDaoImpl;
import com.cn.wanxi.dto.NewsDto;
import com.cn.wanxi.dto.NewsFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.INewsService;

import java.util.List;

public class NewsServiceImpl implements INewsService {

    private NewsDao newsDao = new NewsDaoImpl();

    private NavDao navDao = new NavDaoImpl();

    private NewsTypeDao newsTypeDao = new NewsTypeDaoImpl();

    @Override
    public int add(NewsModel newsModel) {
        return newsDao.add(newsModel);
    }

    @Override
    public int update(NewsModel newsModel) {
        return newsDao.update(newsModel);
    }

    @Override
    public int delete(Integer id) {
        return newsDao.delete(id);
    }

    @Override
    public NewsModel getOneNews(Integer id) {
        return newsDao.getOneNewsModel(id);
    }

    @Override
    public ResultDto getNewsList() {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(newsDao.getNewsList());
        resultDto.setCount(newsDao.findAllNewsCount());
        resultDto.setList(newsTypeDao.findAll());
        return resultDto;
    }

    @Override
    public ResultDto findCoachListByCondition(NewsFindDto condition, PageDto pageDto) {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(newsDao.findNewsListByCondition(condition,pageDto));
        resultDto.setCount(newsDao.findAllNewsCount());
        resultDto.setList(newsTypeDao.findAll());
        return resultDto;
    }

    @Override
    public NewsDto getNewsDto() {
        NewsDto newsDto = new NewsDto();
        newsDto.setNavModels(navDao.getNavList());
        newsDto.setNewsModelList(newsDao.getAllNews());
        newsDto.setNewsTypeModelList(newsTypeDao.findAll());
        return newsDto;
    }


}
