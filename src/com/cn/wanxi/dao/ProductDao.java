package com.cn.wanxi.dao;

import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ProductBackDto;
import com.cn.wanxi.dto.ProductDto;
import com.cn.wanxi.dto.ProductFindDto;
import com.cn.wanxi.model.ProductModel;

import java.util.List;

public interface ProductDao {
    int add(ProductModel productModel);

    int update(ProductModel productModel);

    int delete(Integer id);

    ProductModel getOneProductModel(Integer id);

    List<ProductBackDto> getProductList();

    List<ProductBackDto> findProductListByCondition(ProductFindDto productFindDto, PageDto pageDto);

    int findAllProductCount();

    List<ProductModel> getAllProduct();
}
