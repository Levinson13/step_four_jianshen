package com.cn.wanxi.service;

import com.cn.wanxi.dto.AboutDto;
import com.cn.wanxi.dto.AboutFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.AboutModel;
import com.cn.wanxi.model.CoachModel;

import java.util.List;

public interface IAboutService {
    int add(AboutModel aboutModel);

    int update(AboutModel aboutModel);

    int delete(Integer id);

    AboutModel getOneAboutModel(Integer id);

    ResultDto getAboutList();

    ResultDto findAboutListByCondition(AboutFindDto condition, PageDto pageDto);

    AboutDto getAboutDto();
}
