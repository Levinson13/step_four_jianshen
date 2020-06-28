package com.cn.wanxi.dao;

import com.cn.wanxi.model.NavModel;

import java.util.List;

public interface NavDao {

    int add(NavModel navModel);

    int update(NavModel navModel);

    int delete(Integer id);

    NavModel getOneNave(Integer id);

    List<NavModel> getNavList();

}
