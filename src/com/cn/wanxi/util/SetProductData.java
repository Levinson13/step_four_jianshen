package com.cn.wanxi.util;

import com.cn.wanxi.dto.ProductBackDto;
import com.cn.wanxi.dto.ProductDto;
import com.cn.wanxi.model.ProductModel;
import redis.clients.jedis.Jedis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SetProductData {
    public static List<ProductBackDto> setDataFromRedis(Jedis jedis,long productLength){
        List<String> productId = jedis.lrange("productId",0,productLength);
        List<String> productName = jedis.lrange("productName", 0, productLength);
        List<String> productImg = jedis.lrange("productImg", 0, productLength);
        List<String> productType = jedis.lrange("productType", 0, productLength);
        List<String> productPrice = jedis.lrange("productPrice", 0, productLength);
        List<String> productCreateTime = jedis.lrange("productCreateTime", 0, productLength);
        List<ProductBackDto> productBackDtoList = new ArrayList<>();
        for (int i = 0; i < productLength; i++) {
            ProductBackDto productBackDto = new ProductBackDto();
            ProductModel productModel = new ProductModel();
            productModel.setId(Integer.parseInt(productId.get(i)));
            productModel.setProductName(productName.get(i));
            productModel.setProductImg(productImg.get(i));
            productModel.setProductPrice(Double.parseDouble(productPrice.get(i)));
            productModel.setCreateDate(productCreateTime.get(i));
            productBackDto.setProductModel(productModel);
            productBackDto.setType(productType.get(i));
            productBackDtoList.add(productBackDto);
        }
        return productBackDtoList;
    }

    public static List<ProductBackDto> setDataFromDataBase(List<ProductBackDto> productBackDtoList, Jedis jedis){
        for (int i = 0; i < productBackDtoList.size(); i++) {
            jedis.rpush("productId", productBackDtoList.get(i).getProductModel().getId().toString());
            jedis.rpush("productName", productBackDtoList.get(i).getProductModel().getProductName());
            jedis.rpush("productImg", productBackDtoList.get(i).getProductModel().getProductImg());
//            jedis.rpush("productType", productBackDtoList.get(i).getProductModel().getProductType().toString());
            jedis.rpush("productPrice", productBackDtoList.get(i).getProductModel().getProductPrice().toString());
            jedis.rpush("productCreateTime", productBackDtoList.get(i).getProductModel().getCreateDate());
            jedis.rpush("productType", productBackDtoList.get(i).getType());
        }
        return productBackDtoList;
    }
}
