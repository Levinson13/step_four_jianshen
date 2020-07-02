package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NewsTypeDao;
import com.cn.wanxi.dao.impl.NewsTypeDaoImpl;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.service.INewsService;
import com.cn.wanxi.service.INewsTypeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsTypeServiceImpl implements INewsTypeService {

    private NewsTypeDao newsTypeDao = new NewsTypeDaoImpl();

    @Override
    public int add(NewsTypeModel newsTypeModel) {
        newsTypeModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return newsTypeDao.add(newsTypeModel);
    }

    @Override
    public List<NewsTypeModel> findAll() {
        return newsTypeDao.findAll();
    }
}
