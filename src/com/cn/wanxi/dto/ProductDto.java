package com.cn.wanxi.dto;

import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.ProductModel;

import java.util.List;

public class ProductDto {
    private List<ProductModel> productModelList;

    private List<NavModel> navModelList;

    public List<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }
}
