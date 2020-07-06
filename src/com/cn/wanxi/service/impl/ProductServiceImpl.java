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
import com.cn.wanxi.util.SetNavData;
import com.cn.wanxi.util.SetProductData;
import com.cn.wanxi.util.SetProductTypeDate;
import redis.clients.jedis.Jedis;

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
        Jedis jedis = new Jedis();
        long navLength = jedis.llen("navId");
        long productLength = jedis.llen("productId");
        long productTypeLength = jedis.llen("productTypeId");
        if (navLength > 0 && productLength > 0 && productTypeLength > 0) {
            productDto = setDataFromRedis(navLength, productLength, productTypeLength, jedis);
            System.out.println("这是产品的缓存");
        } else {
            productDto = setDataFromDataBase(navLength, productLength, productTypeLength);
            System.out.println("这是产品的数据库");
        }
        return productDto;
    }

    public ProductDto setDataFromRedis(long navLength,long productLength,long productTypeLength,Jedis jedis){
        ProductDto productDto = new ProductDto();
        productDto.setNavModelList(SetNavData.setDataFromRedis(jedis,navLength));
        productDto.setProductModelList(SetProductData.setDataFromRedis(jedis,productLength));
        productDto.setProductTypeModelList(SetProductTypeDate.setProductTypeFromRedis(jedis,productTypeLength));
        return productDto;
    }

    public ProductDto setDataFromDataBase(long navLength,long productLength,long productTypeLength){
        ProductDto productDto = new ProductDto();
        Jedis jedis = new Jedis();
        if (navLength <= 0) {
            productDto.setNavModelList(SetNavData.setDataFromDataBase(navDao.getNavList(), jedis));
        } else {
            productDto.setNavModelList(navDao.getNavList());
        }

        if (productLength <= 0) {
            productDto.setProductModelList(SetProductData.setDataFromDataBase(productDao.getProductList(), jedis));
        } else {
            productDto.setProductModelList(productDao.getProductList());
        }

        if (productTypeLength <= 0) {
            productDto.setProductTypeModelList(SetProductTypeDate.setProductTypeFromDataBase(productTypeDao.findAll(), jedis));
        } else {
            productDto.setProductTypeModelList(productTypeDao.findAll());
        }

        return productDto;
    }
}
