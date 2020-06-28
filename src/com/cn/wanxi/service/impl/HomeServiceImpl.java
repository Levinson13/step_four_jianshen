package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CoachDao;
import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.dao.StudentDao;
import com.cn.wanxi.dao.impl.CoachDaoImpl;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dao.impl.NewsDaoImpl;
import com.cn.wanxi.dao.impl.StudentDaoImpl;
import com.cn.wanxi.dto.HomeDto;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.IHomeService;

import java.util.List;

public class HomeServiceImpl implements IHomeService {

    private NavDao navDao = new NavDaoImpl();

    private CoachDao coachDao = new CoachDaoImpl();

    private StudentDao studentDao = new StudentDaoImpl();

    private NewsDao newsDao = new NewsDaoImpl();


    @Override
    public HomeDto getHomeDto() {
        HomeDto homeDto = new HomeDto();
        homeDto.setCoachModelList(coachDao.getCoachList());
        homeDto.setNavModelList(navDao.getNavList());
        homeDto.setNewsModelList(newsDao.getNewsList());
        homeDto.setStudentModelList(studentDao.getStudentList());
        return homeDto;
    }


}
