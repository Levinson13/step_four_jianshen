package com.cn.wanxi.dao;

import com.cn.wanxi.model.CoachPostModel;

import java.util.List;

public interface CoachPostDao {

    int add(CoachPostModel coachPostModel);

    int del(Integer id);

    List<CoachPostModel> findAll();

}
