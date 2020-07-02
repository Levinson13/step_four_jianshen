package com.cn.wanxi.dao;

import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.model.ProductTypeModel;

import java.util.List;

public interface ProductTypeDao {

    int add(ProductTypeModel productTypeModel);

    List<ProductTypeModel> findAll();

}
