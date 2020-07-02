package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CoachPostDao;
import com.cn.wanxi.dao.impl.CoachPostDaoImpl;
import com.cn.wanxi.model.CoachPostModel;
import com.cn.wanxi.service.ICoachPostService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CoachPostServiceImpl implements ICoachPostService {

    private CoachPostDao coachPostDao = new CoachPostDaoImpl();

    @Override
    public int add(CoachPostModel coachPostModel) {
        coachPostModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return coachPostDao.add(coachPostModel);
    }

    @Override
    public int del(Integer id) {
        return coachPostDao.del(id);
    }

    @Override
    public List<CoachPostModel> findAll() {
        return coachPostDao.findAll();
    }
}
