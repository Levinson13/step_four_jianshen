package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.*;
import com.cn.wanxi.dao.impl.*;
import com.cn.wanxi.dto.CoachBackDto;
import com.cn.wanxi.dto.HomeDto;
import com.cn.wanxi.dto.NewsBackDto;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.util.SetAboutData;
import com.cn.wanxi.util.SetCoachData;
import com.cn.wanxi.util.SetNavData;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.IHomeService;
import com.cn.wanxi.util.SetNewsData;
import redis.clients.jedis.Jedis;

import java.util.List;

public class HomeServiceImpl implements IHomeService {

    private NavDao navDao = new NavDaoImpl();

    private CoachDao coachDao = new CoachDaoImpl();

    private StudentDao studentDao = new StudentDaoImpl();

    private NewsDao newsDao = new NewsDaoImpl();

    private AboutDao aboutDao = new AboutDaoImpl();


    @Override
    public HomeDto getHomeDto() {
        Jedis jedis = new Jedis();
        HomeDto homeDto = new HomeDto();
        long navLength = jedis.llen("navId");
        long coachLength = jedis.llen("coachId");
        long newsLength = jedis.llen("newsId");
        long aboutLength = jedis.llen("aboutId");
        if (navLength > 0 && coachLength > 0 && newsLength > 0 && aboutLength > 0) {
            // 缓存数据
            homeDto = setHomeDtoFromRedis(navLength, coachLength, newsLength, aboutLength, jedis);
            System.out.println("这是home的缓存");
        } else {
            // 数据库数据
            homeDto = setHomeDtoFromDataBase(navLength, coachLength, newsLength, aboutLength);
            System.out.println("这是home的数据库");
        }
        return homeDto;
    }


    // 从缓存中取出数据
    public HomeDto setHomeDtoFromRedis(long navLength,long coachLength,long newsLength,long aboutLength,Jedis jedis){
        HomeDto homeDto = new HomeDto();
        homeDto.setNavModelList(SetNavData.setDataFromRedis(jedis, navLength));
        homeDto.setCoachModelList(SetCoachData.setDataFromRedis(jedis, coachLength));
        homeDto.setNewsModelList(SetNewsData.setDataFromRedis(jedis, newsLength));
        homeDto.setAboutModelList(SetAboutData.setDataFromRedis(jedis, aboutLength));
        return homeDto;
    }

    // 从数据库中取出数据并且存入到缓存当中
    public HomeDto setHomeDtoFromDataBase(long navLength,long coachLength,long newsLength,long aboutLength) {
        Jedis jedis = new Jedis();
        HomeDto homeDto = new HomeDto();
        // 将nav的数据存入缓存
        if (navLength <= 0) {
            homeDto.setNavModelList(SetNavData.setDataFromDataBase(navDao.getNavList(), jedis));
        } else {
            homeDto.setNavModelList(navDao.getNavList());
        }
        // 将coach的数据存入缓存
        if (coachLength <= 0) {
            homeDto.setCoachModelList(SetCoachData.setDataFromDataBase(coachDao.getCoachList(), jedis));
        } else {
            homeDto.setCoachModelList(coachDao.getCoachList());
        }
        // 将news的数据存入缓存
        if (newsLength <= 0) {
            homeDto.setNewsModelList(SetNewsData.setDataFromDataBase(newsDao.getNewsList(), jedis));
        } else {
            homeDto.setNewsModelList(newsDao.getNewsList());
        }
        // 将about的数据存入缓存
        if (aboutLength <= 0) {
            homeDto.setAboutModelList(SetAboutData.setDataFromDataBase(aboutDao.getAboutList(), jedis));
        } else {
            homeDto.setAboutModelList(aboutDao.getAboutList());
        }
        return homeDto;
    }


}
