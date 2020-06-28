package com.cn.wanxi.service;

import com.cn.wanxi.model.NavModel;

import java.util.List;

public interface INavService {

    int add(NavModel navModel);

    int update(NavModel navModel);

    int delete(Integer id);

    NavModel getOneNavModel(Integer id);

    List<NavModel> getNavList();

}
