package com.cn.wanxi.dto;

import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.model.ProductTypeModel;

import java.util.List;

public class ProductDto {

    private List<ProductTypeModel> productTypeModelList;

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

    public List<ProductTypeModel> getProductTypeModelList() {
        return productTypeModelList;
    }

    public void setProductTypeModelList(List<ProductTypeModel> productTypeModelList) {
        this.productTypeModelList = productTypeModelList;
    }
}
