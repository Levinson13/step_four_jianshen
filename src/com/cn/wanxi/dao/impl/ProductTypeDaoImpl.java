package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NewsTypeDao;
import com.cn.wanxi.dao.ProductTypeDao;
import com.cn.wanxi.model.NewsTypeModel;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.model.ProductTypeModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDaoImpl implements ProductTypeDao {

    @Override
    public int add(ProductTypeModel productTypeModel) {
        String sql = "insert into tb_product_type values(null,'"+ productTypeModel.getType() +

                "'," + productTypeModel.getStatus() +

                ",'" + productTypeModel.getCreateTime()+"')";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public List<ProductTypeModel> findAll() {
        String sql = "select * from tb_product_type";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<ProductTypeModel> productTypeModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ProductTypeModel productTypeModel = new ProductTypeModel();
                productTypeModel.setId(resultSet.getInt("id"));
                productTypeModel.setType(resultSet.getString("type"));
                productTypeModel.setStatus(resultSet.getInt("status"));
                productTypeModel.setCreateTime(resultSet.getString("create_time"));
                productTypeModelList.add(productTypeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypeModelList;
    }
}
