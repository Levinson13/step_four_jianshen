package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.AboutDao;
import com.cn.wanxi.dao.impl.AboutDaoImpl;
import com.cn.wanxi.dto.AboutFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.service.IAboutService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AboutServiceImpl implements IAboutService {

    private AboutDao aboutDao = new AboutDaoImpl();

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
}
