package com.cn.wanxi.util;

import com.cn.wanxi.model.AboutModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetAboutData {
    public static List<AboutModel> setDataFromRedis(Jedis jedis, long length){
        List<String> aboutId = jedis.lrange("aboutId", 0, length);
        List<String> aboutContent = jedis.lrange("aboutContent", 0, length);
        List<String> aboutImg = jedis.lrange("aboutImg", 0, length);
        List<String> aboutCreateTime = jedis.lrange("aboutCreateTime", 0, length);
        List<AboutModel> aboutModelList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            AboutModel aboutModel = new AboutModel();
            aboutModel.setId(Integer.parseInt(aboutId.get(i)));
            aboutModel.setContent(aboutContent.get(i));
            aboutModel.setImg(aboutImg.get(i));
            aboutModel.setCreateTime(aboutCreateTime.get(i));
            aboutModelList.add(aboutModel);
        }
        return aboutModelList;
    }

    public static List<AboutModel> setDataFromDataBase(List<AboutModel> aboutModelList,Jedis jedis){
        for (int i = 0; i < aboutModelList.size(); i++) {
            jedis.rpush("aboutId", aboutModelList.get(i).getId().toString());
            jedis.rpush("aboutContent", aboutModelList.get(i).getContent());
            jedis.rpush("aboutImg", aboutModelList.get(i).getImg());
//            jedis.rpush("aboutType", aboutModelList.get(i).getType());
            jedis.rpush("aboutCreateTime", aboutModelList.get(i).getCreateTime());
        }
        return aboutModelList;
    }
}
