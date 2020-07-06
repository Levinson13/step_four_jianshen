package com.cn.wanxi.util;

import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.NewsTypeModel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class SetNewsTypeData {

    public static List<NewsTypeModel> setNewsTypeFromRedis(Jedis jedis , long newsTypeLength){
        List<String> newsTypeId = jedis.lrange("newsTypeId", 0, newsTypeLength);
        List<String> newsTypeList = jedis.lrange("newsTypeList", 0, newsTypeLength);
        List<NewsTypeModel> newsTypeModelList = new ArrayList<>();
        for (int i = 0; i < newsTypeLength; i++) {
            NewsTypeModel newsTypeModel = new NewsTypeModel();
            newsTypeModel.setId(Integer.parseInt(newsTypeId.get(i)));
            newsTypeModel.setType(newsTypeList.get(i));
            newsTypeModelList.add(newsTypeModel);
        }
        return newsTypeModelList;
    }

    public static List<NewsTypeModel> setNewsTypeFromDataBase(List<NewsTypeModel> newsTypeModelList,Jedis jedis){
        for (int i = 0; i < newsTypeModelList.size(); i++) {
            jedis.rpush("newsTypeId", newsTypeModelList.get(i).getId().toString());
            jedis.rpush("newsTypeList", newsTypeModelList.get(i).getType());
        }
        return newsTypeModelList;
    }

}
