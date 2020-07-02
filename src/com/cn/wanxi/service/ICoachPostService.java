package com.cn.wanxi.service;

import com.cn.wanxi.model.CoachPostModel;

import java.util.List;

public interface ICoachPostService {

    int add(CoachPostModel coachPostModel);

    int del(Integer id);

    List<CoachPostModel> findAll();

}
