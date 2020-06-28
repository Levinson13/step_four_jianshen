package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CoachDao;
import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.impl.CoachDaoImpl;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dto.CoachDto;
import com.cn.wanxi.dto.CoachFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.CoachModel;
import com.cn.wanxi.service.ICoachService;

import java.util.Date;
import java.util.List;

public class CoachServiceImpl implements ICoachService {

    private CoachDao coachDao = new CoachDaoImpl();

    private NavDao navDao = new NavDaoImpl();

    @Override
    public int add(CoachModel coachModel) {
        return coachDao.add(coachModel);
    }

    @Override
    public int update(CoachModel coachModel) {
        return coachDao.update(coachModel);
    }

    @Override
    public int delete(Integer id) {
        return coachDao.delete(id);
    }

    @Override
    public CoachModel getOneCoachModel(Integer id) {
        return coachDao.getOneCoachModel(id);
    }

    @Override
    public ResultDto getCoachList() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCount(coachDao.findAllCoachCount());
        resultDto.setObject(coachDao.getCoachList());
        return resultDto;
    }

    @Override
    public ResultDto findCoachListByCondition(CoachFindDto condition, PageDto pageDto) {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(coachDao.findCoachListByCondition(condition,pageDto));
        resultDto.setCount(coachDao.findAllCoachCount());
        return resultDto;
    }

    @Override
    public CoachDto getCoachDto() {
        CoachDto coachDto = new CoachDto();
        coachDto.setCoachModelList(coachDto.getCoachModelList());
        coachDto.setNavModelList(navDao.getNavList());
        return coachDto;
    }
}
