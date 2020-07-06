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
import com.cn.wanxi.util.SetNavData;
import com.cn.wanxi.util.SetNewsData;
import com.cn.wanxi.util.SetNewsTypeData;
import redis.clients.jedis.Jedis;

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
        Jedis jedis = new Jedis();
        long navLength = jedis.llen("navId");
        long newsLength = jedis.llen("newsId");
        long newsTypeLength = jedis.llen("newsTypeId");
        if (navLength > 0 && newsLength > 0 && newsTypeLength > 0) {
            newsDto = setNewsDataFromRedis(navLength,newsLength,newsTypeLength,jedis);
            System.out.println("这是新闻的缓存");
        } else {
            newsDto = setNewsDtoFromDataBase(navLength,newsLength,newsTypeLength);
            System.out.println("这是新闻的数据库");
        }
        return newsDto;
    }

    public NewsDto setNewsDataFromRedis(long navLength, long newsLength,long newsTypeLength, Jedis jedis){
        NewsDto newsDto = new NewsDto();
        newsDto.setNavModels(SetNavData.setDataFromRedis(jedis,navLength));
        newsDto.setNewsModelList(SetNewsData.setDataFromRedis(jedis, newsLength));
        newsDto.setNewsTypeModelList(SetNewsTypeData.setNewsTypeFromRedis(jedis,newsTypeLength));
        return newsDto;
    }


    public NewsDto setNewsDtoFromDataBase(long navLength, long newsLength,long newsTypeLength){
        NewsDto newsDto = new NewsDto();
        Jedis jedis = new Jedis();
        if (navLength <= 0) {
            newsDto.setNavModels(SetNavData.setDataFromDataBase(navDao.getNavList(), jedis));
        } else {
            newsDto.setNavModels(navDao.getNavList());
        }

        if (newsLength <= 0) {
            newsDto.setNewsModelList(SetNewsData.setDataFromDataBase(newsDao.getNewsList(), jedis));
        } else {
            newsDto.setNewsModelList(newsDao.getNewsList());
        }

        if (newsTypeLength <= 0) {
            newsDto.setNewsTypeModelList(SetNewsTypeData.setNewsTypeFromDataBase(newsTypeDao.findAll(), jedis));
        } else {
            newsDto.setNewsTypeModelList(newsTypeDao.findAll());
        }
        return newsDto;
    }


}
