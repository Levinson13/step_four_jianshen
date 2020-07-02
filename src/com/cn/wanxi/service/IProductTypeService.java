package com.cn.wanxi.service;

import com.cn.wanxi.model.ProductTypeModel;

import java.util.List;

public interface IProductTypeService {

    int add(ProductTypeModel productTypeModel);

    List<ProductTypeModel> findAll();

}
