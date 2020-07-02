package com.cn.wanxi.dto;

import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.model.ProductTypeModel;

import java.util.List;

public class ProductBackDto {
    private ProductModel productModel;

    private String type;

    private List<ProductTypeModel> productTypeModelList;

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ProductTypeModel> getProductTypeModelList() {
        return productTypeModelList;
    }

    public void setProductTypeModelList(List<ProductTypeModel> productTypeModelList) {
        this.productTypeModelList = productTypeModelList;
    }
}
