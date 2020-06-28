package com.cn.wanxi.service;

import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ProductDto;
import com.cn.wanxi.dto.ProductFindDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.ProductModel;

import java.util.List;

public interface IProductService {
    int add(ProductModel productModel);

    int update(ProductModel productModel);

    int delete(Integer id);

    ProductModel getOneProductModel(Integer id);

    ResultDto getProductList();

    ResultDto findAllProductListByCondition(ProductFindDto condition, PageDto pageDto);

    ProductDto getProductDto();
}
