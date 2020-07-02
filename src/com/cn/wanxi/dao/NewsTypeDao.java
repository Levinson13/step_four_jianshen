package com.cn.wanxi.dao;

import com.cn.wanxi.model.NewsTypeModel;

import java.util.List;

public interface NewsTypeDao {

    int add(NewsTypeModel newsTypeModel);

    List<NewsTypeModel> findAll();

}
