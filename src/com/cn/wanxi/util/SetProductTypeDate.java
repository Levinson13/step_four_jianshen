package com.cn.wanxi.util;

import com.cn.wanxi.model.ProductTypeModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetProductTypeDate {
    public static List<ProductTypeModel> setProductTypeFromRedis(Jedis jedis , long productTypeLength){
        List<String> productTypeId = jedis.lrange("productTypeId", 0, productTypeLength);
        List<String> productTypeList = jedis.lrange("productTypeList", 0, productTypeLength);
        List<ProductTypeModel> productTypeModelList = new ArrayList<>();
        for (int i = 0; i < productTypeLength; i++) {
            ProductTypeModel productTypeModel = new ProductTypeModel();
            productTypeModel.setId(Integer.parseInt(productTypeId.get(i)));
            productTypeModel.setType(productTypeList.get(i));
            productTypeModelList.add(productTypeModel);
        }
        return productTypeModelList;
    }

    public static List<ProductTypeModel> setProductTypeFromDataBase(List<ProductTypeModel> productTypeModelList,Jedis jedis){
        for (int i = 0; i < productTypeModelList.size(); i++) {
            jedis.rpush("productTypeId", productTypeModelList.get(i).getId().toString());
            jedis.rpush("productTypeList", productTypeModelList.get(i).getType());
        }
        return productTypeModelList;
    }
}
