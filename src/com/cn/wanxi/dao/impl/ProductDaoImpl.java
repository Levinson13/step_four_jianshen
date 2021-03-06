package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.ProductDao;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ProductBackDto;
import com.cn.wanxi.dto.ProductDto;
import com.cn.wanxi.dto.ProductFindDto;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.util.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private Connection connection = null;

    private PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    @Override
    public int add(ProductModel productModel) {
//        String sql = "INSERT INTO `jianshen`.`tb_product` (`product_name`, `product_type`, `product_img`, `product_price`, `create_time`) VALUES ('fojoj', 'sdad', 'sdad', 'sdads', 'adsad');\n";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into tb_product values (null" + ",'" + productModel.getProductName() +
                "','" + productModel.getProductType() +
                "','" + productModel.getProductImg() +
                "'," + productModel.getProductPrice() +
                ",'" + productModel.getCreateDate()  + "');";
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int update(ProductModel productModel) {
        String sql = "update tb_product set product_name='" + productModel.getProductName() +
                "',product_type=" + productModel.getProductType() +
                ",product_price=" + productModel.getProductPrice();
        if (productModel.getProductImg() != null && !"".equals(productModel.getProductImg())) {
            sql += ",product_img='" + productModel.getProductImg() + "'";
        }
        sql += " where id = " + productModel.getId();
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from tb_product where id = " + id;
        return JDBC.excuteUpdate(sql);
    }

    @Override
    public ProductModel getOneProductModel(Integer id) {
        String sql = "select * from tb_product where id=" + id;
        resultSet = JDBC.excuteQuery(sql);
        ProductModel productModel = new ProductModel();
        try {
            while (resultSet.next()) {
                productModel.setId(resultSet.getInt("id"));
                productModel.setProductName(resultSet.getString("product_name"));
                productModel.setProductType(resultSet.getInt("product_type"));
                productModel.setProductImg(resultSet.getString("product_img"));
                productModel.setProductPrice(resultSet.getDouble("product_price"));
                productModel.setCreateDate(resultSet.getString("create_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productModel;
    }

    @Override
    public List<ProductBackDto> getProductList() {
        List<ProductBackDto> productBackDtoList = new ArrayList<>();
        String sql = "select tp.*,tpt.type from tb_product tp ,tb_product_type tpt where tp.product_type = tpt.id";
        resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                ProductBackDto productBackDto = new ProductBackDto();
                ProductModel productModel = new ProductModel();
                productModel.setId(resultSet.getInt("id"));
                productModel.setProductName(resultSet.getString("product_name"));
                productModel.setProductType(resultSet.getInt("product_type"));
                productModel.setProductImg(resultSet.getString("product_img"));
                productModel.setProductPrice(resultSet.getDouble("product_price"));
                productModel.setCreateDate(resultSet.getString("create_time"));

                productBackDto.setProductModel(productModel);
                productBackDto.setType(resultSet.getString("type"));
                productBackDtoList.add(productBackDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productBackDtoList;
    }

    public int findAllProductCount() {
        String sql = "select count(id) as count from tb_product";
        int count = 0;
        resultSet = JDBC.excuteQuery(sql);
        try {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);
        return count;
    }

    @Override
    public List<ProductModel> getAllProduct() {
        String sql = "select * from tb_product";
        ResultSet resultSet = JDBC.excuteQuery(sql);
        List<ProductModel> productModelList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(resultSet.getInt("id"));
                productModel.setProductName(resultSet.getString("product_name"));
                productModel.setProductPrice(resultSet.getDouble("product_price"));
                productModel.setProductImg(resultSet.getString("product_img"));
                productModel.setProductType(resultSet.getInt("product_type"));
                productModel.setCreateDate(resultSet.getString("create_time"));
                productModelList.add(productModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productModelList;
    }

    @Override
    public List<ProductBackDto> findProductListByCondition(ProductFindDto productFindDto, PageDto pageDto) {
        String sql = "select tp.*,tpt.type from tb_product tp ,tb_product_type tpt where tp.product_type = tpt.id";
        if (productFindDto.getName() != null && !"".equals(productFindDto.getName())) {
            sql += " and product_name like '%" + productFindDto.getName() + "%'";
        }
        if (productFindDto.getType() != null && !"".equals(productFindDto.getType())) {
            sql += " and product_type like '%" + productFindDto.getType() + "%'";
        }
        if (productFindDto.getPrice() != null && "".equals(productFindDto.getPrice())) {
            sql += " and product_price like '%" + productFindDto.getPrice() + "%'";
        }
        sql += " limit " + (pageDto.getPageNum() - 1) * pageDto.getPageSize() + "," + pageDto.getPageSize();
        resultSet = JDBC.excuteQuery(sql);
        List<ProductBackDto> productBackDtoList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                ProductBackDto productBackDto = new ProductBackDto();
                ProductModel productModel = new ProductModel();
                productModel.setId(resultSet.getInt("id"));
                productModel.setProductName(resultSet.getString("product_name"));
                productModel.setProductType(resultSet.getInt("product_type"));
                productModel.setProductImg(resultSet.getString("product_img"));
                productModel.setProductPrice(resultSet.getDouble("product_price"));
                productModel.setCreateDate(resultSet.getString("create_time"));

                productBackDto.setProductModel(productModel);
                productBackDto.setType(resultSet.getString("type"));
                productBackDtoList.add(productBackDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productBackDtoList;
    }



}
