package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.*;
import com.cn.wanxi.dao.impl.*;
import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.dto.HomeDto;
import com.cn.wanxi.dto.NewsDto;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.IHomeService;

import java.util.List;

public class HomeServiceImpl implements IHomeService {

    private NavDao navDao = new NavDaoImpl();

    private CoachDao coachDao = new CoachDaoImpl();

    private StudentDao studentDao = new StudentDaoImpl();

    private NewsDao newsDao = new NewsDaoImpl();

    private AboutDao aboutDao = new AboutDaoImpl();


    @Override
    public HomeDto getHomeDto() {
        HomeDto homeDto = new HomeDto();
        homeDto.setCoachModelList(coachDao.getCoachList());
        homeDto.setNavModelList(navDao.getNavList());
        homeDto.setNewsModelList(newsDao.getNewsList());
        homeDto.setStudentModelList(studentDao.getStudentList());
        homeDto.setAboutModelList(aboutDao.getAboutList());
        return homeDto;
    }


}
