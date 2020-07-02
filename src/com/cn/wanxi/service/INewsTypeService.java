package com.cn.wanxi.service;

import com.cn.wanxi.model.NewsTypeModel;

import java.util.List;

public interface INewsTypeService {

    int add(NewsTypeModel newsTypeModel);

    List<NewsTypeModel> findAll();
}
