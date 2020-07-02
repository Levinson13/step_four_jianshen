package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NewsTypeDao;
import com.cn.wanxi.dao.ProductTypeDao;
import com.cn.wanxi.dao.impl.NewsTypeDaoImpl;
import com.cn.wanxi.dao.impl.ProductTypeDaoImpl;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.model.ProductTypeModel;
import com.cn.wanxi.service.INewsTypeService;
import com.cn.wanxi.service.IProductService;
import com.cn.wanxi.service.IProductTypeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductTypeServiceImpl implements IProductTypeService {

    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();

    public int add(ProductTypeModel productTypeModel) {
        productTypeModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return productTypeDao.add(productTypeModel);
    }

    public List<ProductTypeModel> findAll() {
        return productTypeDao.findAll();
    }
}
