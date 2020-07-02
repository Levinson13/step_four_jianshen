package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.ProductDao;
import com.cn.wanxi.dao.ProductTypeDao;
import com.cn.wanxi.dao.impl.NavDaoImpl;
import com.cn.wanxi.dao.impl.ProductDaoImpl;
import com.cn.wanxi.dao.impl.ProductTypeDaoImpl;
import com.cn.wanxi.dto.PageDto;
import com.cn.wanxi.dto.ProductDto;
import com.cn.wanxi.dto.ProductFindDto;
import com.cn.wanxi.dto.ResultDto;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.model.ProductTypeModel;
import com.cn.wanxi.service.IProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    private ProductDao productDao = new ProductDaoImpl();

    private NavDao navDao = new NavDaoImpl();

    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();

    @Override
    public int add(ProductModel productModel) {
        productModel.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return productDao.add(productModel);
    }

    @Override
    public int update(ProductModel productModel) {
        return productDao.update(productModel);
    }

    @Override
    public int delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public ProductModel getOneProductModel(Integer id) {
        return productDao.getOneProductModel(id);
    }

    @Override
    public ResultDto getProductList() {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(productDao.getProductList());
        resultDto.setCount(productDao.findAllProductCount());
        resultDto.setList(productTypeDao.findAll());
        return resultDto;
    }

    @Override
    public ResultDto findAllProductListByCondition(ProductFindDto condition, PageDto pageDto) {
        ResultDto resultDto = new ResultDto();
        resultDto.setObject(productDao.findProductListByCondition(condition,pageDto));
        resultDto.setCount(productDao.findAllProductCount());
        resultDto.setList(productTypeDao.findAll());
        return resultDto;
    }

    @Override
    public ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setProductModelList(productDao.getAllProduct());
        productDto.setNavModelList(navDao.getNavList());
        productDto.setProductTypeModelList(productTypeDao.findAll());
        return productDto;
    }
}
