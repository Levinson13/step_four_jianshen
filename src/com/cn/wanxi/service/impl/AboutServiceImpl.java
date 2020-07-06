package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.AboutDao;
import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.StudentDao;
import com.cn.wanxi.dao.impl.AboutDaoImpl;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dao.impl.StudentDaoImpl;
import com.cn.wanxi.dto.AboutDto;
import com.cn.wanxi.dto.AboutFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.service.IAboutService;
import com.cn.wanxi.util.SetAboutData;
import com.cn.wanxi.util.SetNavData;
import com.cn.wanxi.util.SetStudentData;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AboutServiceImpl implements IAboutService {

    private AboutDao aboutDao = new AboutDaoImpl();

    private StudentDao studentDao = new StudentDaoImpl();

    private NavDao navDao = new NavDaoImpl();

    @Override
    public int add(AboutModel aboutModel) {
        aboutModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return aboutDao.add(aboutModel);
    }

    @Override
    public int update(AboutModel aboutModel) {
        return aboutDao.update(aboutModel);
    }

    @Override
    public int delete(Integer id) {
        return aboutDao.delete(id);
    }

    @Override
    public AboutModel getOneAboutModel(Integer id) {
        return aboutDao.getOneAboutModel(id);
    }

    @Override
    public ResultDto getAboutList() {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(aboutDao.getAboutList());
        resultDto.setCount(aboutDao.findAllAboutCount());
        return resultDto;
    }

    @Override
    public ResultDto findAboutListByCondition(AboutFindDto condition, PageDto pageDto) {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(aboutDao.findAboutListByCondition(condition,pageDto));
        resultDto.setCount(aboutDao.findAllAboutCount());
        return resultDto;
    }

    public AboutDto getAboutDto(){
        AboutDto aboutDto = new AboutDto();
        Jedis jedis = new Jedis();
        long navLength = jedis.llen("navId");
        long aboutLength = jedis.llen("aboutId");
        long studentLength = jedis.llen("studentId");
        if (navLength > 0 && aboutLength > 0 && studentLength > 0) {
            // 缓存
            aboutDto = setAboutDtoFromRedis(navLength, aboutLength, studentLength, jedis);
            System.out.println("这是about的缓存");
        } else {
            //数据库
            aboutDto = setAboutDtoFromDataBase(navLength, aboutLength, studentLength);
            System.out.println("这是about的数据库");
        }
        return aboutDto;
    }
    public AboutDto setAboutDtoFromRedis(long navLength,long aboutLength,long studentLength,Jedis jedis){
        AboutDto aboutDto = new AboutDto();
        aboutDto.setNavModelList(SetNavData.setDataFromRedis(jedis,navLength));
        aboutDto.setAboutModelList(SetAboutData.setDataFromRedis(jedis,aboutLength));
        aboutDto.setStudentModelList(SetStudentData.setDataFromRedis(jedis,studentLength));
        return aboutDto;
    }

    // 从数据库中取出数据并且存入到缓存当中
    public AboutDto setAboutDtoFromDataBase(long navLength,long aboutLength,long studentLength) {
        Jedis jedis = new Jedis();
        AboutDto aboutDto = new AboutDto();
        if (navLength <= 0) {
            aboutDto.setNavModelList(SetNavData.setDataFromDataBase(navDao.getNavList(), jedis));
        } else {
            aboutDto.setNavModelList(navDao.getNavList());
        }

        if (aboutLength <= 0) {
            aboutDto.setAboutModelList(SetAboutData.setDataFromDataBase(aboutDao.getAboutList(), jedis));
        } else {
            aboutDto.setAboutModelList(aboutDao.getAboutList());
        }

        if (studentLength <= 0) {
            aboutDto.setStudentModelList(SetStudentData.setDataFromDataBase(studentDao.getStudentList(), jedis));
        } else {
            aboutDto.setStudentModelList(studentDao.getStudentList());
        }
        return aboutDto;
    }
}
