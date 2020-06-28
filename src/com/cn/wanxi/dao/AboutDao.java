package com.cn.wanxi.dao;

import com.cn.wanxi.dto.AboutFindDto;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.model.AboutModel;

import java.util.List;

public interface AboutDao {
    int add(AboutModel aboutModel);

    int update(AboutModel aboutModel);

    int delete(Integer id);

    AboutModel getOneAboutModel(Integer id);

    List<AboutModel> getAboutList();

    List<AboutModel> findAboutListByCondition(AboutFindDto condition, PageDto pageDto);

    int findAllAboutCount();
}
